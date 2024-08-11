package com.shestays.she_stays_proj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.service.UserService;
import com.shestays.she_stays_proj.vo.UserVo;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据微信号查询用户信息
     * 
     * @param wechatId 微信id
     * @return 用户信息json数据
     */
    @PostMapping("getUserInfoByWechatId")
    @ResponseJSONP
    public ResponsePojo getUserInfoByWechatId(String wechatId) {
        ResponsePojo responseBody = new ResponsePojo();
        try {
            if (wechatId.isBlank()) {
                responseBody.setMsg(ResponseMsg.MSG_GET_PARAM_NULL_ERROR);
                responseBody.setCode(ResponseCode.GET_PARAM_ERROR.value);
                return responseBody;
            }

            log.info("request-param-getUserInfoByWechatId:" + wechatId);
            UserVo user = userService.getUserInfoByWechatId(wechatId);

            responseBody.setMsg(ResponseMsg.MSG_SUCCESS);
            responseBody.setCode(ResponseCode.SUCCESS.value);
            responseBody.setData(user);
            log.info("getRest-getUserInfoByWechatId:"
                    + JSONObject.toJSONString(responseBody, SerializerFeature.WriteMapNullValue));
            return responseBody;
        } catch (Exception e) {
            responseBody.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responseBody.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getUserInfoByWechatId:" + e.getMessage());
            return responseBody;
        }

    }

    @PostMapping("editUserData")
    @ResponseJSONP
    public ResponsePojo editUserData(@RequestBody UserVo userData) {
        ResponsePojo responseBody = new ResponsePojo();
        log.info("request-param-editUserData:" + JSONObject.toJSONString(userData));
        try {
            if (userData.getUserId() == 0) {
                responseBody.setMsg(ResponseMsg.MSG_DEL_ERROR);
                responseBody.setCode(ResponseCode.GET_PARAM_ERROR.value);
                log.error("userId  is null");
                return responseBody;
            }
            User user = new User();
            user.setUserId(userData.getUserId());
            user.setUserName(userData.getUserName());
            user.setGenderDictCode(userData.getGenderDictCode());
            user.setBdYear(userData.getBdYear());
            user.setBdMonth(userData.getBdMonth());
            user.setBdDay(userData.getBdDay());
            user.setNationId(userData.getNationId());
            user.setCityId(userData.getCityId());
            user.setPhone(userData.getPhone());
            user.setWechatId(userData.getWechatId());
            user.setPersonalProfile(userData.getPersonalProfile());
            int rest = userService.editUserData(user);
            log.info("getRest-editUserData:" + rest);
            if (rest == 1) {
                responseBody.setMsg(ResponseMsg.MSG_SUCCESS);
                responseBody.setCode(ResponseCode.SUCCESS.value);
                log.info("user edit is successful");
            }
            return responseBody;
        } catch (Exception e) {
            responseBody.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responseBody.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-editUserData:" + e.getMessage());
            return responseBody;
        }

    }

}
