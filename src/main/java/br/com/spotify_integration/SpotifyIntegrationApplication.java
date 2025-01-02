package br.com.spotify_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpotifyIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyIntegrationApplication.class, args);
	}

}
