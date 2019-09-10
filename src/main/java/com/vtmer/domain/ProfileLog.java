package com.vtmer.domain;

public class ProfileLog {
    private Integer id;

    private Long userId;

    private Integer adminId;

    private Long operationalTime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Long getOperationalTime() {
        return operationalTime;
    }

    public void setOperationalTime(Long operationalTime) {
        this.operationalTime = operationalTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}