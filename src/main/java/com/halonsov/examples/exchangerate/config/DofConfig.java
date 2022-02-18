package com.halonsov.examples.exchangerate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "exchangerate.dof")
public class DofConfig {
    private String url;
    private String dateRegex;
    private String dateClass;
    private String dateFormat;
    private String exchangeId;
    private String exchangeTag;
    private String exchangeSplit;
    private String exchangeSearch;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDateRegex() {
        return this.dateRegex;
    }

    public void setDateRegex(String dateRegex) {
        this.dateRegex = dateRegex;
    }

    public String getDateClass() {
        return this.dateClass;
    }

    public void setDateClass(String dateClass) {
        this.dateClass = dateClass;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getExchangeId() {
        return this.exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getExchangeTag() {
        return this.exchangeTag;
    }

    public void setExchangeTag(String exchangeTag) {
        this.exchangeTag = exchangeTag;
    }

    public String getExchangeSplit() {
        return this.exchangeSplit;
    }

    public void setExchangeSplit(String exchangeSplit) {
        this.exchangeSplit = exchangeSplit;
    }

    public String getExchangeSearch() {
        return this.exchangeSearch;
    }

    public void setExchangeSearch(String exchangeSearch) {
        this.exchangeSearch = exchangeSearch;
    }

}
