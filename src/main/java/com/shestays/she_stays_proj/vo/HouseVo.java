package com.shestays.she_stays_proj.vo;

import java.util.Date;
import java.util.List;

import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 房子vo实体
 */
@Data
public class HouseVo extends BaseEntity {
    /**
     * 房源id
     */
    private Integer houseId;
    /**
     * 房源title
     */
    private String houseTitle;
    /**
     * 房源主页图url
     */
    private String homePageImgUrl;
    /**
     * 可接待客房数
     */
    private Integer houseAmount;
    /**
     * 对房客说的话
     */
    private String describle;
    /**
     * 审核状态code
     */
    private String statusCode;
    /**
     * 审核状态
     */
    private String statusValue;
    /**
     * 开放开始时间
     */
    private Date startTime;
    /**
     * 开放结束时间
     */
    private Date endTime;
    /**
     * 所在国家code
     */
    private String countryCode;
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 所在城市
     */
    private String cityCode;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 所在区
     */
    private String regionCode;
    /**
     * 所在区名称
     */
    private String regionName;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 审核不通过原因
     */
    private String unpassReason;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 房源图片url
     */
    private List<HouseImgVo> houseImgs;

    /**
     * 房主小红书id
     */
    private String xiaohongshuId;
    /**
     * 小红书名
     */
    private String xiaohongshuUsername;
    /**
     * 用户微信唯一标识
     */
    private String openId;
    /**
     * 房主手机号
     */
    private String phone;
    /**
     * 房主头像url
     */
    private String avatarUrl;
}
