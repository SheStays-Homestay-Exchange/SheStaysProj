package com.shestays.she_stays_proj.vo;

import java.util.Date;

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
    private Integer statusId;
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
    private Integer countId;
    /**
     * 所在城市
     */
    private Integer cityId;
    /**
     * 所在区
     */
    private Integer areaId;
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
}
