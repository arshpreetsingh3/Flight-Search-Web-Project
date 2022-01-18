package com.nagarro.dao;

import com.nagarro.dto.LoginUser;


public interface LoginDao {
	LoginUser getUserDetails(String username);

	void updatePassword(String username, String password);

	void signup(LoginUser user);
}
