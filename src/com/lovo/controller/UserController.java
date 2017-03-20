package com.lovo.controller;

import com.lovo.pojo.UserBean;
import com.lovo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/18.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userServce;

    //查询用户信息
    @RequestMapping(params = "method=query",method = RequestMethod.POST)
    public @ResponseBody UserBean query(int userId){

        UserBean user = userServce.queryUserByNum(userId);

        return user;
    }
//    删除用户
    @RequestMapping(params = "method=del",method = RequestMethod.POST)
    public @ResponseBody UserBean del(int userId){

        UserBean user = userServce.delUserByNum(userId);

        return user;
    }

//    新增用户
    @RequestMapping(params = "method=add",method = RequestMethod.POST)
    public  @ResponseBody UserBean add(String userName,String userAccount) {

        UserBean user = new UserBean();
        user.setUserName(userName);
        if(!userAccount.equals("")) {
            user.setUserAccount(Integer.parseInt(userAccount));
        }

        return userServce.addUser(user);
    }
}
