package com.baomidou.mybatisplus.samples.assembly.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.assembly.entity.User;
import com.baomidou.mybatisplus.samples.assembly.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.assembly.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nieqiuqiu
 */
@Service
@DS("DS_2")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl2 extends ServiceImpl<UserMapper, User> implements IUserService {

}
