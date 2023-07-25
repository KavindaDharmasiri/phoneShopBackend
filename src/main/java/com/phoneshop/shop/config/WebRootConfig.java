package com.phoneshop.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(com.phoneshop.shop.config.JPAConfig.class)
public class WebRootConfig {

}


