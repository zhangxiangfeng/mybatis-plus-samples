package com.baomidou.mybatisplus.samples.assembly.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.assembly.entity.User;
import com.baomidou.mybatisplus.samples.assembly.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.assembly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nieqiuqiu
 */
@Service
@DS("DS_1")
//@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper2;

    @Override
    public List<User> list1(Wrapper<User> queryWrapper) {
        List<User> users = userMapper2.selectList(queryWrapper);
        return users;
    }
}
