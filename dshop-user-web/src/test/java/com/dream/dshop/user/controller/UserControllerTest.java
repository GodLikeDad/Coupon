/**
 * @program dshop
 * @description: 用户控制器测试
 * @author: mf
 * @create: 2019/12/12 23:04
 */

package com.dream.dshop.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.dshop.user.bean.User;
import com.dream.dshop.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Reference
    private UserService userService;

    @Test
    public void getAllUsers() {
        List<User> users = userService.userList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
