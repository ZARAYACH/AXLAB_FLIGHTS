package com.axlab.flights.security;

import com.auth0.jwk.GuavaCachedJwkProvider;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwkProviderConfiguration {

    @Value("${auth.server.url}")
    private String authServerUrl;

    @Bean
    public JwkProvider jwkProvider() {
        return new GuavaCachedJwkProvider(new UrlJwkProvider(authServerUrl));
    }
}
