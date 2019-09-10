package com.vtmer.service;

public interface StatusLogService {
    // 添加管理员对用户志愿的面试/录取状态的记录
    public boolean addUpdateVolunteerStatusLog(int adminId, long studentNumber, int volunteerFlag, String volunteerOldStatus,
                                               String volunteerNewStatus);
}
