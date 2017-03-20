package com.lovo.service.impl;

import com.lovo.dao.AdminDao;
import com.lovo.pojo.AdminBean;
import com.lovo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Elivs on 2017/3/17.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;
    @Override
    public void addAdmin(AdminBean adminBean) {
        adminDao.insertAdmin(adminBean);
    }

    @Override
    public AdminBean login(AdminBean adminBean) {

        return adminDao.selectAdmin(adminBean);
    }

    @Override
    public List<AdminBean> changeAdminType(int adminId) {

        return adminDao.updateAdmintType(adminId);
    }

    @Override
    public List<AdminBean> queryAll() {

        return adminDao.selectAll();
    }
}
