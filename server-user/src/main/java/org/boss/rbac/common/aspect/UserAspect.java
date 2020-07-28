package org.boss.rbac.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 设置一个切面
 * 对 UserController 的 login方法进行 访问控制
 * @Aspect: 标识这个类是切面类
 * @Component： 把这个类作为Bean注册到spring IOC中
 */
@Aspect
@Component
@Slf4j
public class UserAspect {

    /**
     * 编写切入点方法
     * execution 表示执行
     * execution() 括号没表示执行的类及方法
     * login(..) 表示不限定参数
     */
    @Pointcut("execution(public * org.boss.rbac.controller.UserController.login(..))")
    public void point(){}

    /**
     * 执行 login() 方法前执行此方法
     */
    @Before("point()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("URL: " + request.getRequestURL().toString());
        log.info("RemoteIP: " + request.getRemoteAddr());
        log.info("localIP: " + request.getLocalAddr());
    }

    @AfterReturning(pointcut = "point()", returning = "resp")
    public void afterReturning(Object resp){
        log.info("res: " + resp);
    }


    // 由于密码进行了加密这里要用function进行判断
    private boolean check(String userPass, String password){
        if (userPass.equals(password)){
            return true;
        } else {
            return false;
        }
    }
}
