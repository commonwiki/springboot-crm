package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring Boot 应用的标识
//等价于@ComponentScan+@EnableAutoConfiguration+@Configuration
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.example.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
