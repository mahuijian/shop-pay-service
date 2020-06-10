package com.mhj.web;

/**
 * @author mahuijian
 * @since 2020-04-01
 */
public class AbstractResponse<T> {
    public static final String SUCCESS = "success";
    protected int status;
    protected String message;

    public AbstractResponse() {
    }

    public static String getSUCCESS() {
        return "success";
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
