package com.halonsov.examples.exchangerate.external.fixer;

import com.halonsov.examples.exchangerate.config.FixerConfig;
import com.halonsov.examples.exchangerate.external.fixer.response.ExchangeResponse;
import com.halonsov.examples.exchangerate.utils.ExchangeRate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FixerService {
    @Autowired
    private FixerConfig config;

    public ExchangeRate getExchangeRate() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUrl())
                .queryParam("access_key", config.getAccessKey())
                .queryParam("symbols", config.getSymbols());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ExchangeResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                ExchangeResponse.class);
        return response.getBody().toEchangeRate();
    }
}
