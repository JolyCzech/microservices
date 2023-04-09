package com.elikhcode.scam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/scam-check")
@AllArgsConstructor
@Slf4j
public class ScamCheckController {

    private final ScamCheckService scamCheckService;

    @GetMapping(path = "{clientId}")
    public ScamCheckResponse isScam(
            @PathVariable("clientId") Integer clientID) {
        boolean isScamClient = scamCheckService.isScamClient(clientID);
        log.info("scam check request client {}",clientID);
        return new ScamCheckResponse(isScamClient);
    }
}
