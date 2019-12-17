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
import com.dream.user.constatns.SysRetCodeConstants;
import com.dream.user.dto.UserListResponse;
import com.dream.user.dto.UserRequest;
import com.dream.user.dto.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "UserController", description = "用户控制器")
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping("/test")
    @ApiOperation("测试接口")
    public String hello() {
        return userService.Hello();
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @ApiOperation("根据id获取用户")
    @GetMapping("/user/{id}")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true)
    public ResponseData searchUserById(@PathVariable(name = "id")Integer id) {
        UserRequest req = new UserRequest();
        req.setId(id);
        UserResponse res = userService.userById(req);
        if (!res.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<Object>().setErrorMsg(res.getMsg());
        }
        return new ResponseUtil<Object>().setData(res);
    }

    /**
     * 返回全部用户信息
     * @return
     */
    @GetMapping("/users")
    public ResponseData getUsers() {
        UserListResponse res = userService.users();
        if (!res.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<Object>().setErrorMsg(res.getMsg());
        }
        return new ResponseUtil<Object>().setData(res);
    }
}
