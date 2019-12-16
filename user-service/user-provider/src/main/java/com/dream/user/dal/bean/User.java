package com.dream.user.dal.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * ⽤户基础信息表
 * </p>
 *
 * @author mf
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 地址
     */
    private String address;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 积分值
     */
    private Integer point;

    private String remark;

    /**
     * 备份电话
     */
    private String telPhone;

    /**
     * ⽤户昵称
     */
    private String username;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 账户⾦额
     */
    private Long balance;


}
