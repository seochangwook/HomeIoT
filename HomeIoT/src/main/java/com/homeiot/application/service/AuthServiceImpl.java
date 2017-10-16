package com.homeiot.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeiot.application.dao.AuthDao;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	AuthDao authDao;
	
	@Override
	public int dupCheckService(String in_userid, String type) {
		return Integer.parseInt(authDao.dupenroll(
				Integer.parseInt(type), 
				in_userid,
				"",
				"",
				"",
				"",
				0,
				""));
	}

	@Override
	public int enrollService(String type, String in_userid, String in_userpassword, String in_username,
			String in_useraddress, String in_userphonenumber, String in_usermailpush, String in_userrole) {
		return Integer.parseInt(authDao.dupenroll(
				Integer.parseInt(type), 
				in_userid,
				in_userpassword,
				in_username,
				in_useraddress,
				in_userphonenumber,
				Integer.parseInt(in_usermailpush),
				in_userrole));
	}
}
