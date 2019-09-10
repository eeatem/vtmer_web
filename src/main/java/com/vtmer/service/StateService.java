package com.vtmer.service;

import com.vtmer.domain.User;

public interface StateService {
    // 根据学号以及第一或第二志愿改变用户的面试/录取状态
    public boolean updateStatusByStudentNumberAndFlag(long studentNumber, int volunteerFlag, String volunteerStatus);

    // 根据学号和第一或第二志愿以及旧状态改变用户的面试/录取状态
    public boolean updateStatusByStudentNumberAndFlagAndOldStatus(long studentNumber, int volunteerFlag, String oldVolunteerStatus, String newVolunteerStatus);

    // 根据学号以及第一或第二志愿获取面试/录取状态
    public String gainStatusByStudentNumberAndFlag(long studentNumber, int volunteerFlag);

    // 根据组别发起笔试/面试
    public int startExamByGroup(String groupName, int adminId);

    // 根据组别结束笔试/面试
    public int endExamByGroup(String groupName, int adminId);
}
