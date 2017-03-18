package com.lovo.pojo;

/**
 * Created by Elivs on 2017/3/17.
 */
public class UserBean {
//    用户ID
    private Integer userId;
//    会员账号
    private Integer userNum;
//    用户姓名
    private String userName;
//    账户余额
    private Integer userAccount;
//    书籍
    private BookBean book;
//    用户日志
    private UserLog logBean;
    public UserBean() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(int userAccount) {
        this.userAccount = userAccount;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    public UserLog getLogBean() {
        return logBean;
    }

    public void setLogBean(UserLog logBean) {
        this.logBean = logBean;
    }
}
