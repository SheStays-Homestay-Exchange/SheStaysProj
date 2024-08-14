package com.shestays.she_stays_proj.common;

public enum ResponseCode {
    /**
     * 请求成功
     */
    SUCCESS("200", "请求成功") // 成功表示
    /**
     * 无数据
     */
    ,NO_DATA("204", "无数据")
    /**
     * 系统异常
     */
    ,ERROR("500", "系统异常")
    /**
     * 未授权
     */
    ,NO_PERMISSIONS("401", "未授权")

    /**
     * 请求参数异常
     */
    ,GET_PARAM_ERROR("402", "请求参数异常")
    /**
     * 网关错误
     */
    ,BAD_GETWAY("502", "网关错误"),
    /**
     * 授权失败
     */
    PERMISSION_ERROR("503", "授权失败");

    public final String value;
    public final String describe;

    private ResponseCode(String value, String describe) {
        this.value = value;
        this.describe = describe;
    }
}
