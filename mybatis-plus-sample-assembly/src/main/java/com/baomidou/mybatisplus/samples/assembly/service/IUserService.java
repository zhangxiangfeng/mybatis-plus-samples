package com.baomidou.mybatisplus.samples.assembly.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.samples.assembly.entity.User;

import java.util.List;

/**
 * @author nieqiuqiu
 */
public interface IUserService extends IService<User> {

    List<User> list1(Wrapper<User> queryWrapper);
}
