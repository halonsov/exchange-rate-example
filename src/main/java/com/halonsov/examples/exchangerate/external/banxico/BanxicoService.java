package com.halonsov.examples.exchangerate.external.banxico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.halonsov.examples.exchangerate.config.BanxicoConfig;
import com.halonsov.examples.exchangerate.external.banxico.response.ExchangeResponse;
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
public class BanxicoService {
    @Autowired
    private BanxicoConfig config;

    public ExchangeRate getExchangeRate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date yesterday = new Date();
        yesterday.setTime(yesterday.getTime() - config.getYesterday());
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
            config.getUrl() + dateFormat.format(yesterday) + "/" + dateFormat.format(new Date())
        ).queryParam("token", config.getToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ExchangeResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                ExchangeResponse.class);
        if (response.getBody() != null && response.getBody().getSerie() != null && response.getBody().getSerie().getObs() != null) {
            return new ExchangeRate(
                response.getBody().getSerie().getObs().getFecha(),
                response.getBody().getSerie().getObs().getDato()
            );
        }
        return null;
    }
}
