package com.shestays.she_stays_proj.service;

import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.vo.UserVo;

public interface UserService {

    /**
     * 根据微信id查询用户信息
     * 
     * @param wechatId 微信id
     * @return 用户vo实体
     */
    UserVo getUserInfoByWechatId(String wechatId);

    /**
     * 编辑用户信息
     */
    int editUserData(User user);
}
