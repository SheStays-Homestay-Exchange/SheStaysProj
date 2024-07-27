package com.shestays.she_stays_proj.service;

import java.util.List;

import com.shestays.she_stays_proj.entity.User;

public interface UserService {

    /**
     * 根据微信id查询用户信息
     */
    User getUserInfoByWechatId(String wechatId);
}
