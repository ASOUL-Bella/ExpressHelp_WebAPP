package com.wcy.controller;

import com.wcy.domain.AjaxRes;
import com.wcy.domain.PageListRes;
import com.wcy.domain.User;
import com.wcy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserController {

    /*注入业务层*/
    @Autowired
    private UserService userService;

    @RequestMapping(value="/{openid}", method=RequestMethod.GET)
    public User getUserById(@PathVariable("openid") String openid) {
        /*调用业务层根据id查询用户*/
        User user = userService.selectUserById(openid);
        return user;
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public PageListRes getAllUsers() {
        /*调用业务层获取所有用户*/
        PageListRes pageListRes = userService.getAllUsers();
        return pageListRes;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public AjaxRes createUser(@RequestBody User user) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存用户*/
            userService.createUser(user);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{openid}", method=RequestMethod.PUT)
    public AjaxRes updateUser(@RequestBody User user) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,更新用户*/
            userService.updateUserById(user);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新失败");
        }
        return ajaxRes;
    }

    @RequestMapping(value="/{openid}", method=RequestMethod.DELETE)
    public AjaxRes deleteUser(String openid) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,删除用户*/
            userService.deleteUserById(openid);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除失败");
        }
        return ajaxRes;
    }

}
