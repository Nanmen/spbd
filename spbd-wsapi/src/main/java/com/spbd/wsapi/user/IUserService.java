package com.spbd.wsapi.user;

import com.spbd.wsapi.user.response.UserResponse;

public interface IUserService {
	
	public UserResponse getUserById(Integer id);
}
