package com.lovo.dao.impl;

import com.lovo.dao.UserDao;
import com.lovo.pojo.BookBean;
import com.lovo.pojo.UserBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/17.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserBean selectUserByNum(int userNum) {

        String sql = "SELECT * from users LEFT JOIN book ON book.user_id = users.user_id where user_num=?";

        UserBean user = null;

        try {
            RowMapper<UserBean> mapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
            user = jdbcTemplate.queryForObject(sql, mapper, userNum);
            BookBean book = new BookBean();

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUserByNum(int userNum) {
        String sql = "UPDATE users SET user_type=FALSE WHERE user_num=?";
        jdbcTemplate.update(sql, new Object[]{userNum});
    }
}
