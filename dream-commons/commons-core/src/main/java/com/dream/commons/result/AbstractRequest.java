/**
 * @program dream
 * @description: 抽象请求类
 * @author: mf
 * @create: 2019/12/14 23:35
 */

package com.dream.commons.result;

import java.io.Serializable;

public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 171717171717171L;

    public abstract void requestCheck();
}
