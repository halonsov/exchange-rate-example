package com.halonsov.examples.exchangerate.utils;

import java.util.Date;

public class ExchangeRate {
    private Date lastUpdated;
    private Float value;

    public ExchangeRate() {
    }    

    public ExchangeRate(Date lastUpdated, Float value) {
        this.lastUpdated = lastUpdated;
        this.value = value;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
