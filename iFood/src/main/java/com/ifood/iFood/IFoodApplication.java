package com.ifood.iFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class IFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IFoodApplication.class, args);

	}


}
