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

    /**
     * 根据id获取图片信息
     * 
     * @param imgId 图片id
     * @return
     */
    HouseImg getHouseImgById(Integer imgId);

    /**
     * 删除房源图片信息
     * 
     * @param imgId
     * @return
     */
    int deleteHouseImg(Integer imgId);

    /**
     * 根据房源id删除图片信息
     * 
     * @param houseId
     * @return
     */
    int houseImgDelByHouseId(Integer houseId);
}
