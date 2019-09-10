package com.vtmer.service.impl;

import com.vtmer.common.LogUtils;
import com.vtmer.domain.ProfileLog;
import com.vtmer.domain.User;
import com.vtmer.mapper.ProfileLogMapper;
import com.vtmer.mapper.UserMapper;
import com.vtmer.service.ProfileLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProfileLogServiceImpl implements ProfileLogService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProfileLogMapper profileLogMapper;

    // 管理员对用户数据进行修改的记录
    @Override
    public List<String> updateProfileLog(Integer adminId, User user) {
        // 创建一个List收集信息的变化
        List<String> updateLog = new ArrayList<>();
        // 读取用户资料被修改前的原始数据
        User originalData = userMapper.selectByPrimaryKey(user.getStudentNumber());
        // 将新数据与原始数据进行比较，并记录发生变化的数据字段及变化前后的内容
        LogUtils.addUpdateProfileLog(updateLog, "avatar", originalData.getAvatar(), user.getAvatar());
        LogUtils.addUpdateProfileLog(updateLog, "name", originalData.getName(), user.getName());
        LogUtils.addUpdateProfileLog(updateLog, "sex", originalData.getSex(), user.getSex());
        LogUtils.addUpdateProfileLog(updateLog, "grade", originalData.getGrade(), user.getGrade());
        LogUtils.addUpdateProfileLog(updateLog, "college", originalData.getCollege(), user.getCollege());
        LogUtils.addUpdateProfileLog(updateLog, "major", originalData.getMajor(), user.getMajor());
        LogUtils.addUpdateProfileLog(updateLog, "classes", originalData.getClasses(), user.getClasses());
        LogUtils.addUpdateProfileLog(updateLog, "qq", originalData.getQq(), user.getQq());
        LogUtils.addUpdateProfileLog(updateLog, "phone", originalData.getPhone(), user.getPhone());
        LogUtils.addUpdateProfileLog(updateLog, "wechat", originalData.getWechat(), user.getWechat());
        LogUtils.addUpdateProfileLog(updateLog, "first_volunteer", originalData.getFirstVolunteer(), user.getFirstVolunteer());
        LogUtils.addUpdateProfileLog(updateLog, "second_volunteer", originalData.getSecondVolunteer(), user.getSecondVolunteer());
        LogUtils.addUpdateProfileLog(updateLog, "self_introduction", originalData.getSelfIntroduction(), user.getSelfIntroduction());
        // 将记录插入数据库中
        ProfileLog record = new ProfileLog();
        record.setUserId(user.getStudentNumber());
        record.setAdminId(adminId);
        record.setContent(updateLog.toString());
        Date date = new Date();
        record.setOperationalTime(date.getTime());
        profileLogMapper.insertSelective(record);
        return updateLog;
    }
}
