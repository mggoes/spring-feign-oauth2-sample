package br.com.sample.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.feign.ProtectedServiceFeignClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
public class FeignOAuth2Controller {

	private final ProtectedServiceFeignClient protectedServiceFeignClient;

	@RequestMapping(path = "/greetings")
	public String greetings() {
		return this.protectedServiceFeignClient.greetings();
	}
}
