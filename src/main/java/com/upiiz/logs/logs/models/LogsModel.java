package com.upiiz.logs.logs.models;

import java.sql.Date;

public class LogsModel {
    private Long logId;
    private Date logDate;
    private Long userId;
    private String action;

    public LogsModel() {
    }

    public Long getLogId() {
        return logId;
    }
    public void setLogId(Long logId) {
        this.logId = logId;
    }
    public Date getLogDate() {
        return logDate;
    }
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    
}
