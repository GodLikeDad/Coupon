/**
 * @program dream
 * @description: 用户服务测试
 * @author: mf
 * @create: 2019/12/14 01:26
 */

package com.dream.user;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Reference
    private IUserService userService;

    @Test
    public void testHello() {
        System.out.println(userService.Hello());
    }
}
