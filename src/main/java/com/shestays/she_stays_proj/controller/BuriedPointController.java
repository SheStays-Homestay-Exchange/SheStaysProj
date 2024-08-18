package com.shestays.she_stays_proj.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.BuriedPoint;
import com.shestays.she_stays_proj.service.BuriedPointService;
import com.shestays.she_stays_proj.vo.BuriedPointVo;

@RestController
public class BuriedPointController {
    Logger log = LoggerFactory.getLogger(BuriedPointController.class);
    @Autowired
    private BuriedPointService server;

    @PostMapping("saveBuriedPoint")
    public ResponsePojo saveBuriedPoint(@RequestBody BuriedPointVo bpVo) {
        ResponsePojo responsePojo = new ResponsePojo();
        String msg = "";
        Boolean checkFlag = true;
        if (null == bpVo.getBuriedId()) {
            msg = ResponseMsg.MSG_BURIED_ID_IS_NULL;
            checkFlag = false;
        } else if (null == bpVo.getKey()) {
            msg = ResponseMsg.MSG_BURIED_KEY_IS_NULL;
            checkFlag = false;
        }
        if (!checkFlag) {
            responsePojo.setCode(ResponseCode.GET_PARAM_ERROR.value);
            responsePojo.setMsg(msg);
            return responsePojo;
        }
        try {
            BuriedPoint buriedPoint = new BuriedPoint();
            buriedPoint.setBuriedId(bpVo.getBuriedId());// 埋点id
            buriedPoint.setKey(bpVo.getKey()); // 埋点key
            buriedPoint.setSpendTime(new Date()); // 埋点时间
            buriedPoint.setLocation(bpVo.getLocation()); // 地理位置
            buriedPoint.setEquipment(bpVo.getEquipment()); // 所用设备
            buriedPoint.setOperationType(bpVo.getOperationType()); // 操作类型
            buriedPoint.setHouseId(bpVo.getHouseId()); // 房源id
            buriedPoint.setSearchKeywords(bpVo.getSearchKeywords()); // 搜索关键字
            buriedPoint.setDuration(bpVo.getDuration()); // 时长
            buriedPoint.setRemark(bpVo.getRemark()); // 备注

            server.saveBuriedPoint(buriedPoint);
            responsePojo.setMsg(ResponseMsg.MSG_SUCCESS);
            responsePojo.setCode(ResponseCode.SUCCESS.value);
        } catch (Exception e) {
            responsePojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            responsePojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-uploadHouse:" + e.getMessage());
        }

        return responsePojo;
    }
}
