package com.shestays.she_stays_proj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.service.UserService;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据微信号查询用户信息
     */
    @PostMapping("getUserInfoByWechatId")
    public String getUserInfoByWechatId(String wechatId) {
        ResponsePojo responseBody = new ResponsePojo();
        try {
            log.info("request-param:" + wechatId);
            User user = userService.getUserInfoByWechatId(wechatId);

            responseBody.setMsg(ResponseMsg.MSG_SUCCESS);
            responseBody.setCode(ResponseCode.SUCCESS.value);
            responseBody.setData(user);
            log.info("getRest:" + JSONObject.toJSONString(responseBody, SerializerFeature.WriteMapNullValue));

            return JSONObject.toJSONString(responseBody, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            responseBody.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responseBody.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getUserInfoByWechatId", e.getMessage());
            return JSONObject.toJSONString(responseBody, SerializerFeature.WriteMapNullValue);
        }

    }

}
