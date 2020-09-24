package com.mp.aop.aspect.custom;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Aspect
@Configuration
public class CustomLoggingAspect {

    private Logger logger = Logger.getLogger(CustomLoggingAspect.class.getName());

    @Around("@annotation(com.mp.aop.aspect.custom.Log)")
    public Object customLog(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object methodArgs[] = joinPoint.getArgs();
        logger.info("Executing method " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Executed the method " + methodName + ", returns " + result);
        return result;
    }
}
