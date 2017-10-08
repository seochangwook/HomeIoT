package com.homeiot.application.service;

import java.util.List;

import com.homeiot.application.model.UserInfo;

public interface UserDataService {
	public List<UserInfo> getUserInfo(String user_id);
	public List<UserInfo> getUserDetailInfo(String user_id);
}
