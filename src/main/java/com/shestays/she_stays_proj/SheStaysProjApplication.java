package com.shestays.she_stays_proj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableCaching
@MapperScan("com.shestays.she_stays_proj.mapper*")
public class SheStaysProjApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SheStaysProjApplication.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
		log.info("SENS started at http://localhost:" + serverPort);
	}

}
