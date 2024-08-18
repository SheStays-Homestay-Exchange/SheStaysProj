package com.shestays.she_stays_proj.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BuriedPointVo {

    /**
     * 埋点id
     */
    @JsonProperty("buriedId")
    private String buriedId;
    /**
     * 埋点key
     */
    @JsonProperty("key")
    private String key;
    /**
     * 埋点时间
     */
    @JsonProperty("spendTime")
    private Date spendTime;
    /**
     * 地理位置
     */
    @JsonProperty("location")
    private String location;
    /**
     * 所用设备
     */
    @JsonProperty("equipment")
    private String equipment;
    /**
     * 操作类型
     */
    @JsonProperty("operationType")
    private String operationType;
    /**
     * 房源id
     */
    @JsonProperty("houseId")
    private String houseId;
    /**
     * 搜索关键字
     */
    @JsonProperty("searchKeywords")
    private String searchKeywords;
    /**
     * 时长
     */
    @JsonProperty("duration")
    private int duration;
    /**
     * 备注
     */
    @JsonProperty("remark")
    private String remark;
}
