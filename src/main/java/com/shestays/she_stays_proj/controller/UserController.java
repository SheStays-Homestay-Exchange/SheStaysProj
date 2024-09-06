package com.shestays.she_stays_proj.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @Value("${file-path}")
    private String userFilePath;
    @Value("${file-access-path}")
    private String fileAccessPath;

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
            log.error("errorMsg-getUserInfoByWechatId:" + e.getCause().getMessage());
            return responseBody;
        }

    }

    @GetMapping("getUserInfoByUserId")
    @ResponseJSONP
    public ResponsePojo getUserInfoByUserId(Integer userId) {
        ResponsePojo responseBody = new ResponsePojo();
        try {
            if (null == userId) {
                responseBody.setMsg(ResponseMsg.MSG_GET_PARAM_NULL_ERROR);
                responseBody.setCode(ResponseCode.GET_PARAM_ERROR.value);
                return responseBody;
            }
            UserVo user = userService.getUserInfoByUserId(userId);
            responseBody.setMsg(ResponseMsg.MSG_SUCCESS);
            responseBody.setCode(ResponseCode.SUCCESS.value);
            responseBody.setData(user);
            log.info("getRest-getUserInfoByUserId:"
                    + JSONObject.toJSONString(responseBody, SerializerFeature.WriteMapNullValue));
            return responseBody;
        } catch (Exception e) {
            responseBody.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responseBody.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getUserInfoByUserId:" + e.getCause().getMessage());
            return responseBody;
        }

    }

    /**
     * 编辑个人信息
     * 
     * @param userData
     * @return
     */
    @PostMapping("editUserData")
    @ResponseJSONP
    public ResponsePojo editUserData(@RequestBody UserVo userData, MultipartFile avatar) {
        ResponsePojo responsePojo = new ResponsePojo();
        log.info("request-param-editUserData:" + JSONObject.toJSONString(userData));
        try {
            if (null == userData.getUserId() || userData.getUserId() == 0) {
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
            user.setCountryCode(userData.getCountryCode());
            user.setCityCode(userData.getCityCode());
            user.setRegionCode(userData.getRegionCode());
            user.setPhone(userData.getPhone());
            user.setWechatId(userData.getWechatId());
            user.setPersonalProfile(userData.getPersonalProfile());
            user.setAvatarUrl(userData.getAvatarUrl());
            int rest = userService.editUserData(user);
            log.info("getRest-editUserData:" + rest);
            if (rest == 1) {
                responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
                responsePojo.setCode(ResponseCode.SUCCESS.value);
                responsePojo.setData(user);
                log.info("user edit is successful");
            }
            return responsePojo;
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-editUserData:" + e.getCause().getMessage());
            return responsePojo;
        }
    }

    @PostMapping("uploadAvatar")
    @ResponseJSONP
    public ResponsePojo uploadAvatarImg(UserReqVo userReqVo,
            @RequestParam("avatar") MultipartFile avatar) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            if (null == userReqVo.getUserId() || userReqVo.getUserId() == 0) {
                responsePojo.setMsg(ResponseMsg.MSG_USER_ID_NULL);
                responsePojo.setCode(ResponseCode.GET_PARAM_ERROR.value);
                log.error("userId  is null");
                return responsePojo;
            }
            User user = new User();
            // 上传头像
            if (null != avatar) {
                String avatarUrl = uploadAvatar(avatar, userReqVo.getUserId());

                responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
                responsePojo.setCode(ResponseCode.SUCCESS.value);
                responsePojo.setData(avatarUrl);
                log.info("uploadAvatarImg is successful:"
                        + JSONObject.toJSONString(responsePojo, SerializerFeature.WriteMapNullValue));
            }

        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-uploadAvatarImg:" + e.getCause().getMessage());
            return responsePojo;
        }
        return responsePojo;
    }

    /**
     * 上传头像
     */
    private String uploadAvatar(MultipartFile file, Integer userId) throws IOException {
        String urlPath = "avatar_" + userId;
        String filePath = userFilePath + urlPath + "/";
        // 判断文件是否存在
        File dest = new File(filePath);
        // FileUtils.deleteDirectory(dest);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("image/jpeg");
        fileTypes.add("image/png");
        fileTypes.add("image/jpg");
        try {
            if (file.getSize() / 10000 > 100) {
                throw new BusinessException(ResponseCode.GET_PARAM_ERROR.value, ResponseMsg.MSG_FILE_TOO_BIG);
            } else {
                String fileType = file.getContentType();
                if (fileTypes.contains(fileType)) {
                    // 获取文件名
                    String fileName = file.getOriginalFilename();
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    // 重新生成文件名
                    fileName = UUID.randomUUID() + suffixName;
                    String filePathNew = filePath + fileName;
                    file.transferTo(new File(filePathNew));
                    // 设置访问路径
                    String accessPath = fileAccessPath + urlPath + "/" + fileName;
                    return accessPath;
                } else {
                    throw new BusinessException(ResponseCode.GET_PARAM_ERROR.value,
                            ResponseMsg.MSG_FILE_TYPE_ERROR);
                }
            }
        } catch (IOException e) {
            throw e;
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
            log.info("userAuthor-getWXUserInfo:" + JSONObject.toJSONString(user, SerializerFeature.WriteMapNullValue));
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
            log.error("userAuthor-userAuthor-error:" + be.getCause().getMessage());
            return responsePojo;
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("userAuthor-userAuthor-erroe:" + e.getCause().getMessage());
            return responsePojo;
        }
        return responsePojo;
    }

    /**
     * 用户注销
     * 
     * @param userVo
     * @return
     */
    @PostMapping("delUserById")
    @ResponseJSONP
    public ResponsePojo delUserById(@RequestBody UserVo userVo) {
        ResponsePojo responsePojo = new ResponsePojo();
        try {
            log.info("userAuthor-delUserById:" + JSONObject.toJSONString(userVo, SerializerFeature.WriteMapNullValue));
            userService.delUserById(userVo);
            responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
            responsePojo.setCode(ResponseCode.SUCCESS.value);
            return responsePojo;
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("userAuthor-userAuthor-erroe:" + e.getCause().getMessage());
            return responsePojo;
        }

    }

}
