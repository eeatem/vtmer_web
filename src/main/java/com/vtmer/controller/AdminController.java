package com.vtmer.controller;

import com.vtmer.common.ResponseMessage;
import com.vtmer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * func：管理员登陆接口
     * @param userName
     * @param password
     * @param session
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResponseMessage adminLogin(@RequestParam("userName") String userName,
                                      @RequestParam("password") String password,
                                      HttpSession session,
                                      HttpServletResponse response) {
        if (adminService.selectAdminByUserName(userName) == null) {
            return ResponseMessage.newErrorInstance("用户名不存在");
        }
        if (adminService.authenticationLogin(userName, password) == false) {
            return ResponseMessage.newErrorInstance("密码错误，登陆失败");
        } else {
            // 把管理员账户名和组别(管理员信息)存入Cookie中
            // Cookie cookie = new Cookie("sessionId",userName);
            // response.addCookie(cookie);

            // 把管理员账户名和组别(管理员信息)存入Session中
            session.setAttribute("adminInfo", adminService.selectAdminByUserName(userName));
            return ResponseMessage.newSuccessInstance("登陆成功");
        }
    }

    /**
     * func：管理员退出接口
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public ResponseMessage adminLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("adminInfo");
        return ResponseMessage.newSuccessInstance("退出登陆成功");
    }


}
