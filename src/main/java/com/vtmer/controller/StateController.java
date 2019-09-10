package com.vtmer.controller;

import com.vtmer.common.ResponseMessage;
import com.vtmer.domain.State;
import com.vtmer.service.AdminService;
import com.vtmer.service.StateService;
import com.vtmer.service.StatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * func：管理员更新单个报名者信息接口
     *
     * @param state
     * @param request
     * @return
     */
    @PutMapping("/update")
    public ResponseMessage updateOne(@RequestBody State state, HttpServletRequest request) {
        long studentNumber = state.getUserId();
        int volunteerFlag = state.getFlag();
        String volunteerStatus = state.getStatus();
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
     *
     * @param groupName
     * @param request
     * @return
     */
    @PutMapping("/startExam")
    public ResponseMessage startExamByGroup(@RequestBody String groupName, HttpServletRequest request) {
        int examUserNum = stateService.startExamByGroup(groupName, adminService.gainAdminIdBySession(request));
        if (examUserNum != 0) {
            return ResponseMessage.newSuccessInstance(examUserNum, "考试发起成功");
        }
        return ResponseMessage.newErrorInstance("考试发起失败");
    }

    /**
     * func：管理员结束考试接口
     *
     * @param groupName
     * @param request
     * @return
     */
    @PutMapping("/endExam")
    public ResponseMessage endExamByGroup(@RequestBody String groupName, HttpServletRequest request) {
        int examUserNum = stateService.endExamByGroup(groupName, adminService.gainAdminIdBySession(request));
        if (examUserNum != 0) {
            return ResponseMessage.newSuccessInstance(examUserNum, "考试结束成功");
        }
        return ResponseMessage.newErrorInstance("考试结束失败");
    }

}
