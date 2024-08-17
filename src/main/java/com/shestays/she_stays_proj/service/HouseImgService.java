package com.shestays.she_stays_proj.service;

import com.shestays.she_stays_proj.entity.HouseImg;

public interface HouseImgService {
    /**
     * 新增房源图片信息
     * 
     * @param houseImg 房源图片信息
     * @return 图片信息id
     */
    Integer addHouseImg(HouseImg houseImg);

    /**
     * 删除房源图片信息
     * 
     * @param imgId 图片id
     * @return
     */
    int houseImgDel(Integer imgId);
}
