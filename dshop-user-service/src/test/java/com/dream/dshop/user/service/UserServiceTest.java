/**
 * @program dshop
 * @description: 用户服务测试
 * @author: mf
 * @create: 2019/12/12 17:26
 */

package com.dream.dshop.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.dshop.bean.User;
import com.dream.dshop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Reference
    private UserService userService;

    @Test
    public void testAll() {
        List<User> users = userService.userList();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
