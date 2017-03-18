package com.lovo.service.impl;

import com.lovo.dao.UserDao;
import com.lovo.pojo.UserBean;
import com.lovo.service.UserServce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/17.
 */
@Service
public class UserServiceImpl implements UserServce {

    @Resource
    private UserDao userDao;

    @Override
    public UserBean queryUserByNum(int userNum) {

        return userDao.selectUserByNum(userNum);
    }

    @Override
    public void delUserByNum(int userNum) {
        userDao.updateUserByNum(userNum);
    }
}
