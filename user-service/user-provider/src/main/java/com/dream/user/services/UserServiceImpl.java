/**
 * @program dream
 * @description: 用户服务
 * @author: mf
 * @create: 2019/12/14 01:22
 */

package com.dream.user.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.user.IUserService;
import org.springframework.stereotype.Component;

@Component
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public String Hello() {
        return "Hello Dubbo...";
    }
}
