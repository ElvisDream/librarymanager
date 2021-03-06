package com.lovo.log;

import com.lovo.dao.AdminLogDao;
import com.lovo.pojo.AdminBean;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Elivs on 2017/3/17.
 */
@Component
@Aspect
public class LoginLog {


    private static Logger logger = Logger.getLogger(LoginLog.class);

    @Resource(name = "adminLogDaoImpl")
    private AdminLogDao adminLogDao;

    @Pointcut("execution(* com.lovo.service.AdminService.login(..))")
    public void pointCut(){}

    public String getTime() {//获取当前详细日期信息
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String nowdate = smp.format(now);
        return nowdate;
    }
    @Around("pointCut()")
    public AdminBean userLog(ProceedingJoinPoint pjo) throws Throwable{

        AdminBean admin = (AdminBean) pjo.proceed();

        String now = getTime();

        String contend = "管理员"+admin.getAdminName()+"在"+getTime()+"登陆";

        logger.warn(contend);

        adminLogDao.addLog(contend,admin.getAdminId());

        return admin;
    }
}
