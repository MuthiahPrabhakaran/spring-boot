package com.mp.aop.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //Global
    /*@Before("execution(* *.*Passenger(..))")
    public void before(){
        logger.info("Entering method");
    }*/

    /*@After("execution(* *.*Passenger(..))")
    public void after(){
        logger.info("Exiting method");
    }*/


    // Package oriented
    /*@Before("execution(* com.mp.aop.controller.*.*Passenger(..))")
    public void before(){
        logger.info("Entering method in controller");
    }

    @After("execution(* com.mp.aop.controller.*.*Passenger(..))")
    public void after(){
        logger.info("Entering method in controller");
    }*/

}
