package com.homeiot.application.service;

public interface AuthService {
	public int dupCheckService(String in_userid, String type);
	public int enrollService(
			String type,
			String in_userid,
			String in_userpassword,
			String in_username,
			String in_useraddress,
			String in_userphonenumber,
			String in_usermailpush,
			String in_userrole);
}
