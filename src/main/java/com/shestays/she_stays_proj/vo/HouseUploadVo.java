package com.shestays.she_stays_proj.vo;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 房源上传实体
 */
@Data
public class HouseUploadVo {
    /**
     * 房源id
     */
    @JsonProperty("houseId")
    private Integer houseId;
    /**
     * 房源title
     */
    @JsonProperty("houseTitle")
    private String houseTitle;
    /**
     * 房源主页图url
     */
    @JsonProperty("homePageImgUrl")
    private String homePageImgUrl;
    /**
     * 可接待客房数
     */
    @JsonProperty("houseAmount")
    private Integer houseAmount;
    /**
     * 对房客说的话
     */
    @JsonProperty("describle")
    private String describle;
    /**
     * 审核状态code
     */
    @JsonProperty("statusId")
    private Integer statusId;
    /**
     * 审核状态
     */
    @JsonProperty("statusValue")
    private String statusValue;
    /**
     * 审核状态code
     */
    @JsonProperty("statusCode")
    private String statusCode;
    /**
     * 开放开始时间
     */
    @JsonProperty("startTime")
    @JSONField(format = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/M/d")
    private Date startTime;
    /**
     * 开放结束时间
     */
    @JsonProperty("endTime")
    @JSONField(format = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/M/d")
    private Date endTime;
    /**
     * 所在国家
     */
    @JsonProperty("countryCode")
    private String countryCode;
    /**
     * 国家名称
     */
    @JsonProperty("countryName")
    private String countryName;
    /**
     * 所在城市
     */
    @JsonProperty("cityCode")
    private String cityCode;
    /**
     * 城市名称
     */
    @JsonProperty("cityName")
    private String cityName;
    /**
     * 所在区
     */
    @JsonProperty("regionCode")
    private String regionCode;
    /**
     * 所在区名称
     */
    @JsonProperty("regionName")
    private String regionName;
    /**
     * 详细地址
     */
    @JsonProperty("detailAddress")
    private String detailAddress;
    /**
     * 审核不通过原因
     */
    @JsonProperty("unpassReason")
    private String unpassReason;
    /**
     * 用户id
     */
    @JsonProperty("userId")
    private Integer userId;
    /**
     * 大洲id
     */
    @JsonProperty("continentId")
    private Integer continentId;

    /**
     * 图片地址集合
     */
    @JsonProperty("houseImgPath")
    private List<String> houseImgPath;

}
