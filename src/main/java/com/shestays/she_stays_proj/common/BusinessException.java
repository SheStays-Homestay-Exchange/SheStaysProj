package com.shestays.she_stays_proj.common;

public class BusinessException extends RuntimeException {
    private String restCd;
    private String msg;

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String restCd, String msg) {
        super();
        this.restCd = restCd;
        this.msg = msg;
    }

    public String getRestCd() {
        return this.restCd;
    }

    public String getMsg() {
        return this.msg;
    }
}
