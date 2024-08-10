package com.shestays.she_stays_proj.service;

import java.util.List;

import com.shestays.she_stays_proj.vo.HouseVo;
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
    List<HouseVo> getHouseByRegion(String region);

    /**
     * 查询房源详细信息
     * 
     * @param houseId 房源id
     * @return 房源信息
     */
    HouseVo getHouseById(Integer houseId);

    /**
     * 查看待审核房源
     * 
     * @return 待审核房源信息
     */
    List<HouseVo> getUnderViewHouse(String statusCode);

    /**
     * 房源审核
     * 
     * @param houseVo
     * @return
     */
    Integer review(HouseVo houseVo);

    /**
     * 删除房源
     * 
     * @param houseId 房源id
     * @return
     */
    Integer houseDel(Integer houseId);

    /**
     * 根据用户id查询房源
     * 
     * @param userId
     * @return
     */
    List<HouseVo> getHouseByUserId(Integer userId);
}
