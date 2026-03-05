package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MethodRecordAspect {

    @Around("execution(* com.itheima.service.*.*(..))")
    public Object recordMethodTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("方法:{} 运行时间:{}", joinPoint.getSignature().getName(), time);
        return result;
    }
}
