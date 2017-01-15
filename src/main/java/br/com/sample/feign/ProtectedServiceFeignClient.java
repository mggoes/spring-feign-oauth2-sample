package br.com.sample.feign;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sample.config.OAuth2FeignClientConfig;

@FeignClient(name = "ProtectedServiceFeignClient", url = "http://localhost:8081", configuration = OAuth2FeignClientConfig.class)
public interface ProtectedServiceFeignClient {

	@RequestMapping(path = "/greetings", method = GET, produces = APPLICATION_JSON_VALUE)
	String greetings();

}
