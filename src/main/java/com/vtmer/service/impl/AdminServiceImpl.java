package com.vtmer.service.impl;

import com.vtmer.domain.Admin;
import com.vtmer.domain.AdminExample;
import com.vtmer.mapper.AdminMapper;
import com.vtmer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    // 根据用户名查找管理员账户
    @Override
    public Admin selectAdminByUserName(String userName) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(userName);
        Admin result = null;
        for (Admin admin :
                adminMapper.selectByExample(example)) {
            result = admin;
        }
        return result;
    }

    // 判断用户名是否与密码匹配
    @Override
    public boolean authenticationLogin(String userName, String password) {
        boolean flag = password.equals(this.selectAdminByUserName(userName).getPassword());
        return flag;
    }

    // 从session中获取管理员id
    @Override
    public int gainAdminIdBySession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminInfo");
        int adminId = admin.getId();
        return adminId;
    }

}
