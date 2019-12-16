/**
 * @program dream
 * @description: 包装user
 * @author: mf
 * @create: 2019/12/16 00:12
 */

package com.dream.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable{

    private Integer id;

    private String name;

    private String gender;
}
