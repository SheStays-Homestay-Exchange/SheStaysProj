package com.shestays.she_stays_proj;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSONObject;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.service.UserService;
import com.shestays.she_stays_proj.vo.UserVo;

@SpringBootTest
public class UserServiceTest {
    Logger log = LoggerFactory.getLogger(UserServiceTest.class);
    @Autowired
    private UserService userService;

    @Test
    void getUserInfoByWechatIdTest() {

        String wechatId = "111";
        UserVo user = userService.getUserInfoByWechatId(wechatId);
        JSONObject obj = new JSONObject();
        obj.put("data", user);
        log.info("user:::::" + obj.toJSONString());
    }
}
