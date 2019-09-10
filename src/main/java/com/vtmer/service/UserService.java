package com.vtmer.service;

import com.vtmer.domain.User;

import java.util.List;

public interface UserService {

    // 返回所有用户信息
    public List<User> selectAllUser();

    // 根据学号返回用户信息
    public User selectUserByStudentNumber(Long studentNumber);

    // 根据学号删除用户
    public int deleteUserByStudentNumber(Long studentNumber);

    // 根据学号修改用户信息
    public int updateUserProfileByStudentNumber(User user);

}
