package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.UserInfo;


public interface DemoService {

	Map<String,Object> login(Map<String,Object> paramMap);

	Map<String, Object> regist(Map<String,Object> paramMap);

	List<Map<String, Object>> findList();

	void delete(UserInfo userInfo);

	Map<String, Object> selectOne(UserInfo userInfo);

	void update(UserInfo userInfo);

}
