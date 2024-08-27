package com.shestays.she_stays_proj.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("ss_district")
public class District {
    /**
     * 区/县代码
     */
    private String districtCode;
    /**
     * 区/县名称
     */
    private String districtName;
    /**
     * 区/县经度
     */
    private String districtLon;
    /**
     * 区/县纬度
     */
    private String districtLat;
    /**
     * 城市代码
     */
    private String cityCode;
}
