package com.elikhcode.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public void registerClient(@RequestBody  ClientRegistrationRequest request){
        log.info("new client registration {}", request);
        clientService.registerClient(request);
    }
}
