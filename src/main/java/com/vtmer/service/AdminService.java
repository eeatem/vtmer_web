package com.vtmer.service;

import com.vtmer.domain.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface AdminService {

    // 根据用户名查找管理员账户
    public Admin selectAdminByUserName(String userName);

    // 判断用户名是否与密码匹配
    public boolean authenticationLogin(String userName, String password);

    // 从session中获取管理员id
    public int gainAdminIdBySession(HttpServletRequest request);

    // 从session中获取管理员组别
    public String gainAdminGroupBySession(HttpServletRequest request);

}
