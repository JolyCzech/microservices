package com.elikhcode.client;

import com.elikhcode.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import scam.ScamCheckResponse;
import scam.ScamClient;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final ScamClient scamClient;


    public void registerClient(ClientRegistrationRequest request) {
        Client client = Client.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        //todo: check if email valid
        //todo: check if email not token
        clientRepository.saveAndFlush(client);

        ScamCheckResponse scamCheckResponse =
                scamClient.isScammer(client.getId());

        if (scamCheckResponse.isScammer()) {
            throw new IllegalStateException("Scammer");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                client.getId(),
                client.getEmail(),
                String.format("Hi %s, welcome to Elikhcode...",
                        client.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
