package com.adsima.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests ->
                    requests.anyRequest()
                            .authenticated()
                )
                .formLogin(form -> form.loginPage("/login")
                        .successForwardUrl("/users")
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
