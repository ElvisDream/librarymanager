package com.lovo.pojo;

/**
 * Created by Elivs on 2017/3/17.
 */
public class BookBean {

//    书籍ID
    private Integer bookId;
//    书籍名称
    private String bookName;

    public BookBean() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
