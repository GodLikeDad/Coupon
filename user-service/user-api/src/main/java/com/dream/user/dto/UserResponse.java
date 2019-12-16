/**
 * @program dream
 * @description: 用户返回包装
 * @author: mf
 * @create: 2019/12/16 00:22
 */

package com.dream.user.dto;

import com.dream.commons.result.AbstractResponse;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse extends  AbstractResponse{


    private UserDto userDto;


}
