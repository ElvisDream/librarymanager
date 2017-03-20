package com.lovo.dao;

import com.lovo.pojo.BookBean;

import java.util.List;

/**
 * Created by Elivs on 2017/3/19.
 */
public interface BookDao {
    /**
     *
     * @return 查询所有没有借出的书籍
     */
    List<BookBean> selectAll();

    /**
     *
     * @param userNum 根据用户账号查询用户已借的书籍
     * @return 返回书籍集合
     */

    List<BookBean> selectUserBookByNum(int userNum);

    /**
     *
     * @param bookId 根据bookid修改书籍状态
     */
    void updateBookById(int bookId,int userNum);
}
