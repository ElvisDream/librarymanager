package com.lovo.dao.impl;

import com.lovo.dao.RentLogDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/20.
 */
@Repository
public class RentLogDaoImpl implements RentLogDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addLog(String content, int userNum) {
        String sql = "insert into userlog values(default,?,?)";
        jdbcTemplate.update(sql, new Object[]{content, userNum});
    }
}
