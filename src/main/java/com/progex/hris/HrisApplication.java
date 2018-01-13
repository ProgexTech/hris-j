package com.progex.hris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EntityScan("com.progex.hris")
public class HrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrisApplication.class, args);
	}
	
	  @Bean
	    public WebMvcConfigurerAdapter corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	            	registry.addMapping("/api/**")
	        		.allowedOrigins("http://localhost:4200")
	        		.allowedMethods("PUT", "POST", "DELETE", "GET", "PATCH")
	        		.allowedHeaders("*")
	        		.allowCredentials(false).maxAge(3600);
	            }
	        };
	    }
}
