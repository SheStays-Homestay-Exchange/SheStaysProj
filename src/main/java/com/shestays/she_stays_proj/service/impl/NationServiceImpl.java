package com.shestays.she_stays_proj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.mapper.NationMapper;
import com.shestays.she_stays_proj.service.NationService;
import com.shestays.she_stays_proj.vo.CityVo;
import com.shestays.she_stays_proj.vo.NationVo;
import com.shestays.she_stays_proj.vo.RegionVo;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationMapper dao;

    @Override
    public List<NationVo> getNation() {
        return dao.getNation();
    }

    @Override
    public List<RegionVo> getRegion(String countryCode) {
        return dao.getRegion(countryCode);
    }

    @Override
    public List<CityVo> getCity(String regionCode) {
        return dao.getCity(regionCode);
    }
}
