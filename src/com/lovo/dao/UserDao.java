package com.lovo.dao;

import com.lovo.pojo.UserBean;

/**
 * Created by Elivs on 2017/3/17.
 */
public interface UserDao {
    /**
     *
     * @param userNum 根据用户账户查询用户信息
     * @return 返回用户对象
     */
    UserBean selectUserByNum(int userNum);

    /**
     *
     * @param userNum 根据用户账户修改用户信息
     */
    void updateUserByNum(int userNum);

}
