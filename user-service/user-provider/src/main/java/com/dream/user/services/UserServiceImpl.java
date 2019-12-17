/**
 * @program dream
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/14 01:22
 */

package com.dream.user.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.user.IUserService;
import com.dream.user.constatns.SysRetCodeConstants;
import com.dream.user.converter.UserConverter;
import com.dream.user.dal.bean.User;
import com.dream.user.dal.mapper.UserMapper;
import com.dream.user.dto.UserListResponse;
import com.dream.user.dto.UserRequest;
import com.dream.user.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
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

    /**
     * 根据用户id返回用户信息
     * @param request
     * @return
     */
    @Override
    public UserResponse userById(UserRequest request) {
        UserResponse userResponse = new UserResponse();
        try {
            User user = userMapper.selectById(request.getId());
            if (user == null) {
                userResponse.setCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
                userResponse.setMsg(SysRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
            userResponse.setUserDto(userConverter.user2Res(user));
            userResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
            userResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        } catch (Exception e) {
            log.error("userById" + e.toString());
        }
        return userResponse;
    }

    @Override
    public UserListResponse users() {
        UserListResponse userListResponse = new UserListResponse();
        try {
            List<User> users = userMapper.selectList(new QueryWrapper<User>());
            if (users == null || users.size() == 0) {
                userListResponse.setCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
                userListResponse.setMsg(SysRetCodeConstants.DATA_NOT_EXIST.getMessage());
            }
            userListResponse.setUserDtos(userConverter.user2List(users));
            userListResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
            userListResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("users" + e.toString());
        }
        return userListResponse;
    }
}
