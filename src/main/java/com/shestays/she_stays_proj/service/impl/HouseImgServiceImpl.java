package com.shestays.she_stays_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.entity.HouseImg;
import com.shestays.she_stays_proj.mapper.HouseImgMapper;
import com.shestays.she_stays_proj.service.HouseImgService;

@Service
public class HouseImgServiceImpl implements HouseImgService {
    @Autowired
    private HouseImgMapper dao;

    @Override
    public Integer addHouseImg(HouseImg houseImg) {
        return dao.addHouseImg(houseImg);
    }

}
