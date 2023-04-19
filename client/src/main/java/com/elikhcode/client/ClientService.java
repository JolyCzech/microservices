package com.elikhcode.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final RestTemplate restTemplate;


    public void registerClient(ClientRegistrationRequest request) {
        Client client = Client.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        //todo: check if email valid
        //todo: check if email not token
        clientRepository.saveAndFlush(client);
        //todo: check if scam
        Boolean isScammer = restTemplate.getForObject(
                "http://localhost:8081/api/v1/scam-check/{clientId}",
                Boolean.class,
                client.getId()
        );
        ScamCheckResponse scamCheckResponse = new ScamCheckResponse(isScammer);

        if (scamCheckResponse.isScammer()) {
            throw new IllegalStateException("Scammer");
        }

        //todo: send notification
    }
}
