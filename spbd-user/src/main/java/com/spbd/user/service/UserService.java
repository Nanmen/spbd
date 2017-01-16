package com.spbd.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spbd.user.mapper.UserMapper;
import com.spbd.user.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	
	public User getUser(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}
}
