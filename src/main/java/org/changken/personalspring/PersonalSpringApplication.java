package org.changken.personalspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@MapperScan(basePackages = {"org.changken.personalspring.mapper"})
@EnableJpaRepositories
public class PersonalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalSpringApplication.class, args);
	}

}
