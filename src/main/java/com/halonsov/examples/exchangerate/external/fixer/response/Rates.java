package com.halonsov.examples.exchangerate.external.fixer.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
    @JsonProperty("MXN")
    private Float mxn;

    @JsonProperty("USD")
    private Float usd;

    public Rates() {
    }

    public Rates(Float mxn, Float usd) {
        this.mxn = mxn;
        this.usd = usd;
    }

    public Float getMxn() {
        return this.mxn;
    }

    public void setMxn(Float mxn) {
        this.mxn = mxn;
    }

    public Float getUsd() {
        return this.usd;
    }

    public void setUsd(Float usd) {
        this.usd = usd;
    }
    
}
