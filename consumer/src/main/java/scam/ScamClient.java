package scam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "scam",
        url = "${consumer.scam.url}"
)
public interface ScamClient {

    @GetMapping(path = "api/v1/scam-check/{clientId}")
    ScamCheckResponse isScammer(
            @PathVariable("clientId") Integer clientId);

}