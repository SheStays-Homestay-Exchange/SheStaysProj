package com.shestays.she_stays_proj.vo;

import java.util.Date;

import lombok.Data;

/**
 * 房源上传实体
 */
@Data
public class HouseUploadVo {
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
    private Integer statusId;
    /**
     * 审核状态
     */
    private String statusValue;
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
    private Integer countryId;
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 所在城市
     */
    private Integer cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 所在区
     */
    private Integer regionId;
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
     * 大洲id
     */
    private Integer continentId;

}
