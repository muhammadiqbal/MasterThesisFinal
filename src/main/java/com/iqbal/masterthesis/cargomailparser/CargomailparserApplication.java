package com.iqbal.masterthesis.cargomailparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CargomailparserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargomailparserApplication.class, args);
	}
}
