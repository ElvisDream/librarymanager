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
    void delUserByNum(int userNum);

}
