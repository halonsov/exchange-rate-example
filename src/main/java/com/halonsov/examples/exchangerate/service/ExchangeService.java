package com.halonsov.examples.exchangerate.service;

import java.util.ArrayList;

import com.halonsov.examples.exchangerate.controller.response.ExchangeRates;
import com.halonsov.examples.exchangerate.controller.response.ExchangeRatesResponse;
import com.halonsov.examples.exchangerate.controller.response.enums.StatusEnum;
import com.halonsov.examples.exchangerate.external.banxico.BanxicoService;
import com.halonsov.examples.exchangerate.external.dof.DofService;
import com.halonsov.examples.exchangerate.external.fixer.FixerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    @Autowired
    private FixerService fixer;

    @Autowired
    private BanxicoService banxico;

    @Autowired
    private DofService dofService;

    public ExchangeRatesResponse getExchange() {
        return new ExchangeRatesResponse(
            new ExchangeRates(
                dofService.getExchangeRate(),
                fixer.getExchangeRate(),
                banxico.getExchangeRate()
            ),
            StatusEnum.OK,
            new ArrayList<>()
        );
    }
}
