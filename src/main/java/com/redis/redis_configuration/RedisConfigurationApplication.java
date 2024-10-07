package com.redis.redis_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisConfigurationApplication.class, args);
	}

}
