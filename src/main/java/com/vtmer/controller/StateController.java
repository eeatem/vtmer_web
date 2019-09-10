package com.vtmer.controller;

import com.vtmer.common.ResponseMessage;
import com.vtmer.service.AdminService;
import com.vtmer.service.StateService;
import com.vtmer.service.StatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StateService stateService;

    @Autowired
    private StatusLogService statusLogService;

    /**
     * func：管理员修改单个报名者面试状态接口
     * @param studentNumber
     * @param volunteerFlag
     * @param volunteerStatus
     * @param request
     * @return
     */
    @PutMapping("/update")
    public ResponseMessage updateOne(long studentNumber, int volunteerFlag, String volunteerStatus,
                                     HttpServletRequest request) {
        int adminId = adminService.gainAdminIdBySession(request);
        String oldVolunteerStatus = stateService.gainStatusByStudentNumberAndFlag(studentNumber, volunteerFlag);
        if (stateService.updateStatusByStudentNumberAndFlag(studentNumber, volunteerFlag, volunteerStatus)) {
            statusLogService.addUpdateVolunteerStatusLog(adminId, studentNumber, volunteerFlag, oldVolunteerStatus, volunteerStatus);
            return ResponseMessage.newSuccessInstance("面试/录取状态修改成功");
        }
        return ResponseMessage.newErrorInstance("面试/录取状态修改失败");
    }

    /**
     * func：管理员发起考试接口
     * @param groupName
     * @param request
     * @return
     */
    @PutMapping("/startExam")
    public ResponseMessage startExamByGroup(String groupName, HttpServletRequest request) {
        int examUserNum = stateService.startExamByGroup(groupName, adminService.gainAdminIdBySession(request));
        if (examUserNum != 0) {
            return ResponseMessage.newSuccessInstance(examUserNum, "考试发起成功");
        }
        return ResponseMessage.newErrorInstance("考试发起失败");
    }

    /**
     * func：管理员结束考试接口
     * @param groupName
     * @param request
     * @return
     */
    @PutMapping("/endExam")
    public ResponseMessage endExamByGroup(String groupName, HttpServletRequest request) {
        int examUserNum = stateService.endExamByGroup(groupName, adminService.gainAdminIdBySession(request));
        if (examUserNum != 0) {
            return ResponseMessage.newSuccessInstance(examUserNum, "考试结束成功");
        }
        return ResponseMessage.newErrorInstance("考试结束失败");
    }

}
