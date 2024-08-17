package com.shestays.she_stays_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.common.ResponsePojo;
import com.shestays.she_stays_proj.service.HouseImgService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HouseImgController {
    @Autowired
    private HouseImgService houseImgService;

    /**
     * 删除房源图片信息
     * 
     * @param imgId
     * @return
     */
    @DeleteMapping("houseImgDel")
    public ResponsePojo houseImgDel(Integer imgId) {
        ResponsePojo restPojo = new ResponsePojo();
        try {
            if (null != imgId) {
                houseImgService.houseImgDel(imgId);
            }
            restPojo.setMsg(ResponseMsg.MSG_SUCCESS);
            restPojo.setCode(ResponseCode.SUCCESS.value);
        } catch (Exception e) {
            restPojo.setMsg(ResponseMsg.MSG_SYSTEM_ERROR);
            restPojo.setCode(ResponseCode.ERROR.value);
            log.error("errorMsg-houseImgDel:" + e.getMessage());
        }
        return restPojo;
    }
}
