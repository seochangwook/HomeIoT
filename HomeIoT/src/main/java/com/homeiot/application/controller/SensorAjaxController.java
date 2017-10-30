package com.homeiot.application.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.model.SensorValue;
import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.service.SensorDataService;
import com.homeiot.application.service.UserDataService;
import com.homeiot.application.util.CommonUtil;
import com.homeiot.application.util.MailUtil;

@RestController
public class SensorAjaxController {
	private static final Logger logger =
			LoggerFactory.getLogger(SensorAjaxController.class);
	@Value("${temphumisensor_id}")
	private String temphumisensor_id;
	
	@Value("${lightsensor_id}")
	private String lightsensor_id;
	
	@Value("${motionsensor_id}")
	private String motionsensor_id;
	
	@Autowired
	SensorDataService sensorDataService;
	
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	CommonUtil util;
	
	@Autowired
	MailUtil mailUtil;
	
	@Autowired
	ShaPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/temphumidata", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getHumiTempData(@RequestBody Map<String, Object> info) {	
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
		
		System.out.println("==> result: " + result);
		
		if(result == 1){
			retVal.put("result", "success!!");
		} else{
			retVal.put("result", "fail!!");
		}
		
		return retVal;
	}
	
	@RequestMapping(value = "/lightdata", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getLightData(@RequestBody Map<String, Object> info) {	
		System.out.println("room 1: " + info.get("ldr1value") + " / room 2: " + info.get("ldr2value") + " / room3: " + info.get("ldr3value"));
		System.out.println("update user id: " + info.get("user_id"));
			
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		//현재 상태에 따라 on/off플래그 설정//
		String light_1_onoff_value = "0";
		String light_2_onoff_value = "0";
		String light_3_onoff_value = "0";
		
		if(Integer.parseInt(info.get("ldr1value").toString()) <= 120){
			light_1_onoff_value = "1";
		}
		
		if(Integer.parseInt(info.get("ldr2value").toString()) <= 120){
			light_2_onoff_value = "1";
		}
		
		if(Integer.parseInt(info.get("ldr3value").toString()) <= 120){
			light_3_onoff_value = "1";
		}
		
		//현재날짜 구해오기//
		String date = util.getCurrentDate();
	    
		int result = sensorDataService.lightdataSave(
				info.get("ldr1value").toString(), 
				info.get("ldr2value").toString(), 
				info.get("ldr3value").toString(), 
				date,
				passwordEncoder.encodePassword(info.get("user_id").toString(),null),
				light_1_onoff_value,
				light_2_onoff_value,
				light_3_onoff_value);
		
		System.out.println("==> result: " + result);
		
		if(result == 1){
			retVal.put("result", "success!!");
		} else{
			retVal.put("result", "fail!!");
		}
		
		return retVal;
	}
	
	@RequestMapping(value = "/lightonoff", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> getLightOnOff(@RequestBody Map<String, Object> info) {	
		System.out.println("getLight user id: " + info.get("user_id"));
		
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		List<SensorValue> data = sensorDataService.getlightdata(
				lightsensor_id, 
				passwordEncoder.encodePassword(info.get("user_id").toString(),null)
		);
		
		System.out.println("light1 flag: " + data.get(0).getSensor_value_1_on_off_flag());
		System.out.println("light1 flag: " + data.get(0).getSensor_value_2_on_off_flag());
		System.out.println("light1 flag: " + data.get(0).getSensor_value_3_on_off_flag());
		
		retVal.put("result", "success!!");
		retVal.put("light1onoff", data.get(0).getSensor_value_1_on_off_flag());
		retVal.put("light2onoff", data.get(0).getSensor_value_2_on_off_flag());
		retVal.put("light3onoff", data.get(0).getSensor_value_3_on_off_flag());
		
		return retVal;
	}
	
	@RequestMapping(value = "/motiondata", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> motionData(@RequestBody Map<String, Object> info) {	
		System.out.println("getLight user id: " + info.get("user_id"));
		
		//전달값(푸시사용 유무)에 따라 메일전송//
		List<UserDetailInfo> userdetailinfo = userDataService.getUserDetailInfo(passwordEncoder.encodePassword(info.get("user_id").toString(),null));
		
		System.out.println("user email push use: " + userdetailinfo.get(0).getMailpush_use());
		
		if(userdetailinfo.get(0).getMailpush_use().equals("0")){
			System.out.println("not email push");
		} else if(userdetailinfo.get(0).getMailpush_use().equals("1") && info.get("motionvalue").toString().equals("1")){
			try{
				mailUtil.sendSimpleMessage("scw05313315@gmail.com");
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		//현재날짜 구해오기//
		String date = util.getCurrentDate();
		
		int result = sensorDataService.motiondataSave(
				info.get("motionvalue").toString(), 
				motionsensor_id, 
				passwordEncoder.encodePassword(info.get("user_id").toString(),null), 
				date
		);
		
		System.out.println("==> result: " + result);
		
		if(result == 1){
			retVal.put("result", "success!!");
		} else{
			retVal.put("result", "fail!!");
		}
		
		return retVal;
	}
}
