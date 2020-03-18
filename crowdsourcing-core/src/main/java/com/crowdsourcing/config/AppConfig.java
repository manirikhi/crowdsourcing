package com.crowdsourcing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = {"com.crowdsourcing"})
@Import(value = { MongoConfiguration.class })
public class AppConfig {

}
