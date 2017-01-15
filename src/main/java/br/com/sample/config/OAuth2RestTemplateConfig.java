package br.com.sample.config;

import static java.util.Arrays.asList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class OAuth2RestTemplateConfig {

	@Bean
	public OAuth2RestTemplate oAuth2RestTemplate() {
		final ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
		details.setAccessTokenUri("http://localhost:8080/oauth/token");
		details.setClientId("my-client-id");
		details.setClientSecret("secret");
		details.setGrantType("client_credentials");
		details.setScope(asList("read", "write"));
		return new OAuth2RestTemplate(details);
	}

}
