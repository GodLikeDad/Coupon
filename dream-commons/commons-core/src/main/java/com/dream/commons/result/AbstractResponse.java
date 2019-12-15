/**
 * @program dream
 * @description: 抽象返回类
 * @author: mf
 * @create: 2019/12/14 23:37
 */

package com.dream.commons.result;

import java.io.Serializable;

public abstract class AbstractResponse implements Serializable {

    private static final long serivalVersionUID = 7642323132212L;

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
