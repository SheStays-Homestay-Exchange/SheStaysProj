package com.shestays.she_stays_proj.service;

import com.shestays.she_stays_proj.entity.BuriedPoint;

public interface BuriedPointService {
    /**
     * 保存埋点信息
     * 
     * @param buriedPoint 埋点信息
     * @return
     */
    int saveBuriedPoint(BuriedPoint buriedPoint);
}
