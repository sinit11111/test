package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DemoMapper;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.DemoService;
import com.example.demo.util.Md5Util;
import com.example.demo.util.MyException;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly=true)
@Slf4j
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	private DemoMapper mapper;
	
	/**
	 * 登录
	 */
	@Override
	public Map<String,Object> login(Map<String,Object> paramMap) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			
			if(paramMap!=null) {
				paramMap.put("password", Md5Util.getMD5(paramMap.get("password").toString()));
				Map<String, Object> dataMap = mapper.login(paramMap);
				if(dataMap!=null) {
					resultMap.put("status", "SUCCESS");
					resultMap.put("msg", "登陆成功");
					resultMap.put("data", dataMap);
				}else {
					resultMap.put("status", "ERROR");
					resultMap.put("msg", "登陆失败");
				}
				
			}
			
		}catch (RuntimeException e) {
			resultMap.put("status", "ERROR");
			resultMap.put("msg", "系统错误");
			log.error("登录失败 错误日志:"+e.getLocalizedMessage());
		}
		return resultMap;
	}

	/**
	 * 注册
	 */
	@Override
	@Transactional(readOnly=false)
	public Map<String, Object> regist(Map<String,Object> paramMap) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			if(paramMap!=null) {
				String id = UUID.randomUUID().toString();
				paramMap.put("id", id);
				String md5 = Md5Util.getMD5(paramMap.get("password").toString());
				paramMap.put("password", md5);
				mapper.regist(paramMap);
				resultMap.put("status", "SUCCESS");
				resultMap.put("data", paramMap);
				resultMap.put("msg", "注册成功");				
			}
			return resultMap;
		}catch (RuntimeException e) {
			resultMap.put("status", "ERROR");
			resultMap.put("msg", "系统错误");
			log.error("注册失败 错误日志"+e.getLocalizedMessage());
			return resultMap;
		}
	}

	/**
	 * 查询列表
	 */
	@Override
	public List<Map<String, Object>> findList() {
		
		return mapper.findList();
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(UserInfo userInfo) {
		try {
			if(userInfo!=null) {
				mapper.delete(userInfo);
			}
		}catch (RuntimeException e) {
			log.error("删除失败  错误日志"+e.getLocalizedMessage());
		}
		
	}

	@Override
	public Map<String, Object> selectOne(UserInfo userInfo) {
		return mapper.selectOne(userInfo);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(UserInfo userInfo) {
		try {
			if(userInfo!=null) {
				String md5 = Md5Util.getMD5(userInfo.getPassword());
				userInfo.setPassword(md5);
				mapper.update(userInfo);
			}
		}catch (RuntimeException e) {
			log.error("修改用户信息错误  错误日志:"+e.getLocalizedMessage());
		}
	}

}
