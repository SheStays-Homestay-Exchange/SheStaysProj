package com.shestays.she_stays_proj.mapper;

import org.springframework.stereotype.Repository;

import com.shestays.she_stays_proj.entity.BuriedPoint;

@Repository
public interface BuriedPointMapper {
    /**
     * 保存埋点信息
     * 
     * @param buriedPoint 埋点信息
     * @return
     */
    int saveBuriedPoint(BuriedPoint buriedPoint);
}
