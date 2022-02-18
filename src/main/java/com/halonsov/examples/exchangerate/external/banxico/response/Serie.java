package com.halonsov.examples.exchangerate.external.banxico.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

@XmlRootElement(name = "serie")
@XmlAccessorType(XmlAccessType.NONE)
public class Serie {
    @XmlAttribute
    private String idSerie;

    @XmlAttribute
    private String titulo;

    @JacksonXmlElementWrapper(localName = "Obs")
    private Obs Obs;

    @XmlElement(name = "Obs")
    private Obs obs;

    public Serie() {
    }

    public Serie(String idSerie, String titulo, Obs obs) {
        this.idSerie = idSerie;
        this.titulo = titulo;
        this.Obs = obs;
    }

    public String getIdSerie() {
        return this.idSerie;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Obs getObs() {
        return this.Obs;
    }

    public void setObs(Obs obs) {
        this.Obs = obs;
    }
}
