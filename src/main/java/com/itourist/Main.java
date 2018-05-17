package com.itourist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.itourist")
@EntityScan(basePackages = "com.itourist")
@EnableJpaRepositories(basePackages="com.itourist")
class BootApp extends WebMvcConfigurerAdapter {
    @Value("${me.sipo.images_path}")
    private String uploadDir;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootApp.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/gallery/**").
                addResourceLocations("file:" + uploadDir);
    }


}