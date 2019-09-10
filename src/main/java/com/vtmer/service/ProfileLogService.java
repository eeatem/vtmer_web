package com.vtmer.service;

import com.vtmer.domain.User;

import java.util.List;

public interface ProfileLogService {
    // 管理员对用户数据进行修改的记录
    public List<String> updateProfileLog(Integer AdminId, User user);
}
