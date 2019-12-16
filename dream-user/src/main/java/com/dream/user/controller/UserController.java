/**
 * @program dream
 * @description: 用户消费者
 * @author: mf
 * @create: 2019/12/14 20:42
 */

package com.dream.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.commons.result.ResponseData;
import com.dream.commons.result.ResponseUtil;
import com.dream.user.IUserService;
import com.dream.user.dto.UserRequest;
import com.dream.user.dto.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping("/test")
    public String hello() {
        return userService.Hello();
    }

    @GetMapping("/user/{id}")
    public ResponseData searchUserById(@PathVariable(name = "id")Integer id) {
        UserRequest req = new UserRequest();
        UserResponse res = new UserResponse();
        res = userService.userById(req);
        return new ResponseUtil<Object>().setData(res);
    }
}
