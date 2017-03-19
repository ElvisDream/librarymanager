package com.lovo.dao.impl;

import com.lovo.dao.AdminDao;
import com.lovo.pojo.AdminBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Elivs on 2017/3/17.
 */
@Repository
public class AdminDaoImpl implements AdminDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    static boolean adminType = true;
    @Override
    public void insertAdmin(AdminBean admin) {
        String sql = "INSERT into admin(admin_name,admin_pwd,admin_power,admin_type) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{admin.getAdminName(), admin.getAdminPwd(), "normal", adminType});
    }

    @Override
    public AdminBean selectAdmin(AdminBean admin) {

        String sql = "select * from admin where admin_name=? and admin_pwd=?";
        AdminBean adminBean = null;
        try {
            RowMapper<AdminBean> maper = new BeanPropertyRowMapper<AdminBean>(AdminBean.class);
            adminBean = jdbcTemplate.queryForObject(sql, maper, admin.getAdminName(), admin.getAdminPwd());
            return adminBean;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AdminBean> updateAdmintType(int adminId) {

        String sql = "UPDATE admin SET admin_type=FALSE WHERE admin_id=?";
        jdbcTemplate.update(sql, new Object[]{adminId});

        return selectAll();
    }

    @Override
    public List<AdminBean> selectAll() {

        String sql = "select * from admin where admin_type!=false and admin_power!='super'";

        RowMapper<AdminBean> maper = new BeanPropertyRowMapper<AdminBean>(AdminBean.class);

        List<AdminBean> adminList = jdbcTemplate.query(sql, maper);

        return adminList;
    }
}
