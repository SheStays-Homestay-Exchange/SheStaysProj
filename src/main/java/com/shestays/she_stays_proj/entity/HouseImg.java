package com.shestays.she_stays_proj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shestays.she_stays_proj.common.BaseEntity;

import lombok.Data;

/**
 * 房源图片信息表
 */
@Data
@TableName("ss_house_img")
public class HouseImg extends BaseEntity {
    /**
     * 房源图片信息表id
     */
    private Integer houseImgId;
    /**
     * 房源表id
     */
    private Integer houseId;
    /**
     * 图片url
     */
    private String imgUrl;
}
