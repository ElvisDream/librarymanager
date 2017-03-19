package com.lovo.pojo;

import java.io.Serializable;

/**
 * Created by Elivs on 2017/3/17.
 */
public class UserBean implements Serializable {
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
//    用户状态，是否被注销
    private boolean userType=true;

    public UserBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }
}
