package com.adsima.spring.config;

import com.adsima.web.config.WebConfiguration;
import org.springframework.context.annotation.*;

@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(value = "com.adsima")
public class ApplicationConfiguration {

}
