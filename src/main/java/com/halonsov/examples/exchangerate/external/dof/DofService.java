package com.halonsov.examples.exchangerate.external.dof;

import com.halonsov.examples.exchangerate.config.DofConfig;
import com.halonsov.examples.exchangerate.utils.ExchangeRate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DofService {
    @Autowired
    private DofConfig config;

    public ExchangeRate getExchangeRate() {
		try {
			Document document = Jsoup.connect(config.getUrl()).get();
            return new ExchangeRate(
                this.getExchangeDate(document),
                this.getExchange(document)
            );
		} catch (IOException e) {
			e.printStackTrace();
		}
        return new ExchangeRate();
    }

    private Date getExchangeDate(Document document) {
        try {
            Elements clases = document.getElementsByClass(config.getDateClass());
            Matcher matcher = Pattern.compile(config.getDateRegex()).matcher(clases.get(0).text());
            if (matcher.find()) {
                DateFormat sourceFormat = new SimpleDateFormat(config.getDateFormat());
                return sourceFormat.parse(matcher.group());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Float getExchange(Document document) {
        try {
            Elements elements = document.getElementById(config.getExchangeId()).getElementsByTag(config.getExchangeTag());
            for (Element elem : elements) {
                if (elem.text().contains(config.getExchangeSearch())) {
                    String[] parts = elem.text().split(" ");
                    return Float.parseFloat(parts[1]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
