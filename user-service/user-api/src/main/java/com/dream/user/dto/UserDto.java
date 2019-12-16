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

    private String account;

    private String address;

    private String phone;

    private Integer point;

    private String remark;

    private String telPhone;

    private String username;

    private String zipCode;

    private Long balance;
}
