package com.lovo.dao.impl;

import com.lovo.dao.AdminLogDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/20.
 */
@Repository
public class AdminLogDaoImpl implements AdminLogDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addLog(String content, int adminId) {
        String sql = "insert into adminlog values(DEFAULT,?,?)";
        jdbcTemplate.update(sql, new Object[]{content,adminId});
    }
}
