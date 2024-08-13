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
     * @param wechatId
     * @return
     */
    UserVo getUserInfoByWechatId(String wechatId);

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
     * @param wechatId      微信id
     * @param xiaohongshuId 小红书id
     * @return
     */
    int editUserDataByxiaohongshu(String wechatId, String xiaohongshuId);

}
