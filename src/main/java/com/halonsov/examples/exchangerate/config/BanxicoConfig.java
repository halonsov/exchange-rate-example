package com.halonsov.examples.exchangerate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "exchangerate.banxico")
public class BanxicoConfig {
    private String token;
    private String url;
    private long yesterday;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getYesterday() {
        return this.yesterday;
    }

    public void setYesterday(long yesterday) {
        this.yesterday = yesterday;
    }
    
}
