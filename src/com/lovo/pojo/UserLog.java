package com.lovo.pojo;

import java.io.Serializable;

/**
 * Created by Elivs on 2017/3/17.
 */
public class UserLog implements Serializable {
//    用户日志ID
    private Integer userLogId;
//    用户日志记录
    private String logContent;

    public UserLog() {
    }

    public int getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(int userLogId) {
        this.userLogId = userLogId;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
}
