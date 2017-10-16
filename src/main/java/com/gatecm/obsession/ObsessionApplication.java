package com.gatecm.obsession;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//该 @SpringBootApplication 注解等价于以默认属性使用:
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class ObsessionApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ObsessionApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
