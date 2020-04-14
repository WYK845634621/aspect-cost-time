package com.yikai.aspectcosttime.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/14 19:24
 */
@Aspect
@Component
public class TimeAspect {

    // 修正Timer注解的全局唯一限定符
    @Pointcut("@annotation(com.yikai.aspectcosttime.annotations.Timer)")
    private void pointcut() {}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标Logger
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        // 获取目标类名称
        String clazzName = joinPoint.getTarget().getClass().getSimpleName();

        // 获取目标类方法名称
        String methodName = joinPoint.getSignature().getName();

        long start = System.currentTimeMillis();
        logger.info( "class:{}==method:{}==start execute", clazzName, methodName);

        // 调用目标方法
        Object result = joinPoint.proceed();

        long time = System.currentTimeMillis() - start;
        logger.info( "class:{}==method:{}==finished-cost time is: {} ms", clazzName, methodName, time);

        return result;
    }




}
