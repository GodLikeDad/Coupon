/**
 * @program dshop
 * @description: 用户实体
 * @author: mf
 * @create: 2019/12/12 16:47
 */

package com.dream.dshop.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class User extends Model<User> {
    private Integer id;

    private String name;

    private String gender;
}
