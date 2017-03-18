package com.lovo.service.impl;

import com.lovo.dao.AdminDao;
import com.lovo.pojo.AdminBean;
import com.lovo.service.AdminService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Elivs on 2017/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../../../applicationContext.xml")
public class AdminServiceImplTest {
    @Resource
    private AdminService adminService;

    AdminBean adminBean = new AdminBean();
    @Ignore
    @Test
    public void addAdmin() throws Exception {
        adminBean.setAdminName("fff");
        adminBean.setAdminPwd("ghh");
        adminService.addAdmin(adminBean);
    }
    @Ignore
    @Test
    public void queryAdmin() throws Exception {
        adminBean.setAdminName("super");
        adminBean.setAdminPwd("123");
        System.out.println(adminService.queryAdmin(adminBean));
    }
    @Ignore
    @Test
    public void changeAdminType() throws Exception{

        adminService.changeAdminType(2);
    }
}