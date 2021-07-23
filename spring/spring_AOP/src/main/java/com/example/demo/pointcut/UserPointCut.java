package com.example.demo.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring_AOP
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-21 10:44
 */
@Aspect
@Component
public class UserPointCut {
    //1.定义切面的规则
    @Pointcut("execution(* com.example.demo.controller.UserController.*(..))")
    public void pointcut(){

    }

    //2.添加通知
    @Before("pointcut()")
    public void doBefore(){
        System.out.println("执行了前置通知");
    }

    @After("pointcut()")
    public void doAfter() {
        System.out.println("执行了后置通知");
    }

    @AfterReturning("pointcut()")
    public void doReturing() {
        System.out.println("执行了返回之前通知的方法");
    }

    @AfterThrowing("pointcut()")
    public void doThrowing() {
        System.out.println("执行了抛出异常之前通知方法");
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("进入了环绕通知：方法执行之前");
        Object result = 0;
        try {
            // 执行被代理的方法
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("执行环绕通知：执行了方法调用之后");
        return result;
    }

}
