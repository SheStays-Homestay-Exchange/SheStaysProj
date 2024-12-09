package com.shestays.she_stays_proj.service;

import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.vo.UserVo;

public interface UserService {

    /**
     * 根据微信id查询用户信息
     * 
     * @param openId 微信唯一标识
     * @return 用户vo实体
     */
    UserVo getUserInfoByWechatId(String openId);

    /**
     * 根据用户id查询用户信息
     * 
     * @param userId 用户id
     * @return
     */
    UserVo getUserInfoByUserId(Integer userId);

    /**
     * 编辑用户信息
     */
    int editUserData(User user);

    /**
     * 用户授权，初期用户小红书id不为空
     * 
     * @param user
     * @return openid
     */
    String addorEditUserInfo(User user);

    /**
     * 注销用户
     * 
     * @param userId
     * @return
     */
    int delUserById(UserVo userVo);
}
