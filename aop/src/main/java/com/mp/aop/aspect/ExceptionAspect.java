package com.mp.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExceptionAspect {

    private Logger logger = Logger.getLogger(ExceptionAspect.class.getName());

   /* @Pointcut(value = "execution(* *.*Passenger(..))")
    public void logAfterException(){ }
*/

    //@AfterThrowing(value = "logAfterException()", throwing = "exception")
    @AfterThrowing(pointcut = "execution(* *.*Passenger(..))", throwing = "exception")
    public void processException(JoinPoint jp, RuntimeException exception){
        logger.severe("aspect "+exception.getMessage());
    }
}
