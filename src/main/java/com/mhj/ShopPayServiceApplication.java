package com.mhj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = {"com.mhj"})
@MapperScan("com.mhj.mapper")
@SpringBootApplication
@EnableAsync
public class ShopPayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopPayServiceApplication.class, args);
	}

}
