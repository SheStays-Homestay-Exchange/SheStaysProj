package com.shestays.she_stays_proj.service;

import com.shestays.she_stays_proj.entity.User;

public interface WeixinService {
    /**
     * 获取微信敏感数据解密
     * 
     * @param encryptedData
     * @param code
     * @param vi
     * @return
     */
    User getWXUserInfo(String encryptedData, String code, String vi) throws Exception;
}
