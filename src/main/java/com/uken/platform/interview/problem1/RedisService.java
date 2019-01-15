package com.uken.platform.interview.problem1;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService implements InitializingBean{
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	private static final int MAX_RECORDS = 100000;
	
	private void insertRecords(){
		for (int i = 0; i < MAX_RECORDS; i++) {
			redisTemplate.opsForValue().set("slow-" + i, Integer.toString(i));
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Instant start = Instant.now();
		insertRecords();
		Instant end = Instant.now();
		System.out.println("Standard method took: " + Duration.between(start, end).getSeconds() + " seconds");
	}
}
