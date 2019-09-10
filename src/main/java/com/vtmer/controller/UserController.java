package com.vtmer.controller;

import com.vtmer.common.ResponseMessage;
import com.vtmer.domain.User;
import com.vtmer.service.AdminService;
import com.vtmer.service.DeleteLogService;
import com.vtmer.service.ProfileLogService;
import com.vtmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProfileLogService profileLogService;

    @Autowired
    private DeleteLogService deleteLogService;

    /**
     * func：展示所有报名者信息接口
     * @return
     */
    @GetMapping("/list")
    public List<User> selectAll() {
        return userService.selectAllUser();
    }

    /**
     * func：根据学号返回报名者信息接口
     * @param studentNumber
     * @return
     */
    @GetMapping("/list/{id}")
    public ResponseMessage selectOne(@PathVariable("id") Long studentNumber) {
        User user = userService.selectUserByStudentNumber(studentNumber);
        if (user != null) {
            return ResponseMessage.newSuccessInstance(user, "查询成功");
        } else {
            return ResponseMessage.newErrorInstance("学号不存在");
        }
    }

    /**
     * func：管理员修改报名者信息接口
     * @param request
     * @param user
     * @return
     */
    @PutMapping("/update")
    public ResponseMessage updateOne(@RequestBody User user, HttpServletRequest request) {
        System.out.println("尝试进行信息更新");
        // 从session中获取管理员id
        int adminId = adminService.gainAdminIdBySession(request);
        List<String> updateLog = profileLogService.updateProfileLog(adminId, user);
        if (userService.updateUserProfileByStudentNumber(user) == 1) {
            return ResponseMessage.newSuccessInstance(updateLog, "信息修改成功");
        }
        return ResponseMessage.newErrorInstance("信息修改失败");
    }

    /**
     * func：管理员删除报名者信息接口
     * @param studentNumber
     * @param request
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseMessage deleteOne(@PathVariable("id") Long studentNumber, HttpServletRequest request) {
        // 从session中获取管理员id
        int adminId = adminService.gainAdminIdBySession(request);
        User user = userService.selectUserByStudentNumber(studentNumber);
        if (user != null) {
            String userName = user.getName();
            if (userService.deleteUserByStudentNumber(studentNumber) == 1) {
                deleteLogService.addDeleteLog(adminId, studentNumber);
                return ResponseMessage.newSuccessInstance(userName, "删除成功");
            }
        }
        return ResponseMessage.newErrorInstance("删除失败");
    }

}
