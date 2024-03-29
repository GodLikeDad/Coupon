/**
 * @program dream
 * @description: 返回工具类
 * @author: mf
 * @create: 2019/12/15 21:20
 */

package com.dream.commons.result;

public class ResponseUtil<T> {

    private ResponseData<T> responseData;

    public ResponseUtil() {
        responseData = new ResponseData<T>();
        responseData.setSuccess(true);
        responseData.setMessage("success");
        responseData.setCode(200);
    }

    public ResponseData<T> setData(T t) {
        this.responseData.setResult(t);
        this.responseData.setSuccess(true);
        responseData.setCode(200);
        return this.responseData;
    }

    public ResponseData<T> setData(T t, String msg) {
        this.responseData.setResult(t);
        this.responseData.setMessage(msg);
        this.responseData.setSuccess(true);
        responseData.setCode(200);
        return responseData;
    }

    public ResponseData<T> setErrorMsg(String msg) {
        this.responseData.setSuccess(false);
        this.responseData.setMessage(msg);
        responseData.setCode(500);
        return this.responseData;
    }

    public ResponseData<T> setErrorMsg(Integer code, String msg) {
        this.responseData.setSuccess(false);
        this.responseData.setMessage(msg);
        responseData.setCode(code);
        return this.responseData;
    }
}
