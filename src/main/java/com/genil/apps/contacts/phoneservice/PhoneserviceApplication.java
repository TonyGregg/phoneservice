package com.genil.apps.contacts.phoneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhoneserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneserviceApplication.class, args);
	}

}
