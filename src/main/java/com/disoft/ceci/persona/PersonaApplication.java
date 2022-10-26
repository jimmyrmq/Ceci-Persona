package com.disoft.ceci.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan(value = "com.disoft.ceci.persona")
public class PersonaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PersonaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(com.disoft.ceci.persona.PersonaApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("/**").allowedMethods("GET").allowedHeaders("*");
			}
		};
	}
}
