package com.shestays.she_stays_proj.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.vo.HouseUploadVo;
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

    /**
     * 新增房源
     * 
     * @param house 房源信息
     * @return 房源id
     */
    Integer addHouse(House house, List<String> houseImgs) throws Exception;

    /**
     * 搜索目的地
     * 
     * @return
     */
    List<Map<String, String>> getRecommendCountryName();

    /**
     * 下架房源
     * 
     * @param house
     * @return
     */
    Integer houseOffline(House house);

    /**
     * 上传图片
     * 
     * @param userId
     * @param files
     */
    List<String> uploadImgs(Integer userId, MultipartFile[] files) throws Exception;

}
