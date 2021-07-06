package com.baomidou.mybatisplus.samples.assembly.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.samples.assembly.entity.User;
import com.baomidou.mybatisplus.samples.assembly.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.samples.assembly.service.impl.UserServiceImpl2;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * @author nieqiuqiu
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserServiceImpl2 userServiceImpl2;

    @Autowired
    private MessageSource messageSource;

    @Data
    public static class Member {
        private Long userId;

        private String name;
    }

    /**
     * 国际化：https://cloud.tencent.com/developer/article/1630185
     */
    @RequestMapping(value = "test")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public String test() {

        String[] p = new String[]{"1st", "2rd"};
        String e40010001 = messageSource.getMessage("E40010001", p, Locale.US);

        User user = new User();
        user.setEmail("111111@qq.com");
        user.setAge(18);
        user.setName("啪啪啪");
        userService.save(user);
        List<User> list = userService.list(new LambdaQueryWrapper<>(new User()).select(User::getId, User::getName));
        list.forEach(u -> LOGGER.info("1当前用户数据:{}", u));
        return "papapapap@qq.com";
    }

    @RequestMapping(value = "test2")
//    @Transactional(rollbackFor = Exception.class)
    public String test2() {
        User user = new User();
        user.setEmail("22222@qq.com");
        user.setAge(18);
        user.setName("啪啪啪");
//        userServiceImpl2.save(user);
//        List<User> list2 = userService.list(new LambdaQueryWrapper<>(new User()).select(User::getId, User::getName));
//        list2.forEach(u -> LOGGER.info("1当前用户数据:{}", u));
        List<User> list = userServiceImpl2.list1(new LambdaQueryWrapper<>(new User()).select(User::getId, User::getName));
        list.forEach(u -> LOGGER.info("2当前用户数据:{}", u));
        return "papapapap@qq.com";
    }

}
