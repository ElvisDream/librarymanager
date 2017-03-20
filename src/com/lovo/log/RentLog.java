package com.lovo.log;

import com.lovo.dao.BookDao;
import com.lovo.dao.RentLogDao;
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
 * Created by Elivs on 2017/3/20.
 */
@Component
@Aspect
public class RentLog {

    private static Logger logger = Logger.getLogger(LoginLog.class);

    @Resource(name = "rentLogDaoImpl")
    private RentLogDao rentLogDao;

    @Pointcut("execution(* com.lovo.service.BookService.rentBook(..))")
    public void pointCut(){}

    public String getTime() {//获取当前详细日期信息
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String nowdate = smp.format(now);
        return nowdate;
    }

    @Around("pointCut()")
    public void rentLog(ProceedingJoinPoint pjo) throws Throwable {

        pjo.proceed();
        int bookId = (int)pjo.getArgs()[0];
        int userNum = (int) pjo.getArgs()[1];
        String now = getTime();

        String content = "用户ID：" + userNum + ", 所借书籍ID:" + bookId + ", 借书时间："+now;

        logger.warn(content);

//        rentLogDao.addLog(content,num[1]);
    }
}
