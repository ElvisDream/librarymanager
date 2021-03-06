package com.lovo.service;

import com.lovo.pojo.AdminBean;

import java.util.List;

/**
 * Created by Elivs on 2017/3/17.
 */
public interface AdminService {

    /**
     *
     * @param adminBean 增加管理员
     */
    void addAdmin(AdminBean adminBean);

    /**
     *
     * @param adminBean 根据管理员登陆信息查询管理员
     * @return 返回管理员是否存在
     */
    AdminBean login(AdminBean adminBean);

    /**
     *
     * @param adminId 根据管理员ID修改管理员状态
     */
    List<AdminBean> changeAdminType(int adminId);

    /**
     *
     * @return 查询所有管理员
     */
    List<AdminBean> queryAll();
}
