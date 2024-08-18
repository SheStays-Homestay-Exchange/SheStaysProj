package com.shestays.she_stays_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.entity.BuriedPoint;
import com.shestays.she_stays_proj.mapper.BuriedPointMapper;
import com.shestays.she_stays_proj.service.BuriedPointService;

@Service
public class BuriedPointServiceImpl implements BuriedPointService {
    @Autowired
    private BuriedPointMapper dao;

    @Override
    public int saveBuriedPoint(BuriedPoint buriedPoint) {

        return dao.saveBuriedPoint(buriedPoint);
    }
}
