package com.shestays.she_stays_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.vo.HouseVo;

@Repository
public interface HouseMapper {
    /**
     * 房源列表信息
     * 
     * @param pageIndex 当前页
     * @return 房源信息
     */
    List<HouseVo> getHouse(Integer pageIndex);

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
    List<HouseVo> getHouseByRegion(String region);

    /**
     * 根据房屋id查询房源详情
     * 
     * @param houseId 房源id
     * @return 房屋信息
     */
    HouseVo getHouseById(Integer houseId);

    /**
     * 查看待审核房源
     * 
     * @return 待审核房源信息
     */
    List<HouseVo> getUnderViewHouse(String statusCode);

    /**
     * 房源审核通过
     * 
     * @param houseId    房源id
     * @param statusCode 审核状态code
     * @return
     */
    Integer housePassed(Integer houseId, String statusCode);

    /**
     * 房源审核不通过
     * 
     * @param houseId      房源id
     * @param statusCode   审核状态code
     * @param unpassReason 审核不通过原因
     * @return
     */
    Integer houseNoPassed(Integer houseId, String statusCode, String unpassReason);

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

    /**
     * 新增房源信息
     * 
     * @param house 房源信息
     * @return 房源id
     */
    Integer addHouse(House house);

    /**
     * 获取房源id
     * 
     * @param userId
     * @return
     */
    Integer getHouseId(Integer userId);
}
