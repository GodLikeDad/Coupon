/**
 * @program dshop
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/12 17:07
 */

package com.dream.dshop.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.dshop.bean.User;
import com.dream.dshop.service.UserService;
import com.dream.dshop.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> userList() {
        return userMapper.selectList(new QueryWrapper<User>());
    }
}
