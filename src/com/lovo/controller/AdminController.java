package com.lovo.controller;

import com.lovo.pojo.AdminBean;
import com.lovo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public String add(AdminBean adminBean) {

        adminService.addAdmin(adminBean);

        return "success";
    }*/
//管理员登陆
    @RequestMapping(params = "method=login",method = RequestMethod.POST)
    public String login(AdminBean adminBean, HttpSession session) {

        AdminBean admin = adminService.queryAdmin(adminBean);
        if(admin != null) {
            session.setAttribute("admin",admin);
            return "redirect:success.jsp";//使用重定向防止表单重复提交
        }else{
            session.setAttribute("errorMsg","账户或密码错误！");
            return "redirect:login.jsp";
        }
    }
//    查询管理员信息
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AdminBean query(HttpSession session) {

        AdminBean admin = (AdminBean) session.getAttribute("admin");

        return admin;
    }

//删除管理员
/*    @RequestMapping()
    public String change(int adminId) {

        System.out.println("fad");

        adminService.changeAdminType(adminId);

        return null;
    }*/
}
