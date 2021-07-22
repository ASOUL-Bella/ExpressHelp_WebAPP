package com.wcy.service;

import com.wcy.domain.PageListRes;
import com.wcy.domain.User;

public interface UserService {

    /*查询所有用户*/
    PageListRes getAllUsers();

    /*新增用户*/
    void createUser(User user);

    /*根据id查询用户*/
    User selectUserById(String openid);

    /*根据id更新用户*/
    void updateUserById(User user);

    /*根据id删除用户*/
    void deleteUserById(String id);

}

