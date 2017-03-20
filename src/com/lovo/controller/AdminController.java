package com.lovo.controller;

import com.lovo.pojo.AdminBean;
import com.lovo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Elivs on 2017/3/17.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource(name="adminServiceImpl")
    private AdminService adminService;
//增加管理员
    @RequestMapping(params = "method=add", method = RequestMethod.POST)
    public String add(AdminBean adminBean) {
        adminService.addAdmin(adminBean);
        return "success";
    }
//管理员登陆
    @RequestMapping(params = "method=login",method = RequestMethod.POST)
    public java.lang.String login(AdminBean adminBean, HttpSession session) {

        AdminBean admin = adminService.login(adminBean);
        if(admin != null) {
            if(admin.getAdminType()==false) {
                session.setAttribute("errorMsg","对不起，您的账户已失效！");
                return "redirect:login.jsp";
            }else{
                session.setAttribute("admin",admin);
                return "redirect:success.jsp";//使用重定向防止表单重复提交
            }
        }else{
            session.setAttribute("errorMsg","账户或密码错误！");
            return "redirect:login.jsp";
        }
    }

//    查询所有普通管理员
    @RequestMapping(params = "method=getAll", method = RequestMethod.POST)
    public @ResponseBody List<AdminBean> getAll() {

        List<AdminBean> admins = adminService.queryAll();

        return admins;
    }


//删除管理员
    @RequestMapping(params = "method=remove", method = RequestMethod.POST)
    public @ResponseBody List<AdminBean> change(String adminId) {

        List<AdminBean> admins = adminService.changeAdminType(Integer.parseInt(adminId));

        return admins;
    }

//    查询管理员信息
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody AdminBean query(HttpSession session) {

        AdminBean admin = (AdminBean) session.getAttribute("admin");

        return admin;
    }
}
