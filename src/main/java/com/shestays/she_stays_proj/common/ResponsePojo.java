package com.shestays.she_stays_proj.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * 接口响应实体
 */
@Data
public class ResponsePojo implements Serializable {
    /**
     * 响应code
     */
    private String code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;

}
