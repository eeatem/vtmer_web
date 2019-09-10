package com.vtmer.recruit;

import com.vtmer.common.LogUtils;
import com.vtmer.domain.User;
import com.vtmer.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试管理员对用户数据进行修改的记录
 */
public class UpdateLogTest extends RecruitApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void Test1() {
        User user = new User();
        int sn = 123;
        Long sn1 = (long)sn;
        user.setStudentNumber(sn1);
        user.setName("asdfgh");
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
        System.out.println(updateLog);
    }

    @Test
    public void Test2() {
        System.out.println(LogUtils.UpdateProfileLog("qwe", "123", "asd"));

    }

}
