/**
 * @program dshop
 * @description: 用户控制器
 * @author: mf
 * @create: 2019/12/12 20:21
 */

package com.dream.dshop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.dshop.bean.User;
import com.dream.dshop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.userList();
    }

}
