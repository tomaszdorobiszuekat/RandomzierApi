package com.tomekdorobisz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.tomekdorobisz.model.domain")
public class TomekdorobiszApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomekdorobiszApplication.class, args);
	}

}
