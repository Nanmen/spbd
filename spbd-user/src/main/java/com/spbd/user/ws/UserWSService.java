package com.spbd.user.ws;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spbd.user.model.User;
import com.spbd.user.service.UserService;
import com.spbd.wsapi.user.IUserService;
import com.spbd.wsapi.user.response.UserResponse;
@Service
public class UserWSService implements IUserService{
	@Autowired
	private UserService userService;

	@Override
	public UserResponse getUserById(Integer id) {
		User user = userService.getUser(id);
		if(user != null){
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(user, userResponse);
			return userResponse;
		}
		return null;
	}

}
