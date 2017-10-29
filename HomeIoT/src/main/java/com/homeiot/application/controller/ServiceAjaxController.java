package com.homeiot.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.service.SensorDataService;
import com.homeiot.application.service.TipDataService;
import com.homeiot.application.service.UserDataService;
import com.homeiot.application.util.GridUtil;

@RestController
public class ServiceAjaxController {
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	GridUtil gridutil;
	
	@Autowired
	TipDataService tipDataService;
	
	@Autowired
	SensorDataService sensorDataService;
	
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
	
	//Data 설정(jqGrid에서 url데이터는 @RequestParam 형식으로 받는다.)//
	@RequestMapping(value = "/tiplist", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> datainit(@RequestParam Map<String, Object> paramInfo) {
		//기본적으로 jqGrid는 url 즉 ajax통신을 할 시 "key:page"값을 넘겨준다.(@RequestParam로 설정)//
		return gridutil.gridDataSet(tipDataService.getTipDataList(paramInfo), "1");
	}
	
	@RequestMapping(value = "/lightonoffupdate", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> lightOnOffUpdate(@RequestBody Map<String, Object> info) {	
		System.out.println("lightonoff user id: " + info.get("user_id"));
		System.out.println("sensor id: " + info.get("sensor_id"));
		System.out.println("room number: " + info.get("room_number"));
		System.out.println("onoffflage: " + info.get("onoffflag"));
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		int result = sensorDataService.lightOnOffUpgrade(
				info.get("user_id").toString(), 
				info.get("sensor_id").toString(), 
				info.get("room_number").toString(), 
				info.get("onoffflag").toString());
		
		if(result == 1){
			retVal.put("result", "success!!");
		} else if(result == 0){
			retVal.put("result", "fail!!");
		}
		
		return retVal;
	}
}
