package com.lovo.service.impl;

import com.lovo.dao.BookDao;
import com.lovo.pojo.BookBean;
import com.lovo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Elivs on 2017/3/19.
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<BookBean> queryAll() {
        return bookDao.selectAll();
    }

    @Override
    public List<BookBean> queryByUserNum(int userNum) {

        return bookDao.selectUserBookByNum(userNum);
    }
}
