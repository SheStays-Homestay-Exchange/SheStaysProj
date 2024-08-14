package com.shestays.she_stays_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.common.BusinessException;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.mapper.UserMapper;
import com.shestays.she_stays_proj.service.UserService;
import com.shestays.she_stays_proj.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper dao;

    @Override
    public UserVo getUserInfoByWechatId(String openId) {

        return dao.getUserInfoByWechatId(openId);
    }

    @Override
    public int editUserData(User user) {

        return dao.editUserData(user);
    }

    @Override
    public int addorEditUserInfo(User user) {

        if (null != user.getXiaohongshuId()) {
            UserVo getUserInfo = dao.getUserByXhsId(user.getXiaohongshuId());
            // 更新用户信息
            if (null != getUserInfo.getUserId()) {
                user.setUserId(getUserInfo.getUserId());
                return dao.editUserDataByxhsId(user);
            }

        } else {
            UserVo getUserInfo = dao.getUserByopenId(user.getOpenId());
            // 更新用户信息
            if (null != getUserInfo.getUserId()) {
                user.setUserId(getUserInfo.getUserId());
                return dao.editUserDataByxhsId(user);
            } else {
                // 新增用户信息
                return dao.addUserInfo(user);
            }

        }
        throw new BusinessException(ResponseCode.PERMISSION_ERROR.value, ResponseMsg.MSG_USER_AUTHOR_ERROR);
    }
}
