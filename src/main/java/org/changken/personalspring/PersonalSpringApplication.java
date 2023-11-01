package org.changken.personalspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.changken.personalspring.mapper"})
public class PersonalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalSpringApplication.class, args);
	}

}
