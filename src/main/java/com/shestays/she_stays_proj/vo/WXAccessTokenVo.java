package com.shestays.she_stays_proj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WXAccessTokenVo {
    // 获取到的凭证
    @JsonProperty("session_key")
    private String sessionKey;
    // 凭证有效时间，单位：秒
    // @JsonProperty("expires_in")
    // private String expiresIn;
    // 表示更新令牌，用来获取下一次的访问令牌
    // @JsonProperty("refresh_token")
    // private String refreshToken;
    // 该用户在此公众号下的身份标识，对于此微信号具有唯一性
    @JsonProperty("openid")
    private String openId;
    // 表示权限范围
    // @JsonProperty("scope")
    // private String scope;

}
