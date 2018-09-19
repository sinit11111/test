package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.DemoService;
import com.example.demo.util.MyException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/power")
@Slf4j
public class DemoController {
	
	@Autowired
	private DemoService service;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping("/login")
	public String login(String username,String password,Model model) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("password", password);
		try {
			Map<String, Object>  resultMap = service.login(paramMap);
			 if(resultMap.get("status").toString().equals("SUCCESS")&&resultMap.get("data")!=null) {
					return "true";
				}else {
					return "false";
				}
		}catch (RuntimeException e) {
			return "false";
		}
		
	}
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(String username,String password,Model model) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("password", password);
		Map<String, Object> resultMap = service.regist(paramMap);
		if(resultMap.get("status").toString().equals("SUCCESS")) {
			return "true";
		}else {
			return "false";
		}
	}
	/**
	 * 查询全部用户
	 * @return
	 */
	@PostMapping("/list")
	public List<Map<String,Object>> list() {
		return service.findList();
	}
	/**
	 * 删除
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/delete")
	public String delete(UserInfo userInfo) {
		try {
			service.delete(userInfo);
			return "true";
		}catch (RuntimeException e) {
			log.error("删除失败  错误日志："+e.getMessage());
			return "false";
		}
	}
	/**
	 * 查询一条数据
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/selectOne")
	public Map<String,Object> selectOne(UserInfo userInfo){
		return service.selectOne(userInfo);
	}
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/update")
	public String update(UserInfo userInfo) {
		try {
			service.update(userInfo);
			return "true";
		}catch (RuntimeException e) {
			return "false";
		}
	}
}
