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
		System.out.println("service call");
		
		userDataDao.findAll();
		//데이터 추출//
		List<UserInfo> userinfo = userDataDao.getUserInfo(user_id);
		
		System.out.println("user address: " + userinfo.get(0).getUser_address());
		
		return userinfo;
	}

	@Override
	public List<UserInfo> getUserDetailInfo(String user_id) {
		userDataDao.findAll();
		
		List<UserDetailInfo> userdetailinfo = userDetailDataDao.getUserDetailInfo(user_id);
		
		System.out.println("user detail service call");
		
		System.out.println("==> user address: " + userdetailinfo.get(0).getUser_address());
		System.out.println("==> sensor name: " + userdetailinfo.get(0).getSensorvalue().get(0).getSensor_name());
		
		return null;
	}
}
