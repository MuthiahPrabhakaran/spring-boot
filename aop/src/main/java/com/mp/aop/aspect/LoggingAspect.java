package com.mp.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * Below Before and After method applicable for all methods ends with Passenger
     * It can be in any package and can have any number of arguments
     */
    /*@Before("execution(* *.*Passenger(..))")
    public void before(){
        logger.info("Entering method");
    }*/

    /*@After("execution(* *.*Passenger(..))")
    public void after(){
        logger.info("Exiting method");
    }*/


    /**
     * Below Before and After method applicable for all methods ends with Passenger in the controller package
     * Additionally we can receive and print the parameter also
     * It can be in any package and can have any number of arguments
     */
    /*@Before("execution(* com.mp.aop.controller.*.*Passenger(..))")
    public void before(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        logger.info("Entering method in controller. ID - " + args[0] );
    }

    @After("execution(* com.mp.aop.controller.*.*Passenger(..))")
    public void after(){
        logger.info("Entering method in controller");
    }*/


    @Around("execution(* com.mp.aop.controller.*.*Passenger(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object methodArgs[] = joinPoint.getArgs();
        logger.info("Executing method " + methodName + " with the ID " + methodArgs[0]);
        Object result = joinPoint.proceed();
        logger.info("Executed the method " + methodName + ", returns " + result);
        return result;
    }

}
