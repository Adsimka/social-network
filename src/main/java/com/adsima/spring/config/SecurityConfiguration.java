package com.adsima.spring.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
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
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID"))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @SneakyThrows
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http,
                                                UserDetailsService userDetailsService,
                                                PasswordEncoder passwordEncoder) {
        var managerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);

        managerBuilder.userDetailsService(userDetailsService).
                passwordEncoder(passwordEncoder);

        return managerBuilder.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
