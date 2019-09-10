package com.vtmer.service.impl;

import com.vtmer.domain.StatusLog;
import com.vtmer.mapper.StatusLogMapper;
import com.vtmer.service.StatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatusLogServiceImpl implements StatusLogService {

    @Autowired
    StatusLogMapper statusLogMapper;

    // 添加管理员对用户志愿的面试/录取状态的记录
    @Override
    public boolean addUpdateVolunteerStatusLog(int adminId, long studentNumber, int volunteerFlag, String volunteerOldStatus,
                                               String volunteerNewStatus) {
        StatusLog log = new StatusLog();
        log.setAdminId(adminId);
        log.setUserId(studentNumber);
        log.setVolunteerFlag(volunteerFlag);
        log.setOldStatus(volunteerOldStatus);
        log.setNewStatus(volunteerNewStatus);
        Date date = new Date();
        long timestamp = date.getTime();
        log.setOperationalTime(timestamp);
        if (statusLogMapper.insert(log) == 1) {
            return true;
        }
        return false;
    }

}
