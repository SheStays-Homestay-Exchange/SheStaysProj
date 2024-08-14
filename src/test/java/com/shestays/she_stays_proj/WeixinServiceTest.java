package com.shestays.she_stays_proj;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shestays.she_stays_proj.service.WeixinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class WeixinServiceTest {
    @Autowired
    private WeixinService weixinService;

    Logger log = LoggerFactory.getLogger(WeixinServiceTest.class);

    @Test
    void getToken() {

        String code = "0a1lB8100b04DS115t100pF2TC3lB817";
        String encryptedData = "fDqhTalD7MAQ6yvzcZvx6WAlxi4pI0uhVXOs27i5vks7LDrluSZSehr8mWQxqFqwBErBGbozobdP1WS7cfd9+xdBSe3Apj5ce9HMACWPCMbP4dR1a8DO1SRbQnsRmGhgkU00jxX2P5lKrZIIzuGWKWoCNHf5hg1sagsN81lXOF2IPUo/4gMGSxrGBiQu5eTpVVXIZwxzv4yLHAevpf2qUw==";
        String vi = "qF+23USXw8TINe3z0Ke2TQ==";

        log.info(code);


    }

}
