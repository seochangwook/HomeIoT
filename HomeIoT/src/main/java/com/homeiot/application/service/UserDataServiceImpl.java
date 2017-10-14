package com.homeiot.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeiot.application.dao.UserDataDao;
import com.homeiot.application.dao.UserDetailDataDao;
import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.model.UserInfo;

@Service
public class UserDataServiceImpl implements UserDataService{
	@Autowired
	UserDataDao userDataDao;
	@Autowired
	UserDetailDataDao userDetailDataDao;
	
	@Override
	public List<UserInfo> getUserInfo(String user_id) {
		userDataDao.findAll();
		//데이터 추출//
		 return userDataDao.getUserInfo(user_id);
	}

	@Override
	public List<UserDetailInfo> getUserDetailInfo(String user_id) {
		userDataDao.findAll();
		
		 return userDetailDataDao.getUserDetailInfo(user_id);
	}
}
