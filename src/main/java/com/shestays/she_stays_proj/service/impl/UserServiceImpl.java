package com.shestays.she_stays_proj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.mapper.UserMapper;
import com.shestays.she_stays_proj.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper dao;

    @Override
    public User getUserInfoByWechatId(String wechatId) {

        return dao.getUserInfoByWechatId(wechatId);
    }
}
