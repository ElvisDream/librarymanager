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

        String sql = "SELECT * from users where user_num = ?";

        UserBean user = null;

        try {
            RowMapper<UserBean> mapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
            user = jdbcTemplate.queryForObject(sql, mapper, userNum);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserBean updateUserByNum(int userNum) {
        String sql = "UPDATE users SET user_type=FALSE WHERE user_num=?";
        jdbcTemplate.update(sql, new Object[]{userNum});
        String sql1 = "SELECT * from users where user_num = ?";
        UserBean user = null;
        try {
            RowMapper<UserBean> mapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
            user = jdbcTemplate.queryForObject(sql1, mapper, userNum);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserBean addUser(UserBean user) {

        String sql = "INSERT INTO users VALUES (DEFAULT ,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{user.getUserNum(), user.getUserName(), user.getUserAccount(), user.getUserType()});

        UserBean newUser = null;
        String sql1 = "select * from users where user_name=?";
        try {
            RowMapper<UserBean> mapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
            newUser = jdbcTemplate.queryForObject(sql1,mapper, user.getUserName());
            return newUser;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void userAccount(int bookSize,int userId) {
        //获取用户余额
        String sql = "select user_account from users where user_id in (SELECT user_id from users where user_num=?)";
        int account= jdbcTemplate.queryForObject(sql, new Object[]{userId},Integer.class);
        //修改用户余额
        String sql1 = "update users set user_account = ? where user_num=?";
        jdbcTemplate.update(sql1, new Object[]{(account-bookSize * 2),userId});
    }
}
