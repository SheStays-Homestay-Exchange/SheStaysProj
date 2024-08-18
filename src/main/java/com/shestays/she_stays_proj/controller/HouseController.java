package com.shestays.she_stays_proj.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.shestays.she_stays_proj.common.BusinessException;
import com.shestays.she_stays_proj.common.Constants;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.HouseUploadVo;
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
            List<HouseVo> rest = server.getHouseByRegion(region);
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
            List<HouseVo> rest = server.getUnderViewHouse(Constants.STATUS_UNDERVIEW);
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

    /**
     * 上传房源
     * 
     * @param house 房源信息
     * @param files
     * @return
     */
    @PostMapping("uploadHouse")
    public ResponsePojo uploadHouse(@RequestBody HouseUploadVo houseVo, MultipartFile[] files) {
        ResponsePojo restPojo = new ResponsePojo();
        log.info("param-uploadHouse-house:"
                + JSONObject.toJSONString(houseVo, SerializerFeature.WriteMapNullValue));
        String msg = "";
        Boolean checkFlag = true;
        if (null == houseVo.getUserId()) {
            // 用户id为空判断
            msg = ResponseMsg.MSG_USER_ID_NULL;
            checkFlag = false;
        } else if (null == houseVo.getHouseAmount()) {
            // 可接待客房数为空判断
            msg = ResponseMsg.MSG_HOUSE_AMOUT_NULL;
            checkFlag = false;
        } else if (null == houseVo.getStartTime()) {
            // 开始时间为空判断
            msg = ResponseMsg.MSG_START_TIME_NULL;
            checkFlag = false;
        } else if (null == houseVo.getEndTime()) {
            // 结束时间为空判断
            msg = ResponseMsg.MSG_END_TIME_NULL;
            checkFlag = false;
        } else if (null == houseVo.getCountryId()) {
            // 国家id为空判断
            msg = ResponseMsg.MSG_NATION_NULL;
            checkFlag = false;
        } else if (null == houseVo.getCityId()) {
            // 城市id为空判断
            msg = ResponseMsg.MSG_CITY_NULL;
            checkFlag = false;
        } else if (null == houseVo.getContinentId()) {
            houseVo.setContinentId(999);
        }
        if (!checkFlag) {
            restPojo.setCode(ResponseCode.GET_PARAM_ERROR.value);
            restPojo.setMsg(msg);
            return restPojo;
        }

        try {
            // 新增房源
            House house = new House();
            house.setUserId(houseVo.getUserId()); // 用户id
            house.setHouseTitle(houseVo.getHouseTitle()); // 房源title
            house.setHouseAmount(houseVo.getHouseAmount());// 可接待客房数
            house.setDescrible(houseVo.getDescrible()); // 对房客说的话
            house.setStatusCode(Constants.STATUS_UPLOADING); // 上传状态
            house.setStartTime(houseVo.getStartTime()); // 开放开始时间
            house.setEndTime(houseVo.getEndTime()); // 开放结束时间
            house.setContinentId(houseVo.getContinentId()); // 所在州
            house.setCountryId(houseVo.getCountryId()); // 所在国家
            house.setCityId(houseVo.getCityId()); // 所在城市
            house.setRegionId(houseVo.getRegionId()); // 所在区
            house.setDetailArea(houseVo.getDetailAddress()); // 详细地址
            Integer houseId = server.addHouse(house, files);
            log.info("add-houseId:" + houseId);
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
        } catch (BusinessException bse) {
            restPojo.setCode(bse.getRestCd());
            restPojo.setMsg(bse.getMsg());
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-uploadHouse:" + e.getMessage());
        }
        return restPojo;
    }

    /**
     * 推荐目的地
     * 
     * @return
     */
    @GetMapping("getRecommendCountryName")
    @ResponseJSONP
    public ResponsePojo getRecommendCountryName() {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            List<Map<String, String>> restData = server.getRecommendCountryName();
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
            restPojo.setData(restData);
            log.info("getRest-getRecommendCountryName:"
                    + JSONObject.toJSONString(restPojo, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-getRecommendCountryName:" + e.getMessage());
        }
        return restPojo;
    }

}
