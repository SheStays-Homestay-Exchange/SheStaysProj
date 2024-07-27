package com.shestays.she_stays_proj.entity;

import java.util.List;

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
    private String userId;
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
     * 房源id
     */
    private String houseId;
    /**
     * 头像url
     */
    private String avatarUrl;
    /**
     * 微信id
     */
    private String wechatId;

    /**
     * 所在国家
     */
    private String nationId;
    /**
     * 所在城市
     */
    private String cityId;
    /**
     * 出生年
     */
    private String bdYear;
    /**
     * 出生月
     */
    private String bdMonth;
    /**
     * 出生日
     */
    private String bdDay;
    /**
     * 性别字典code
     */
    private String genderDictCode;
    /**
     * 性别字典名
     */
    private String genderDictVal;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 用户角色
     */
    private List<Role> roles;

}
