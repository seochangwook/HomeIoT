package com.homeiot.application.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.service.SensorDataService;
import com.homeiot.application.util.CommonUtil;

@RestController
public class SensorAjaxController {
	private static final Logger logger =
			LoggerFactory.getLogger(SensorAjaxController.class);
	
	@Autowired
	SensorDataService sensorDataService;
	@Autowired
	CommonUtil util;
	
	@RequestMapping(value = "/temphumidata", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> makerepo(@RequestBody Map<String, Object> info) {	
		System.out.println("temp value: " + info.get("tempvalue") + " / humi value: " + info.get("humivalue"));
		System.out.println("update user id: " + info.get("user_id"));
			
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		//현재날짜 구해오기//
		String date = util.getCurrentDate();
	    
		int result = sensorDataService.temphumidataSave(
				info.get("tempvalue").toString(), 
				info.get("humivalue").toString(), 
				date,
				info.get("user_id").toString());
		
		if(result == 1){
			retVal.put("result", "success!!");
		} else{
			retVal.put("result", "fail!!");
		}
		
		return retVal;
	}
}
