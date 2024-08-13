package com.shestays.she_stays_proj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WeixinController {

    @GetMapping("/sessionId/{code}")
    public String getSessionId(@PathVariable("code") String code) {

        return "";
    }
}
