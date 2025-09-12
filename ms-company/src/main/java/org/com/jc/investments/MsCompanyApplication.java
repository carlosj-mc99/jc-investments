package org.com.jc.investments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class MsCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompanyApplication.class, args);
	}

}
