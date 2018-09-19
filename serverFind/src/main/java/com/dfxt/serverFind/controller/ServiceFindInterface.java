package com.dfxt.serverFind.controller;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.dfxt.serverFind.common.FeignClientUtil;

import feign.RequestLine;


@FeignClient(name="mytest",url="http://localhost:8083",configuration=FeignClientUtil.class)
public interface ServiceFindInterface {
	@RequestLine("GET /find")
	String find();
}
