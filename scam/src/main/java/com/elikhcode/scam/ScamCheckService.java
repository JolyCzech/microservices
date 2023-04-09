package com.elikhcode.scam;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ScamCheckService {

    private final ScamCheckHistoryRepository scamCheckHistoryRepository;

    public boolean isScamClient(Integer clientId){
        //todo: check client

        scamCheckHistoryRepository.save(
                ScamCheckHistory.builder()
                        .clientId(clientId)
                        .isScammer(false)
                        .createdAt(LocalDateTime.now())
                .build()
        );

        return false;
    }
}
