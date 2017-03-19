package com.lovo.service;

import com.lovo.pojo.BookBean;

import java.util.List;

/**
 * Created by Elivs on 2017/3/19.
 */
public interface BookService {

    /**
     *
     * @return 返回所有没被借出的书籍
     */
    List<BookBean> queryAll();

    /**
     *
     * @param userNum 根据用户账户查询用户借出的书籍
     * @return 返回用户借出的书籍列表
     */
    List<BookBean> queryByUserNum(int userNum);
}
