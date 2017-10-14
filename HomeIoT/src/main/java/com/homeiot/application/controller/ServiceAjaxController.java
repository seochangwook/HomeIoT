package com.homeiot.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.model.UserInfo;
import com.homeiot.application.service.UserDataService;

@RestController
public class ServiceAjaxController {
	@Autowired
	UserDataService userDataService;
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getUserInfo(@RequestBody Map<String, Object> info) {	
		System.out.println("get user id: " + info.get("user_id"));
		
		List<UserInfo> userinfo = userDataService.getUserInfo(info.get("user_id").toString());
		
		System.out.println("user address: " + userinfo.get(0).getUser_address());
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		retVal.put("result", "success!!");
		
		return retVal;
	}
	
	@RequestMapping(value = "/userdetailinfo", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getUserDetailInfo(@RequestBody Map<String, Object> info) {	
		System.out.println("get detail user id: " + info.get("user_id"));
		
		List<UserDetailInfo> userdetailinfo = userDataService.getUserDetailInfo(info.get("user_id").toString());
		
		System.out.println("==> user address: " + userdetailinfo.get(0).getUser_address());
		System.out.println("==> sensor name: " + userdetailinfo.get(0).getSensorvalue().get(0).getSensor_name());
		System.out.println("==> sensor name: " + userdetailinfo.get(0).getSensorvalue().get(1).getSensor_name());
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		retVal.put("result", "success!!");
		
		return retVal;
	}
}
