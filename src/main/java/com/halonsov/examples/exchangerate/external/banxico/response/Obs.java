package com.halonsov.examples.exchangerate.external.banxico.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name = "Obs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Obs {
    @XmlElement
    private Float dato;

    @XmlElement
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fecha;

    public Obs() {
    }

    public Obs(Float dato, Date fecha) {
        this.dato = dato;
        this.fecha = fecha;
    }

    public Float getDato() {
        return this.dato;
    }

    public void setDato(Float dato) {
        this.dato = dato;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }    
}
