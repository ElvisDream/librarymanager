package com.lovo.pojo;

/**
 * Created by Elivs on 2017/3/17.
 */
public class AdminBean {
//    用户ID
    private Integer adminId;
//    用户名
    private String adminName;
//    用户密码
    private String adminPwd;
//    用户权限
    private String adminPower;
//    用户状态
    private boolean adminType=true;

    public AdminBean() {
    }

    public AdminBean(String adminName, String adminPwd, String adminPower, boolean adminType) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminPower = adminPower;
        this.adminType = adminType;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(String adminPower) {
        this.adminPower = adminPower;
    }

    public boolean getAdminType() {
        return adminType;
    }

    public void setAdminType(boolean adminType) {
        this.adminType = adminType;
    }
}
