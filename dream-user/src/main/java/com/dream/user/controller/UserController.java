/**
 * @program dream
 * @description: 用户消费者
 * @author: mf
 * @create: 2019/12/14 20:42
 */

package com.dream.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.user.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping("/test")
    public String hello() {
        return userService.Hello();
    }
}
