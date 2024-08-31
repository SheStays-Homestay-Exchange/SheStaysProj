package com.shestays.she_stays_proj.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.vo.UserVo;

@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据微信id查询用户信息
     * 
     * @param openId
     * @return
     */
    UserVo getUserInfoByWechatId(String openId);

    /**
     * 根据用户id查询用户信息
     * 
     * @param userId
     * @return
     */
    UserVo getUserInfoByUserId(Integer userId);

    /**
     * 修改用户信息
     * 
     * @param user 用户信息实体
     * @return 更新成功标识
     */
    int editUserData(User user);

    /**
     * 用户授权，初期用户小红书id不为空
     * 
     * @param openId      微信唯一标识
     * @param phoneNumber 电话号码
     * @param countryCode 城市编号
     * @param xhsId       小红书id
     * @return
     */
    int editUserDataByxhsId(User user);

    /**
     * 根据小红书id查询用户信息
     * 
     * @param xhsId
     * @return
     */
    UserVo getUserByXhsId(String xhsId);

    /**
     * 根据openid获取用户信息
     * 
     * @param openId
     * @return
     */
    UserVo getUserByopenId(String openId);

    /**
     * 新增用户
     * 
     * @param openId      微信唯一标识
     * @param phoneNumber 电话号码
     * @param countryCode 城市编号
     * @return
     */
    int addUserInfo(User user);

}
