package com.homeiot.application.service;

import java.util.List;

import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.model.UserInfo;

public interface UserDataService {
	public List<UserInfo> getUserInfo(String user_id);
	public List<UserDetailInfo> getUserDetailInfo(String user_id);
}
