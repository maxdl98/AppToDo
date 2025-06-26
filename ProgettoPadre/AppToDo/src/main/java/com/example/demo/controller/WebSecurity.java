package com.example.demo.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurity {



    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtC = new JwtAuthenticationConverter();
        jwtC.setJwtGrantedAuthoritiesConverter(new KeycloackRoleConverter());

        http
                .cors(customizer -> {}) //
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, "/api/utenti/uti").hasRole("User")
                        .requestMatchers(HttpMethod.POST, "/api/v1/login").hasRole("Admin")
                        .requestMatchers(HttpMethod.GET, "/api/utenti/Messaggio").hasRole("User")
                        .requestMatchers(HttpMethod.POST, "/api/tickets/submit").hasRole("User")
                        .requestMatchers(HttpMethod.POST, "/api/utenti/login/ut").hasRole("User")
                        .requestMatchers(HttpMethod.POST, "/api/formatore/invioMail").hasRole("Admin")
                        .requestMatchers(HttpMethod.GET, "/api/formatore/getFormatori").hasRole("User")

                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtC)
                        )
                );

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

}
