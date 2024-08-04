package com.shestays.she_stays_proj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.mapper.HouseMapper;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.PageVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HouseServiceImpl implements HouseService {
    private final static Integer pageSize = 50;

    @Autowired
    private HouseMapper dao;

    @Override
    public PageVo getHouse(Integer pageIndex) {
        PageVo vo = new PageVo();
        vo.setPageIndex(pageIndex);
        pageIndex = (pageIndex - 1) * pageSize;
        // 查询房源信息
        List<House> houses = dao.getHouse(pageIndex);
        vo.setData(houses);
        // 查询总页数
        Integer count = dao.getCount();
        int totalPageNum = (count + pageSize - 1) / pageSize;
        vo.setPageCount(totalPageNum);
        return vo;
    }

    @Override
    public List<House> getHouseByRegion(String region) {
        log.info("param:" + region);
        return dao.getHouseByRegion(region);
    }
}
