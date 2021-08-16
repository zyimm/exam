package com.zyimm.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyimm
 */
@SpringBootApplication(scanBasePackages = {"com.zyimm.api","com.zyimm.common", "com.zyimm.dao", "com.zyimm.service"})
@MapperScan("com.zyimm.dao.mapper")
public class ApiApplication {
    public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}