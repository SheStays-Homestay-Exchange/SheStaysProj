package com.shestays.she_stays_proj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.shestays.she_stays_proj.common.BusinessException;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.service.UserService;
import com.shestays.she_stays_proj.service.WeixinService;
import com.shestays.she_stays_proj.vo.UserReqVo;
import com.shestays.she_stays_proj.vo.UserVo;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private WeixinService weixinService;

    /**
     * 根据微信号查询用户信息
     * 
     * @param openId 微信唯一标识
     * @return 用户信息json数据
     */
    @GetMapping("getUserInfoByOpenId")
    @ResponseJSONP
    public ResponsePojo getUserInfoByWechatId(String openId) {
        ResponsePojo responseBody = new ResponsePojo();
        try {
            if (null == openId || openId.isBlank()) {
                responseBody.setMsg(ResponseMsg.MSG_GET_PARAM_NULL_ERROR);
                responseBody.setCode(ResponseCode.GET_PARAM_ERROR.value);
                return responseBody;
            }

            log.info("request-param-getUserInfoByWechatId:" + openId);
            UserVo user = userService.getUserInfoByWechatId(openId);

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
    public ResponsePojo editUserData(UserVo userData) {
        ResponsePojo responsePojo = new ResponsePojo();
        log.info("request-param-editUserData:" + JSONObject.toJSONString(userData));
        try {
            if (userData.getUserId() == 0) {
                responsePojo.setMsg(ResponseMsg.MSG_DEL_ERROR);
                responsePojo.setCode(ResponseCode.GET_PARAM_ERROR.value);
                log.error("userId  is null");
                return responsePojo;
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
                responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
                responsePojo.setCode(ResponseCode.SUCCESS.value);
                log.info("user edit is successful");
            }
            return responsePojo;
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-editUserData:" + e.getMessage());
            return responsePojo;
        }

    }

    /**
     * 用户授权
     * 
     * @param userData
     * @return
     */
    @PostMapping("userAuthor")
    @ResponseJSONP
    public ResponsePojo userAuthor(@RequestBody UserReqVo reqParam) {
        ResponsePojo responsePojo = new ResponsePojo();
        String code = reqParam.getCode();
        String encryptedData = reqParam.getEncryptedData();
        String iv = reqParam.getIv();
        String xhsId = reqParam.getXhsId();
        log.info("userAuthor-param:" + JSONObject.toJSONString(reqParam, SerializerFeature.WriteMapNullValue));
        try {
            User user = weixinService.getWXUserInfo(encryptedData, code, iv);
            user.setXiaohongshuId(xhsId);
            String openId = userService.addorEditUserInfo(user);
            UserVo getUserVo = userService.getUserInfoByWechatId(openId);
            responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
            responsePojo.setCode(ResponseCode.SUCCESS.value);
            responsePojo.setData(getUserVo);
            log.info("getRest-userAuthor:"
                    + JSONObject.toJSONString(responsePojo, SerializerFeature.WriteMapNullValue));
        } catch (BusinessException be) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("userAuthor-editUserData:" + be.getMessage());
            return responsePojo;
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("userAuthor-editUserData:" + e.getMessage());
            return responsePojo;
        }
        return responsePojo;
    }

}
