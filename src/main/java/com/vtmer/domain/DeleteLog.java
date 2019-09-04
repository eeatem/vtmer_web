package com.vtmer.domain;

public class DeleteLog {
    private Integer id;

    private Integer userId;

    private Integer adminId;

    private Long operationalTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
}