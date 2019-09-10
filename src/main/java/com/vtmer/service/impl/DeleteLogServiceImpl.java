package com.vtmer.service.impl;

import com.vtmer.domain.DeleteLog;
import com.vtmer.mapper.DeleteLogMapper;
import com.vtmer.service.DeleteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeleteLogServiceImpl implements DeleteLogService {

    @Autowired
    DeleteLogMapper deleteLogMapper;

    // 记录删除用户操作
    @Override
    public int addDeleteLog(Integer adminId, Long studentNumber) {
        DeleteLog log = new DeleteLog();
        Date date = new Date();
        long timestamp = date.getTime();
        log.setOperationalTime(timestamp);
        log.setAdminId(adminId);
        log.setUserId(studentNumber);
        return deleteLogMapper.insert(log);
    }
}
