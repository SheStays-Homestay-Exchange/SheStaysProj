package com.shestays.she_stays_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shestays.she_stays_proj.entity.House;

@Repository
public interface HouseMapper {
    /**
     * 房源列表信息
     * 
     * @param pageIndex 当前页
     * @return 房源信息
     */
    List<House> getHouse(Integer pageIndex);

    /**
     * 获取总页数
     * 
     * @return
     */
    Integer getCount();

    /**
     * 根据地区查询房源信息
     * 
     * @param region 国家或城市
     * @return 房源信息
     */
    List<House> getHouseByRegion(String region);
}
