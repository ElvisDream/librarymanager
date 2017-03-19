package com.lovo.pojo;

import java.io.Serializable;

/**
 * Created by Elivs on 2017/3/17.
 */
public class AdminLog implements Serializable {

//    管理员日志ID
    private Integer adminLogId;
//    管理员日志记录
    private String adminLogContent;

    public AdminLog() {
    }

    public int getAdminLogId() {
        return adminLogId;
    }

    public void setAdminLogId(int adminLogId) {
        this.adminLogId = adminLogId;
    }

    public String getAdminLogContent() {
        return adminLogContent;
    }

    public void setAdminLogContent(String adminLogContent) {
        this.adminLogContent = adminLogContent;
    }
}
