package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.UserInfo;

@Mapper
public interface DemoMapper {
	
	@Select("select username,password from userinfo where username=#{username} and password=#{password} a")
	Map<String,Object> login(Map<String,Object> paramMap);
	
	@Insert("insert into userinfo(id,username,password) values (#{id},#{username},#{password})")
	void regist(Map<String,Object> paramMap);
	
	@Select("select * from userinfo")
	List<Map<String, Object>> findList();
	
	@Delete("delete from userinfo where id=#{id}")
	void delete(UserInfo userInfo);
	
	@Select("select * from userinfo where id=#{id}")
	Map<String, Object> selectOne(UserInfo userInfo);
	
	@Update("update userinfo set username=#{username},password=#{password} where id=#{id}")
	void update(UserInfo userInfo);

}
