package com.neilge.accountManage.factory;

import com.neilge.accountManage.util.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Neo
 * @since 09/24/2020-3:40 PM
 */
@Component
@Aspect
public class BeanFactory {

    @Autowired
    private TransactionManager txManager;

    @Pointcut("execution(* com.neilge.accountManage.service.impl.*.*(..))")
    private void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            txManager.beginTransaction();
            System.out.println("Aspect transaction before!!!");
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("Aspect transaction after!!!");
            txManager.commit();
            return result;
        } catch (Throwable e) {
            System.out.println("Aspect transaction fail!!!");
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            System.out.println("Aspect transaction complete!!!");
            txManager.releaseConnection();
        }
    }
}
