package org.fkjava.weixin;

import org.fkjava.weixin.domain.InMessage;
import org.fkjava.weixin.service.JsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication
public class WeixinApplication {
	
	//@Bean相当于在xml文件中写<bean>元素
	@Bean
	public XmlMapper xmlMapper() {
		XmlMapper mapper = new XmlMapper();
		return mapper;
		
	}
	
	@Bean
	public RedisTemplate<String, ? extends InMessage> inMessageTemplate(
			@Autowired RedisConnectionFactory connectionFactory){
		RedisTemplate<String, ? extends InMessage> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setValueSerializer(new JsonRedisSerializer());
		return template;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}

}
