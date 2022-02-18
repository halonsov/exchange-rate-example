package com.halonsov.examples.exchangerate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "exchangerate.fixer")
public class FixerConfig {
    private String url;
    private String accessKey;
    private String symbols;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSymbols() {
        return this.symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }   
}
