package com.dream.user;


import com.dream.user.dto.UserRequest;
import com.dream.user.dto.UserResponse;

public interface IUserService {
    String Hello();

    UserResponse userById(UserRequest request);
}
