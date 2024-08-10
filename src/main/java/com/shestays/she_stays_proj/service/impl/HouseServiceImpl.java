package com.shestays.she_stays_proj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shestays.she_stays_proj.common.Constants;
import com.shestays.she_stays_proj.mapper.HouseMapper;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.HouseVo;
import com.shestays.she_stays_proj.vo.PageVo;
import lombok.extern.slf4j.Slf4j;

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
        List<HouseVo> houses = dao.getHouse(pageIndex);
        vo.setData(houses);
        // 查询总页数
        Integer count = dao.getCount();
        int totalPageNum = (count + pageSize - 1) / pageSize;
        vo.setPageCount(totalPageNum);
        return vo;
    }

    @Override
    public List<HouseVo> getHouseByRegion(String region) {

        return dao.getHouseByRegion(region);
    }

    @Override
    public HouseVo getHouseById(Integer houseId) {
        return dao.getHouseById(houseId);
    }

    @Override
    public List<HouseVo> getUnderViewHouse(String statusCode) {
        return dao.getUnderViewHouse(statusCode);
    }

    @Override
    public Integer review(HouseVo houseVo) {
        // 房源审核通过
        if (Constants.STATUS_ONLINE.equals(houseVo.getStatusCode())) {
            return dao.housePassed(houseVo.getHouseId(), houseVo.getStatusCode());
        } else if (Constants.STATUS_NOPASS.equals(houseVo.getStatusCode())) {
            return dao.houseNoPassed(houseVo.getHouseId(), houseVo.getStatusCode(), houseVo.getUnpassReason());
        }
        return 0;
    }

    @Override
    public Integer houseDel(Integer houseId) {
        return dao.houseDel(houseId);
    }

    @Override
    public List<HouseVo> getHouseByUserId(Integer userId) {
        return dao.getHouseByUserId(userId);
    }
}
