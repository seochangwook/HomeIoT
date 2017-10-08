package com.homeiot.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.service.UserDataService;

@RestController
public class ServiceAjaxController {
	@Autowired
	UserDataService userDataService;
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getUserInfo(@RequestBody Map<String, Object> info) {	
		System.out.println("get user id: " + info.get("user_id"));
		
		userDataService.getUserInfo(info.get("user_id").toString());
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		retVal.put("result", "success!!");
		
		return retVal;
	}
	
	@RequestMapping(value = "/userdetailinfo", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getUserDetailInfo(@RequestBody Map<String, Object> info) {	
		System.out.println("get detail user id: " + info.get("user_id"));
		
		userDataService.getUserDetailInfo(info.get("user_id").toString());
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		retVal.put("result", "success!!");
		
		return retVal;
	}
}
