/**
 * @program dream
 * @description: UserMapper测试
 * @author: mf
 * @create: 2019/12/14 01:02
 */

package com.dream.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.user.dal.bean.User;
import com.dream.user.dal.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAllUsers() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>());
        for (User user : users) {
            System.out.println(user);
        }
    }
}
