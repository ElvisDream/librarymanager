package com.lovo.dao.impl;

import com.lovo.dao.BookDao;
import com.lovo.pojo.BookBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Elivs on 2017/3/19.
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BookBean> selectAll() {

        String sql = "select * from book where user_id is NULL";

        RowMapper<BookBean> mapper = new BeanPropertyRowMapper<BookBean>(BookBean.class);

        List<BookBean> books = jdbcTemplate.query(sql, mapper);

        return books;
    }

    @Override
    public List<BookBean> selectUserBookByNum(int userNum) {

        String sql = "select * from book where user_id in (select user_id from users where user_num = ?)";

        RowMapper<BookBean> mapper = new BeanPropertyRowMapper<BookBean>(BookBean.class);

        List<BookBean> books = jdbcTemplate.query(sql, mapper,userNum);

        return books;
    }
}
