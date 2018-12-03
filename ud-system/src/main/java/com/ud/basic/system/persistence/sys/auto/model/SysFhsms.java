package com.ud.basic.system.persistence.sys.auto.model;

public class SysFhsms {
    private String fhsmsId;

    private String content;

    private String type;

    private String toUsername;

    private String fromUsername;

    private String sendTime;

    private String status;

    private String sanmeId;

    public String getFhsmsId() {
        return fhsmsId;
    }

    public void setFhsmsId(String fhsmsId) {
        this.fhsmsId = fhsmsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSanmeId() {
        return sanmeId;
    }

    public void setSanmeId(String sanmeId) {
        this.sanmeId = sanmeId;
    }
}