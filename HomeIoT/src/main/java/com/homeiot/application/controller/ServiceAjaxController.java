package com.homeiot.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
	
	@RequestMapping(value = "/userdetailinfo", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getUserDetailInfo(@RequestBody Map<String, Object> info) {	
		System.out.println("get detail user id: " + info.get("user_id"));
		
		List<UserDetailInfo> userdetailinfo = userDataService.getUserDetailInfo(info.get("user_id").toString());
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		retVal.put("result", "success!!");
		retVal.put("useraddress", userdetailinfo.get(0).getUser_address());
		retVal.put("username", userdetailinfo.get(0).getUser_name());
		retVal.put("userphonenumber", userdetailinfo.get(0).getUser_phonenumber());
		retVal.put("usersensor", userdetailinfo.get(0).getSensorvalue());
		
		return retVal;
	}
}
