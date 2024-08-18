package com.shestays.she_stays_proj.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 埋点表
 */
@Data
@TableName("ss_buried_point")
public class BuriedPoint {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 埋点id
     */
    private String buriedId;
    /**
     * 埋点key
     */
    private String key;
    /**
     * 埋点时间
     */
    private Date spendTime;
    /**
     * 地理位置
     */
    private String location;
    /**
     * 所用设备
     */
    private String equipment;
    /**
     * 操作类型
     */
    private String operationType;
    /**
     * 房源id
     */
    private String houseId;
    /**
     * 搜索关键字
     */
    private String searchKeywords;
    /**
     * 时长
     */
    private int duration;
    /**
     * 备注
     */
    private String remark;
}
