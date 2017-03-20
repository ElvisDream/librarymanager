package com.lovo.dao;

/**
 * Created by Elivs on 2017/3/20.
 */
public interface RentLogDao {

    /**
     *
     * @param content 用户借书日志内容
     * @param userNum 用户会员号
     */
    void addLog(String content, int userNum);

}
