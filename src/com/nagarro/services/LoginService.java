package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.LoginDao;
import com.nagarro.dto.LoginUser;

public class LoginService {
	@Autowired
	private LoginDao logindao;

	public Boolean loginAuthentication(String username, String password) {

		LoginUser user = (LoginUser) logindao.getUserDetails(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public void signUp(String username, String password, int phone) {

		LoginUser user = new LoginUser();
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		logindao.signup(user);

	}

	public void forgetPassword(String username, String password , int phone) {
		LoginUser user = (LoginUser) logindao.getUserDetails(username);
		if (user != null && user.getPhone()==phone) {
			logindao.updatePassword(username, password);
		}
	}
}
