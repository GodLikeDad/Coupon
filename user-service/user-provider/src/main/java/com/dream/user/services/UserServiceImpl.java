/**
 * @program dream
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/14 01:22
 */

package com.dream.user.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.user.IUserService;
import com.dream.user.converter.UserConverter;
import com.dream.user.dal.bean.User;
import com.dream.user.dal.mapper.UserMapper;
import com.dream.user.dto.UserRequest;
import com.dream.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConverter userConverter;

    @Override
    public String Hello() {
        return "Hello Dubbo...";
    }

    @Override
    public UserResponse userById(UserRequest request) {
        UserResponse userResponse = new UserResponse();
        User user = userMapper.selectById(1);
        userResponse.setUserDto(userConverter.user2Res(user));
        userResponse.setCode("200");
        userResponse.setMsg("success");
        return userResponse;
    }
}
