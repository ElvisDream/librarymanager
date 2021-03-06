package com.lovo.dao;

import com.lovo.pojo.AdminBean;

import java.util.List;

/**
 * Created by Elivs on 2017/3/17.
 */
public interface AdminDao {
    /**
     * @param admin 增加管理员
     */
    public void insertAdmin(AdminBean admin);

    /**
     *
     * @param admin 根据管理员信息查询管理员
     * @return 返回一个管理员对象
     */
    public AdminBean selectAdmin(AdminBean admin);

    /**
     *
     * @param adminId 根据管理员ID修改管理员状态
     */
    public List<AdminBean> updateAdmintType(int adminId);

    /**
     *
     * @return 查询所有普通管理员
     */
    List<AdminBean> selectAll();

}
