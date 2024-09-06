package com.shestays.she_stays_proj.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shestays.she_stays_proj.common.BaseEntity;
import com.shestays.she_stays_proj.entity.Role;

import lombok.Data;

/**
 * 用户vo实体
 */
@Data
public class UserVo extends BaseEntity {
    /**
     * 用户主键
     */
    @JsonProperty("userId")
    private Integer userId;
    /**
     * 用户名
     */
    @JsonProperty("userName")
    private String userName;
    /**
     * 用户密码
     */
    @JsonProperty("password")
    private String password;
    /**
     * 用户编码
     */
    @JsonProperty("userNo")
    private String userNo;
    /**
     * 邮箱
     */
    @JsonProperty("")
    private String email;
    /**
     * 手机号
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 头像url
     */
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    /**
     * 微信id
     */
    @JsonProperty("wechatId")
    private String wechatId;

    /**
     * 所在国家code
     */
    @JsonProperty("countryCode")
    private String countryCode;
    /**
     * 所在城市code
     */
    @JsonProperty("cityCode")
    private String cityCode;
    /**
     * 国家名称
     */
    @JsonProperty("nationName")
    private String nationName;
    /**
     * 城市名称
     */
    @JsonProperty("cityName")
    private String cityName;
    /**
     * 出生年
     */
    @JsonProperty("bdYear")
    private Integer bdYear;
    /**
     * 出生月
     */
    @JsonProperty("bdMonth")
    private Integer bdMonth;
    /**
     * 出生日
     */
    @JsonProperty("bdDay")
    private Integer bdDay;
    /**
     * 性别字典code
     */
    @JsonProperty("genderDictCode")
    private String genderDictCode;
    /**
     * 性别字典名
     */
    @JsonProperty("genderDictVal")
    private String genderDictVal;
    /**
     * 个人简介
     */
    @JsonProperty("personalProfile")
    private String personalProfile;
    /**
     * 用户角色
     */
    private List<Role> roles;
    /**
     * 小红书用户名
     */
    private String xiaohongshuUsername;
    /**
     * 小红书id
     */
    private String xiaohongshuId;

    /**
     * 微信open_id
     */
    @JsonProperty("openId")
    private String openId;
    /**
     * 国家编号
     */
    @JsonProperty("countryNum")
    private String countryNum;
    /**
     * 区域id
     */
    @JsonProperty("regionCode")
    private String regionCode;
    /**
     * 区域名
     */
    @JsonProperty("regionName")
    private String regionName;
    /**
     * 联系方式
     */
    @JsonProperty("contactInfo")
    private String contactInfo;
}
