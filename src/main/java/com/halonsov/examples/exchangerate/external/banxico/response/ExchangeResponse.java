package com.halonsov.examples.exchangerate.external.banxico.response;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "series")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeResponse {
    @XmlElement
    private Serie serie;

    public ExchangeResponse() {
    }

    public ExchangeResponse(Serie serie) {
        this.serie = serie;
    }

    public Serie getSerie() {
        return this.serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
