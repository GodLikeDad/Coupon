/**
 * @program dream
 * @description: 包装返回数据
 * @author: mf
 * @create: 2019/12/14 23:40
 */

package com.dream.commons.result;

public class ResponseData<T> {

    private boolean success;

    private String message; // 消息

    private int code;

    private T result; // 返回的数据

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
