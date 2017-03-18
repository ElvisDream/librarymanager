package com.lovo.controller;

import com.lovo.pojo.UserBean;
import com.lovo.service.UserServce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Elivs on 2017/3/18.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserServce userServce;

    //查询用户信息
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody UserBean query(int userId){

        UserBean user = userServce.queryUserByNum(userId);

        return user;
    }
}
