package com.itheima.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itheima.springboot.po.User;

@Mapper
public interface UserMapper {
	//查询所有用户
	@Select("select * from tb_user")
	List<User> getAllUsers();
	
	@Delete("delete from tb_user where id = #{id}")
	//删除用户
	void delete(Integer id);

}
