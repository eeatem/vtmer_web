package com.vtmer.service.impl;

import com.vtmer.domain.User;
import com.vtmer.mapper.UserMapper;
import com.vtmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // 返回所有用户信息
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectByExample(null);
    }

    // 根据学号返回用户信息
    @Override
    public User selectUserByStudentNumber(Long studentNumber) {
        return userMapper.selectByPrimaryKey(studentNumber);
    }

    // 根据学号删除用户
    @Override
    public int deleteUserByStudentNumber(Long studentNumber) {
        return userMapper.deleteByPrimaryKey(studentNumber);
    }

    // 根据学号修改用户信息
    @Override
    public int updateUserProfileByStudentNumber(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


}
