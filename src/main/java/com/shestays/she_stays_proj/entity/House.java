package com.shestays.she_stays_proj.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 房源实体类
 */
@Data
@TableName("ss_house")
public class House extends BaseEntity {
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
     * 开放开始时间
     */
    private Date startTime;
    /**
     * 开放结束时间
     */
    private Date endTime;

    /**
     * 所在国家
     */
    private String countryCode;
    /**
     * 所在城市
     */
    private String cityCode;
    /**
     * 所在区
     */
    private String regionCode;
    /**
     * 详细地址
     */
    private String detailArea;
    /**
     * 审核不通过原因
     */
    private Integer unpassReason;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 所在区名称
     */
    private String regionName;
    /**
     * 洲名
     */
    private String continentName;
    /**
     * 区code
     */
    private String districtCode;
    /**
     * 区名
     */
    private String districtName;
    /**
     * 房主联系方式
     */
    private String contactInfo;
}
