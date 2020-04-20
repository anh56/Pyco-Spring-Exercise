package com.pyco.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class ActionAspect {

    private static Logger logger = LoggerFactory.getLogger(ActionAspect.class);

    @Around("execution(* com.pyco.service..*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object result = null;
        try {
            logger.info("Start method '{}' with argument {}", methodName, this.getParameterNames(joinPoint));
            result = joinPoint.proceed();
            logger.info("End method '{}'", methodName);
        }  catch (Throwable exception) {
            logger.error("Failed to execute '{}' '{}' ", methodName, exception);
        }

        return result;
    }

    private String getParameterNames(JoinPoint joinPoint){
        CodeSignature codeSignature =(CodeSignature) joinPoint.getSignature();
        return String.join(", ", codeSignature.getParameterNames());
    }
}
