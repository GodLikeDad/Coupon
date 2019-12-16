/**
 * @program dream
 * @description: 用户请求封装
 * @author: mf
 * @create: 2019/12/16 00:14
 */

package com.dream.user.dto;

import com.dream.commons.result.AbstractRequest;

public class UserRequest extends AbstractRequest {

    private Integer id;

    private String name;

    public void requestCheck() {

    }
}
