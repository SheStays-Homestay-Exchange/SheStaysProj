package com.shestays.she_stays_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shestays.she_stays_proj.entity.District;
import com.shestays.she_stays_proj.entity.Nation;
import com.shestays.she_stays_proj.vo.CityVo;
import com.shestays.she_stays_proj.vo.NationVo;
import com.shestays.she_stays_proj.vo.RegionVo;

@Repository
public interface NationMapper extends BaseMapper<Nation> {
    /**
     * 获取所有国家
     * 
     * @return 国家实体
     */
    List<NationVo> getNation();

    /**
     * 查询区域
     * 
     * @param nationId 国家id
     * @return 区域实体
     */
    List<RegionVo> getRegion(String countryCode);

    /**
     * 查询城市
     * 
     * @param regionId 区域id
     * @return 城市实体
     */
    List<CityVo> getCity(String regionCode);

    /**
     * 查询区
     * 
     * @param cityCode 城市id
     * @return 区实体
     */
    List<District> getDistrict(String cityCode);
}
