package br.com.sample.config;

import static java.lang.String.format;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OAuth2FeignClientConfig {

	private final OAuth2RestTemplate oAuth2RestTemplate;

	@Bean
	public RequestInterceptor oAuth2RequestInterceptor() {
		return template -> {
			final OAuth2AccessToken accessToken = this.oAuth2RestTemplate.getAccessToken();
			final String accessTokenValue = accessToken.getValue();
			log.info("Using access token {}.", accessTokenValue);
			template.header("Authorization", format("Bearer %s", accessTokenValue));
		};
	}

}
