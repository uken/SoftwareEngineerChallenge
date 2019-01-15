package com.uken.platform.interview.problem2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping(value = "/pair/{key}/{value}", method = RequestMethod.GET)
    public void setInRedis(@PathVariable String key, @PathVariable String value) {
		redisTemplate.opsForValue().set(key, value);
	}
}