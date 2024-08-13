package com.shestays.she_stays_proj.vo;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
     * 国家名称
     */
    private String nationName;
    /**
     * 所在城市
     */
    private Integer cityId;
    /**
     * 城市名称
     */
    private String cityName;
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
    /**
     * 小红书用户吗
     */
    private String xiaohongshuUsername;
    /**
     * 小红书id
     */
    private String xiaohongshuId;

}
