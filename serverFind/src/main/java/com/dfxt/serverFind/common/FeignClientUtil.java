package com.dfxt.serverFind.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignClientUtil {
	
	@Bean
	public Contract feignContract() {
		return new Contract.Default(); //返回原始的解析方式
	}  
}
