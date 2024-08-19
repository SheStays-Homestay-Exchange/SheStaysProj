package com.shestays.she_stays_proj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 用户
 */
@Data
@TableName("ss_user")
public class User extends BaseEntity {
    /**
     * 用户主键
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像url
     */
    private String avatarUrl;
    /**
     * 微信id
     */
    private String wechatId;

    /**
     * 所在国家id
     */
    private Integer nationId;
    /**
     * 所在城市
     */
    private Integer cityId;
    /**
     * 出生年
     */
    private Integer bdYear;
    /**
     * 出生月
     */
    private Integer bdMonth;
    /**
     * 出生日
     */
    private Integer bdDay;
    /**
     * 性别字典code
     */
    private String genderDictCode;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 微信open_id
     */
    private String openId;
    /**
     * 国家编号
     */
    private String countryCode;
    /**
     * 小红书名
     */
    private String xiaohongshuUsername;
    /**
     * 小红书id
     */
    private String xiaohongshuId;
    /**
     * 区域id
     */
    private Integer regionId;

}
