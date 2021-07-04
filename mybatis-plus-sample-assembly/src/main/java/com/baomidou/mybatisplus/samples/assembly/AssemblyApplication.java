package com.baomidou.mybatisplus.samples.assembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 1. cd target
 * 2. java -jar mybatis-plus-sample-assembly-0.0.1-SNAPSHOT.jar
 * 3. curl http://127.0.0.1:8080/test
 * @author nieqiuqiu
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement
public class AssemblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssemblyApplication.class, args);
    }

}
