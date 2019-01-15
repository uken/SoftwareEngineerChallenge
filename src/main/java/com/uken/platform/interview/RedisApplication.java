package com.uken.platform.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.uken.platform.interview.problem2.RedisController;

@SpringBootApplication
@ComponentScan(basePackageClasses=RedisController.class)
public class RedisApplication {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		return connectionFactory;
	}
	
	@Bean
	public StringRedisTemplate redisTempalte(){
		return new StringRedisTemplate(jedisConnectionFactory());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
		
	}
}
