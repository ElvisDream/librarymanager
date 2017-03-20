package com.lovo.service;

import com.lovo.pojo.UserBean;

/**
 * Created by Elivs on 2017/3/17.
 */
public interface UserServce {
    /**
     *
     *@param userNum 根据用户账户查询用户信息
     * @return 返回用户对象
     */
    UserBean queryUserByNum(int userNum);

    /**
     *
     * @param userNum 根据用户账户删除用户
     */
    UserBean delUserByNum(int userNum);

    /**
     *
     * @param user 新增用户对象
     * @return 返回新增用户对象
     */
    UserBean addUser(UserBean user);

    /**
     *
     * @param bookSize 根据书本数量，对用户余额进行修改
     */
    void userAccount(int bookSize, int userId);

}
