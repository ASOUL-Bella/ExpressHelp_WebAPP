package com.wcy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wcy.domain.PageListRes;
import com.wcy.domain.User;
import com.wcy.mapper.UserMapper;
import com.wcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageListRes getAllUsers() {
        /*调用mapper 查询用户 */
        Page<Object> page = PageHelper.startPage(1,10);
        List<User> users = userMapper.selectAll();
        /*封装成pageList*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(users);
        return pageListRes;
    }

    @Override
    public void createUser(User user) {
        /*新增用户*/
        userMapper.insert(user);
    }

    @Override
    public User selectUserById(String openid) {
        /*根据id查询用户*/
        User user = userMapper.selectByPrimaryKey(openid);
        return user;
    }

    @Override
    public void updateUserById(User user) {
        /*根据id更新用户*/
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUserById(String openid) {
        /*根据id删除用户*/
        userMapper.deleteByPrimaryKey(openid);
    }

}
