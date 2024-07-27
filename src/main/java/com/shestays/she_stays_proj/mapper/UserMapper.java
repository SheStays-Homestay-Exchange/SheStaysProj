package com.shestays.she_stays_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shestays.she_stays_proj.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据微信id查询用户信息
     * 
     * @param wechatId
     * @return
     */
    User getUserInfoByWechatId(String wechatId);
}
