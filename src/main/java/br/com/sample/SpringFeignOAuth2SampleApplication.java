package br.com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignOAuth2SampleApplication {

	public static void main(final String... args) {
		SpringApplication.run(SpringFeignOAuth2SampleApplication.class, args);
	}
}
