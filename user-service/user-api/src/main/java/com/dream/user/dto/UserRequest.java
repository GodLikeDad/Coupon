/**
 * @program dream
 * @description: 用户请求封装
 * @author: mf
 * @create: 2019/12/16 00:14
 */

package com.dream.user.dto;

import com.dream.commons.result.AbstractRequest;
import lombok.Data;

@Data
public class UserRequest extends AbstractRequest {

    /**
     * 根据id寻找用户
     */
    private Integer id;

    public void requestCheck() {

    }
}
