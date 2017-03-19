package com.lovo.controller;

import com.lovo.pojo.BookBean;
import com.lovo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Elivs on 2017/3/19.
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Resource(name="bookServiceImpl")
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody List<BookBean> getAll(){

        List<BookBean> books = bookService.queryAll();

        return books;
    }

    @RequestMapping(params = "method=userBook", method = RequestMethod.POST)
    public @ResponseBody List<BookBean> getUserBook(int userNum) {

        List<BookBean> userBooks = bookService.queryByUserNum(userNum);

        return userBooks;
    }

}
