package com.halonsov.examples.exchangerate.controller;

import com.halonsov.examples.exchangerate.controller.response.ExchangeRatesResponse;
import com.halonsov.examples.exchangerate.service.ExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/v1/exchange")
@SecurityRequirement(name = "exchangerateapi")
public class ExchangeController {
    @Autowired
    private ExchangeService exchange;

    /**
     * Service to get exchange rate
     *
     * @return result exchangerate
     */
    @ApiOperation(value = "transfer", response = Object.class, nickname = "transfer", httpMethod = "GET")
    @GetMapping
    public ResponseEntity<ExchangeRatesResponse> transfer() {
        return new ResponseEntity<>(
            exchange.getExchange(),
            HttpStatus.OK
        );
    }
}
