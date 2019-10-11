package com.web.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.shopping.mapper")
public class AppBrand {
	public static void main(String[] args) {
		SpringApplication.run(AppBrand.class, args);
	}
}
