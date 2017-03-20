package com.lovo.dao;

/**
 * Created by Elivs on 2017/3/20.
 */
public interface AdminLogDao {
    /**
     *
     * @param content 登陆日志记录
     * @param adminId   登陆的管理员的Id
     */
    void addLog(String content, int adminId);
}
