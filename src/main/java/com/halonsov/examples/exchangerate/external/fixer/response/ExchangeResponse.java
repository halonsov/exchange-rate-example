package com.halonsov.examples.exchangerate.external.fixer.response;

import java.util.Date;

import com.halonsov.examples.exchangerate.utils.ExchangeEnums;
import com.halonsov.examples.exchangerate.utils.ExchangeRate;

public class ExchangeResponse {
    private boolean success;
    private long timestamp;
    private ExchangeEnums base;
    private Date date;
    private Rates rates;

    public boolean isSuccess() {
        return this.success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ExchangeEnums getBase() {
        return this.base;
    }

    public void setBase(ExchangeEnums base) {
        this.base = base;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rates getRates() {
        return this.rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public ExchangeRate toEchangeRate() {
        return new ExchangeRate(
            new Date(this.timestamp*1000L),
            this.rates.getMxn() / this.rates.getUsd()
        );
    }

}
