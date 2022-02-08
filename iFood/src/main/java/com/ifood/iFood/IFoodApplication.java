package com.ifood.iFood;

import com.ifood.iFood.adapter.TemperaturaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class IFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IFoodApplication.class, args);

	}

//	@Autowired
//	private TemperaturaClient temperaturaClient;

//	@Override
//	public void run(String... args) throws Exception{
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Digite o nome da cidade: ");
//		String cidade = scanner.next();
//
//		this.temperaturaClient.getTemperatura(cidade);
//	}

}
