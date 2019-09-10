package com.vtmer.service;

public interface DeleteLogService {
    // 记录删除用户操作
    public int addDeleteLog(Integer adminId, Long studentNumber);
}
