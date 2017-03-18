package com.lovo.controller;

import com.lovo.pojo.AdminBean;
import com.lovo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Elivs on 2017/3/17.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource(name="adminServiceImpl")
    private AdminService adminService;
//增加管理员
/*    @RequestMapping(params = "method=add", method = RequestMethod.POST)
    public String login(AdminBean adminBean) {

        adminService.addAdmin(adminBean);

        return "success";
    }*/
//管理员登陆
    @RequestMapping(params = "method=login",method = RequestMethod.POST)
    public String add(AdminBean adminBean) {

        boolean flag = adminService.queryAdmin(adminBean);
        if(flag) {
            return "redirect:success.jsp";//使用重定向防止表单重复提交
        }else{
            return "login";
        }
    }
//删除管理员
/*    @RequestMapping()
    public String change(int adminId) {

        System.out.println("fad");

        adminService.changeAdminType(adminId);

        return null;
    }*/
}
