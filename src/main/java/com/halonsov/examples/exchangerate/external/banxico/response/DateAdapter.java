package com.halonsov.examples.exchangerate.external.banxico.response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

class DateAdapter extends XmlAdapter<String, Date> {
    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date unmarshal(String v) throws Exception {
        return f.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return f.format(v);
    }
}

