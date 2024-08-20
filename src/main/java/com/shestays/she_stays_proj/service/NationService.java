package com.shestays.she_stays_proj.service;

import java.util.List;

import com.shestays.she_stays_proj.vo.CityVo;
import com.shestays.she_stays_proj.vo.NationVo;
import com.shestays.she_stays_proj.vo.RegionVo;

public interface NationService {
    /**
     * 获取所有国家
     * 
     * @return 国家实体
     */
    List<NationVo> getNation();

    /**
     * 获取指定区域
     * 
     * @param nationId 国家主键
     * @return 区域集合
     */
    List<RegionVo> getRegion(String countryCode);

    /**
     * 查询城市
     * 
     * @param regionId 区域id
     * @return 城市集合
     */
    List<CityVo> getCity(String regionCode);
}
