package com.shestays.she_stays_proj.mapper;

import org.springframework.stereotype.Repository;

import com.shestays.she_stays_proj.entity.HouseImg;

@Repository
public interface HouseImgMapper {
    /**
     * 新增房源图片信息
     * 
     * @param houseImg 房源图片信息
     * @return 图片信息id
     */
    Integer addHouseImg(HouseImg houseImg);
}
