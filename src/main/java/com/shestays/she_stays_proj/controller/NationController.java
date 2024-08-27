package com.shestays.she_stays_proj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.District;
import com.shestays.she_stays_proj.service.NationService;
import com.shestays.she_stays_proj.vo.CityVo;
import com.shestays.she_stays_proj.vo.NationVo;
import com.shestays.she_stays_proj.vo.RegionVo;

@RestController
public class NationController {
    Logger log = LoggerFactory.getLogger(NationController.class);

    @Autowired
    private NationService service;

    /**
     * 国家查询
     * 
     * @return 国家集合
     */
    @GetMapping("getNation")
    @ResponseJSONP
    public ResponsePojo getNation() {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            List<NationVo> rest = service.getNation();
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getNation:" + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
            return restPojo;
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getNation:" + e.getMessage());
            return restPojo;
        }
    }

    /**
     * 区域查询
     * 
     * @param nationId 国家id
     * @return 区域集合
     */
    @GetMapping("getRegion")
    @ResponseJSONP
    public ResponsePojo getRegion(String countryCode) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.debug("param-getRegion:" + countryCode);
            List<RegionVo> rest = service.getRegion(countryCode);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getRegion:" + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
            return restPojo;
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getRegion:" + e.getMessage());

            return restPojo;
        }
    }

    @GetMapping("getCity")
    @ResponseJSONP
    public ResponsePojo getCity(String regionCode) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-getCity:" + regionCode);
            List<CityVo> rest = service.getCity(regionCode);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getCity:" + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
            return restPojo;
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getCity:" + e.getMessage());
            return restPojo;
        }
    }

    @GetMapping("getDistrict")
    @ResponseJSONP
    public ResponsePojo getDistrict(String cityCode) {
        ResponsePojo restPojo = new ResponsePojo();

        try {
            log.info("param-getDistrict:" + cityCode);
            List<District> rest = service.getDistrict(cityCode);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getCity:" + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
            return restPojo;
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getCity:" + e.getMessage());
            return restPojo;
        }
    }

}
