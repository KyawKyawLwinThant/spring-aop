package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyCurrencyServiceAspect {
    @Pointcut("within(com.demo.service.*)")
    public void withinPointCut(){}
    @Pointcut("@within(com.demo.annotation.Secured)")
    public void annotationWithinPointCut(){

    }
    @Before("withinPointCut() || annotationPointCut()")
    public void combinationAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationPointCut(){}
    @Pointcut("bean(my_bean)")
    public void beanPointCut(){}
    @Pointcut("args(int,double)")
    public void argsPointCut(){}
    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetPointCut(){}
    @Pointcut("execution(public * *(..))")
    public void  changeCurrencyPoint(){}
    //@Before("execution(public * *(..))")
    public void executionBeforeAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    //@Before("targetPointCut()")
    public void targetAnnotationAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    @Pointcut("@args(com.demo.annotation.Validated)")
    public void annotationArgsPointCut(){}
 //   @AfterThrowing(value = "annotationArgsPointCut()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint,Exception exception){
        System.out.println("Exception caught::"+ exception);
    }
   // @AfterReturning(value = "annotationArgsPointCut()",returning = "name")
    public void afterReturningAdvice(JoinPoint joinPoint, String name){
        System.out.println(
                String.format("%s is invoked before with:%s and return value:[%s]",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        name)
        );
    }

    //@Before("annotationArgsPointCut()")
    public void annotationBeforeCurrencyTypeAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
   // @Before("argsPointCut()")
    public void argsBeforeAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
   // @Before("beanPointCut()")
    public void beanBeforeAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    //@Before("annotationPointCut()")
    public void annotationBeforeAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    //@Before("annotationWithinPointCut()")
    public void beforeWithinAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    //@Before("withinPointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked after with:%s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
}
