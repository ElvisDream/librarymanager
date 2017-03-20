package com.lovo.controller;

import com.lovo.pojo.BookBean;
import com.lovo.service.BookService;
import com.lovo.service.UserServce;
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

    @Resource(name="userServiceImpl")
    private UserServce userServce;

//查询所有没被借出的书
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody List<BookBean> getAll(){

        List<BookBean> books = bookService.queryAll();

        return books;
    }
//查询用户已经借阅的书
    @RequestMapping(params = "method=userBook", method = RequestMethod.POST)
    public @ResponseBody List<BookBean> getUserBook(int userNum) {

        List<BookBean> userBooks = bookService.queryByUserNum(userNum);

        return userBooks;
    }

//   用户借书
    @RequestMapping(params = "method=rent",method = RequestMethod.POST)
    public @ResponseBody List<BookBean> rentBook(String bookId,int userNum) {

        String[] id = bookId.split("&");
        for (int i=1 ; i<id.length;i++){
            int newBookId = Integer.parseInt(id[i]);
            bookService.rentBook(newBookId,userNum);
        }
        userServce.userAccount(id.length-1,userNum);
       return bookService.queryAll();
    }
}
