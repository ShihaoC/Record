package com.cui.Record.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mysql")
public class SQLConfig {
    private String url;
    private String user;
    private String password;
    private String database;
    private String EULA;

    public SQLConfig() {
    }

    public SQLConfig(String url, String user, String password, String database, String EULA) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.database = database;
        this.EULA = EULA;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getEULA() {
        return EULA;
    }

    public void setEULA(String EULA) {
        this.EULA = EULA;
    }

    @Override
    public String toString() {
        return "SQLConfig{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", database='" + database + '\'' +
                ", EULA='" + EULA + '\'' +
                '}';
    }
}
