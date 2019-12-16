package com.dream.user.converter;

import com.dream.user.dal.bean.User;
import com.dream.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({})
    UserDto user2Res(User user);
}
