package com.lovo.service.impl;

import com.lovo.pojo.UserBean;
import com.lovo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../../../applicationContext.xml")
public class UserServiceImplImplTest {

    @Resource
    private UserService userServce;
    @Test
    public void queryUserByNum() throws Exception {

        UserBean user = userServce.queryUserByNum(12345);

        System.out.println(user.getUserName());
    }
    @Test
    public void delUserByNum() throws Exception {
        userServce.delUserByNum(12345);
    }
}