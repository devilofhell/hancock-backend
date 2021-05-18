package me.synology.jstieler.hancockapp;

import me.synology.jstieler.hancockapp.configuration.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class HancockAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HancockAppApplication.class, args);
	}

}
