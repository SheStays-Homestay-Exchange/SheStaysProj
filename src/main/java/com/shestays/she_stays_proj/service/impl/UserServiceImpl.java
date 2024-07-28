package com.shestays.she_stays_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.mapper.UserMapper;
import com.shestays.she_stays_proj.service.UserService;
import com.shestays.she_stays_proj.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper dao;

    @Override
    public UserVo getUserInfoByWechatId(String wechatId) {

        return dao.getUserInfoByWechatId(wechatId);
    }

    @Override
    public int editUserData(User user) {

        return dao.editUserData(user);
    }
}
