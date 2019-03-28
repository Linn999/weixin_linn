package org.fkjava.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication
public class WeixinApplication {
	
	//@Bean相当于在xml文件中写<bean>元素
	@Bean
	public XmlMapper xmlMapper() {
		XmlMapper mapper = new XmlMapper();
		return mapper;
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}

}
