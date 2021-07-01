package com.baomidou.mybatisplus.samples.assembly;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2021年07月01日 22:03
 */
@Component
@Aspect
@Slf4j
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@AutoConfigureBefore(
        value = {DynamicRoutingDataSource.class}
)
public class Aop {

    public Aop() {
        log.info("============================");
    }

    @Around("execution(* com.baomidou.dynamic.datasource.DynamicRoutingDataSource.getConnection(..))")
//    @Around("execution(* com.baomidou.mybatisplus.samples.assembly.controller.UserController.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pdj) {
        /*result为连接点的放回结果*/
        Object result = null;
        String methodName = pdj.getSignature().getName();

        /*前置通知方法*/
        System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为：" + Arrays.asList(pdj.getArgs()));

        /*执行目标方法*/
        try {
            result = pdj.proceed();

            /*返回通知方法*/
            System.out.println("返回通知方法>目标方法名" + methodName + ",返回结果为：" + result);
        } catch (Throwable e) {
            /*异常通知方法*/
            System.out.println("异常通知方法>目标方法名" + methodName + ",异常为：" + e);
        }

        /*后置通知*/
        System.out.println("后置通知方法>目标方法名" + methodName);

        return result;
    }
}
