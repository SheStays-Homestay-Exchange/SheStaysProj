package com.shestays.she_stays_proj.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shestays.she_stays_proj.common.Constants;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.HouseVo;
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

    /**
     * 搜索房源信息
     * 
     * @param region
     * @return
     */
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
            log.error("errorMsg-getHouseByRegion:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 根据房源id查询房源信息
     * 
     * @param houseId
     * @return
     */
    @GetMapping("getHouseById")
    public ResponsePojo getHouseById(Integer houseId) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-getHouseById:" + houseId);
            HouseVo rest = server.getHouseById(houseId);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getHouseById:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getHouseById:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 查看待审核房源接口
     * 
     * @return
     */
    @GetMapping("getUnderViewHouse")
    public ResponsePojo getUnderViewHouse() {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            List<HouseVo> rest = server.getUnderViewHouse(Constants.STATUS_UPLOADING);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getUnderViewHouse:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getUnderViewHouse:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 房源审核
     * 
     * @param houseVo 房源信息
     * @return
     */
    @PostMapping("review")
    public ResponsePojo review(HouseVo houseVo) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-review:" + JSONObject.toJSONString(houseVo));
            Integer rest = server.review(houseVo);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            log.info("getRest-getUnderViewHouse:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-review:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 删除房源
     * 
     * @param houseId 房源id
     * @return
     */
    @DeleteMapping("houseDel")
    public ResponsePojo houseDel(Integer houseId) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            if (houseId == null) {
                restPojo.setMsg(ResponseMsg.MSG_DEL_ERROR);
                restPojo.setCode(ResponseCode.GET_PARAM_ERROR.value);
                log.error("houseId  is null");
                return restPojo;
            }
            server.houseDel(houseId);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            log.info("getRest-houseDel:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-houseDel:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 根据用户查询房源信息
     */
    @GetMapping("getHouseByUserId")
    public ResponsePojo getHouseByUserId(Integer userId) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            log.info("param-getHouseByUserId:" + userId);
            List<HouseVo> rest = server.getHouseByUserId(userId);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(rest);
            log.info("getRest-getHouseByUserId:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getHouseByUserId:" + e.getMessage());
        }
        return restPojo;
    }
}
