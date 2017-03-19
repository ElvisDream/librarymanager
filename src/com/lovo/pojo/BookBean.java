package com.lovo.pojo;

import java.io.Serializable;

/**
 * Created by Elivs on 2017/3/17.
 */
public class BookBean implements Serializable {

//    书籍ID
    private Integer bookId;
//    书籍名称
    private String bookName;
//    书籍是否被借走
    private boolean bookType=true;
//    图片
    private String bookImg;
    public BookBean() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public boolean getBookType() {
        return bookType;
    }

    public void setBookType(boolean bookType) {
        this.bookType = bookType;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }
}
