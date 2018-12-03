package com.ud.basic.system.persistence.sys.auto.model;

public class SysFhlog {
    private String fhlogId;

    private String username;

    private String cztime;

    private String content;

    public String getFhlogId() {
        return fhlogId;
    }

    public void setFhlogId(String fhlogId) {
        this.fhlogId = fhlogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCztime() {
        return cztime;
    }

    public void setCztime(String cztime) {
        this.cztime = cztime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}