package com.elikhcode.client;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public void registerClient(ClientRegistrationRequest request) {
        Client client = Client.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        //todo: check if email valid
        //todo: check if email not token
        //todo: check if client in db
    }
}
