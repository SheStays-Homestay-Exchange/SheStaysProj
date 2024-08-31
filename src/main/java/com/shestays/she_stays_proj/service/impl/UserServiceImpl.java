package com.shestays.she_stays_proj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper dao;

    @Override
    public UserVo getUserInfoByWechatId(String openId) {

        try {
            return dao.getUserInfoByWechatId(openId);
        } catch (Exception e) {
            log.error("getUserInfoByWechatId-error", e.getMessage());
            log.error("getUserInfoByWechatId-error", e.toString());
            throw e;
        }

    }

    @Override
    public int editUserData(User user) {
        try {
            return dao.editUserData(user);
        } catch (Exception e) {
            log.error("editUserData-error", e.getMessage());
            log.error("editUserData-error", e.toString());
            throw e;
        }

    }

    @Override
    public String addorEditUserInfo(User user) {
        try {
            if (null != user.getXiaohongshuId()) {
                // UserVo getUserInfo = dao.getUserByXhsId(user.getXiaohongshuId());
                UserVo getUserInfo = dao.getUserByopenId(user.getOpenId());
                // 更新用户信息
                if (null != getUserInfo && null != getUserInfo.getUserId()) {
                    user.setUserId(getUserInfo.getUserId());
                    dao.editUserDataByxhsId(user);
                    return user.getOpenId();
                }

            } else {
                UserVo getUserInfo = dao.getUserByopenId(user.getOpenId());
                // 更新用户信息
                if (null != getUserInfo && null != getUserInfo.getUserId()) {
                    user.setUserId(getUserInfo.getUserId());
                    dao.editUserDataByxhsId(user);
                    return user.getOpenId();
                } else {
                    // 新增用户信息
                    dao.addUserInfo(user);
                    return user.getOpenId();
                }
            }
        } catch (Exception e) {
            log.error("addorEditUserInfo-error", e.getMessage());
            log.error("addorEditUserInfo-error", e.toString());
            throw e;
        }
        throw new BusinessException(ResponseCode.PERMISSION_ERROR.value, ResponseMsg.MSG_USER_AUTHOR_ERROR);
    }

    @Override
    public UserVo getUserInfoByUserId(Integer userId) {
        try {
            return dao.getUserInfoByUserId(userId);
        } catch (Exception e) {
            log.error("getUserInfoByWechatId-error", e.getMessage());
            log.error("getUserInfoByWechatId-error", e.toString());
            throw e;
        }
    }
}
