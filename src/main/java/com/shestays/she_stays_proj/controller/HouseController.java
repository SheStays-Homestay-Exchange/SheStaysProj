package com.shestays.she_stays_proj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.PageVo;

@RestController
public class HouseController {
    Logger log = LoggerFactory.getLogger(HouseController.class);
    @Autowired
    private HouseService server;

    /**
     * 房源列表
     * 
     * @return
     */
    @GetMapping("getHouseList")
    public ResponsePojo getHouseList(Integer pageIndex) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-getHouseList:" + pageIndex);
            PageVo rest = server.getHouse(pageIndex);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getHouseList:" + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getHouseList:" + e.getMessage());
        }
        return restPojo;
    }

    @GetMapping("getHouseByRegion")
    public ResponsePojo getHouseByRegion(String region) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-getHouseByRegion:" + region);
            List<House> rest = server.getHouseByRegion(region);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getHouseByRegion:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getgetHouseList:" + e.getMessage());
        }
        return restPojo;
    }
}
