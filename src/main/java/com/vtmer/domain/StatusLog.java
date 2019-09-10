package com.vtmer.domain;

public class StatusLog {
    private Integer id;

    private Long userId;

    private Integer adminId;

    private String oldStatus;

    private String newStatus;

    private Integer volunteerFlag;

    private Long operationalTime;

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

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus == null ? null : oldStatus.trim();
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus == null ? null : newStatus.trim();
    }

    public Integer getVolunteerFlag() {
        return volunteerFlag;
    }

    public void setVolunteerFlag(Integer volunteerFlag) {
        this.volunteerFlag = volunteerFlag;
    }

    public Long getOperationalTime() {
        return operationalTime;
    }

    public void setOperationalTime(Long operationalTime) {
        this.operationalTime = operationalTime;
    }
}