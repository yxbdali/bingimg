package com.yxbdali.study.bingimg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BingImgApplication {
	/**
	 * @author xiangbin.yang
	 * @since 2016年11月11日
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BingImgApplication.class, args);
	}
}
