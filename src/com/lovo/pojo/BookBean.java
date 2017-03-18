package com.lovo.pojo;

/**
 * Created by Elivs on 2017/3/17.
 */
public class BookBean {

//    书籍ID
    private Integer bookId;
//    书籍名称
    private String bookName;
//    书籍是否被借走
    private boolean bookType=true;
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
}
