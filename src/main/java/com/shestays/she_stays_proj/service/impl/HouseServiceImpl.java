package com.shestays.she_stays_proj.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shestays.she_stays_proj.common.BusinessException;
import com.shestays.she_stays_proj.common.Constants;
import com.shestays.she_stays_proj.common.FileUtils;
import com.shestays.she_stays_proj.common.ResponseCode;
import com.shestays.she_stays_proj.common.ResponseMsg;
import com.shestays.she_stays_proj.entity.House;
import com.shestays.she_stays_proj.entity.HouseImg;
import com.shestays.she_stays_proj.mapper.HouseMapper;
import com.shestays.she_stays_proj.service.HouseImgService;
import com.shestays.she_stays_proj.service.HouseService;
import com.shestays.she_stays_proj.vo.HouseVo;
import com.shestays.she_stays_proj.vo.PageVo;

@Service
public class HouseServiceImpl implements HouseService {
    Logger log = LoggerFactory.getLogger(HouseServiceImpl.class);
    @Autowired
    private HouseMapper dao;

    @Autowired
    private HouseImgService houseImgService;
    // @Value("${file-path}")
    private String userFilePath = "/Users/lienna/Downloads/";
    @Value("${file-access-path}")
    private String fileAccessPath;

    @Override
    public PageVo getHouse(Integer pageIndex) {
        PageVo vo = new PageVo();
        vo.setPageIndex(pageIndex);
        pageIndex = (pageIndex - 1) * Constants.pageSize;
        // 查询房源信息
        List<HouseVo> houses = dao.getHouse(pageIndex);
        vo.setData(houses);
        // 查询总页数
        Integer count = dao.getCount();
        int totalPageNum = (count + Constants.pageSize - 1) / Constants.pageSize;
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
        // 删除图片信息
        String filePath = userFilePath + houseId + "/";
        File dest = new File(filePath);
        FileUtils.deleteDirectory(dest);
        return dao.houseDel(houseId);
    }

    @Override
    public List<HouseVo> getHouseByUserId(Integer userId) {
        return dao.getHouseByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addHouse(House house, MultipartFile[] files) throws Exception {
        Integer houseId = dao.addHouse(house);
        try {
            houseId = dao.getHouseId(house.getUserId());
            uploadImgs(houseId, files);
            return houseId;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void uploadImgs(Integer houseId, MultipartFile[] files) throws Exception {
        String filePath = userFilePath + houseId + "/";

        // 判断文件是否存在
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("image/jpeg");
        fileTypes.add("image/png");
        fileTypes.add("image/jpg");
        try {
            for (MultipartFile file : files) {
                if (file.getSize() / 10000 > 100) {
                    throw new BusinessException(ResponseCode.GET_PARAM_ERROR.value, ResponseMsg.MSG_FILE_TOO_BIG);
                } else {
                    String fileType = file.getContentType();
                    if (fileTypes.contains(fileType)) {
                        // 获取文件名
                        String fileName = file.getOriginalFilename();
                        String suffixName = fileName.substring(fileName.lastIndexOf("."));
                        // 重新生成文件名
                        fileName = UUID.randomUUID() + suffixName;
                        String filePathNew = filePath + fileName;
                        file.transferTo(new File(filePathNew));
                        // 设置访问路径
                        String accessPath = fileAccessPath + houseId + "/" + fileName;
                        // 新增房源图片信息
                        HouseImg houseImg = new HouseImg();
                        houseImg.setHouseId(houseId);
                        houseImg.setImgUrl(accessPath);
                        Integer imgId = houseImgService.addHouseImg(houseImg);
                    } else {
                        throw new BusinessException(ResponseCode.GET_PARAM_ERROR.value,
                                ResponseMsg.MSG_FILE_TYPE_ERROR);
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public List<Map<String, String>> getRecommendCountryName() {
        try {
            dao.getRecommendCountryName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao.getRecommendCountryName();
    }

}
