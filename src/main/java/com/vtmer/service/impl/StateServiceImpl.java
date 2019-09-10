package com.vtmer.service.impl;

import com.vtmer.domain.State;
import com.vtmer.domain.StateExample;
import com.vtmer.domain.User;
import com.vtmer.domain.UserExample;
import com.vtmer.mapper.StateMapper;
import com.vtmer.mapper.UserMapper;
import com.vtmer.service.StateService;
import com.vtmer.service.StatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StateMapper stateMapper;

    @Autowired
    StatusLogService statusLogService;

    // 根据学号以及第一或第二志愿改变用户的面试状态
    @Override
    public boolean updateStatusByStudentNumberAndFlag
    (long studentNumber, int volunteerFlag, String volunteerStatus) {
        State volunteerState = new State();
        volunteerState.setStatus(volunteerStatus);
        StateExample example = new StateExample();
        StateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(studentNumber).andFlagEqualTo(volunteerFlag);
        if (stateMapper.updateByExampleSelective(volunteerState, example) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStatusByStudentNumberAndFlagAndOldStatus
            (long studentNumber, int volunteerFlag, String oldVolunteerStatus, String newVolunteerStatus) {
        State volunteerState = new State();
        volunteerState.setStatus(newVolunteerStatus);
        StateExample example = new StateExample();
        StateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(studentNumber).andFlagEqualTo(volunteerFlag).andStatusEqualTo(oldVolunteerStatus);
        if (stateMapper.updateByExampleSelective(volunteerState, example) == 1) {
            return true;
        }
        return false;
    }

    // 根据学号以及第一或第二志愿获取面试/录取状态
    @Override
    public String gainStatusByStudentNumberAndFlag(long studentNumber, int volunteerFlag) {
        StateExample example = new StateExample();
        StateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(studentNumber).andFlagEqualTo(volunteerFlag);
        String status = null;
        for (State state :
                stateMapper.selectByExample(example)) {
            status = state.getStatus();
        }
        return status;


    }

    // 根据组别发起笔试/面试
    @Override
    public int startExamByGroup(String groupName, int adminId) {
        int updateNumber = 0;
        // 根据组别查出所有用户
        UserExample example = new UserExample();
        example.or().andFirstVolunteerEqualTo(groupName);
        example.or().andSecondVolunteerEqualTo(groupName);
        List<User> users = userMapper.selectByExample(example);
        // 分别根据查出用户的学号返回一二志愿，再分别对一二志愿进行组别匹配，
        // 若为给出的组别则将根据该用户的学号和志愿flag修改该用户的面试状态
        for (User user :
                users) {
            if (user.getFirstVolunteer() != null && user.getFirstVolunteer().equals(groupName)) {
                if (this.updateStatusByStudentNumberAndFlagAndOldStatus(user.getStudentNumber(), 1, "待面试", "面试中")) {
                    statusLogService.addUpdateVolunteerStatusLog(adminId, user.getStudentNumber(), 1, "待面试", "面试中");
                    updateNumber++;
                }
            }
            if (user.getSecondVolunteer() != null && user.getSecondVolunteer().equals(groupName)) {
                if (this.updateStatusByStudentNumberAndFlagAndOldStatus(user.getStudentNumber(), 2, "待面试", "面试中")) {
                    statusLogService.addUpdateVolunteerStatusLog(adminId, user.getStudentNumber(), 2, "待面试", "面试中");
                    updateNumber++;
                }
            }
        }
        return updateNumber;
    }

    @Override
    public int endExamByGroup(String groupName, int adminId) {
        int updateNumber = 0;
        // 根据组别查出所有用户
        UserExample example = new UserExample();
        example.or().andFirstVolunteerEqualTo(groupName);
        example.or().andSecondVolunteerEqualTo(groupName);
        List<User> users = userMapper.selectByExample(example);
        // 分别根据查出用户的学号返回一二志愿，再分别对一二志愿进行组别匹配，
        // 若为给出的组别则将根据该用户的学号和志愿flag修改该用户的面试状态
        for (User user :
                users) {
            if (user.getFirstVolunteer() != null && user.getFirstVolunteer().equals(groupName)) {
                String oldVolunteerStatus = this.gainStatusByStudentNumberAndFlag(user.getStudentNumber(), 1);
                if (!oldVolunteerStatus.equals("录取") && !oldVolunteerStatus.equals("不录取")) {
                    if (this.updateStatusByStudentNumberAndFlag(user.getStudentNumber(), 1, "不录取")) {
                        statusLogService.addUpdateVolunteerStatusLog(adminId, user.getStudentNumber(), 1, oldVolunteerStatus, "不录取");
                        updateNumber++;
                    }
                }
            }
            if (user.getSecondVolunteer() != null && user.getSecondVolunteer().equals(groupName)) {
                String oldVolunteerStatus = this.gainStatusByStudentNumberAndFlag(user.getStudentNumber(), 2);
                if (!oldVolunteerStatus.equals("录取") && !oldVolunteerStatus.equals("不录取")) {
                    if (this.updateStatusByStudentNumberAndFlag(user.getStudentNumber(), 2, "不录取")) {
                        statusLogService.addUpdateVolunteerStatusLog(adminId, user.getStudentNumber(), 2, oldVolunteerStatus, "不录取");
                        updateNumber++;
                    }
                }
            }
        }
        return updateNumber;
    }

}
