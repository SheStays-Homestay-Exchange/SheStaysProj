package com.shestays.she_stays_proj.service;

import java.util.List;

import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.vo.PageVo;

public interface HouseService {
    /**
     * 查询房源列表
     * 
     * @param page 页数
     * @return 房源列表
     */
    PageVo getHouse(Integer pageIndex);

    /**
     * 根据地区查询房源信息
     * 
     * @param region 国家或城市
     * @return 房源信息
     */
    List<House> getHouseByRegion(String region);
}
