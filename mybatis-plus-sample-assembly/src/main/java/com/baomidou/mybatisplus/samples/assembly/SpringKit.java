package com.baomidou.mybatisplus.samples.assembly;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2021年07月02日 0:35
 */
@Component
public class SpringKit implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext aaa) throws BeansException {
        applicationContext = aaa;
    }
}
