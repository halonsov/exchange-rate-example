package com.halonsov.examples.exchangerate.controller.response;

import java.util.List;
import com.halonsov.examples.exchangerate.controller.response.enums.StatusEnum;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ExchangeRatesResponse", description = "Entity containing exchange rates response.")
public class ExchangeRatesResponse extends GeneralResponse {
    private ExchangeRates rates;

    public ExchangeRatesResponse() {
        super();
    }

    public ExchangeRatesResponse(ExchangeRates rates, StatusEnum status, List<String> errors) {
        this.rates = rates;
        this.status = status;
        this.errors = errors;
    }

    public ExchangeRates getRates() {
        return this.rates;
    }

    public void setRates(ExchangeRates rates) {
        this.rates = rates;
    }

}
