package com.homeiot.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.homeiot.application.model.SensorValue;
import com.homeiot.application.service.SensorDataService;

@RestController
public class ServiceController {
	private static final Logger logger =
			LoggerFactory.getLogger(ServiceController.class);
	@Value("${temphumisensor_id}")
	private String temphumisensor_id;
	
	@Value("${lightsensor_id}")
	private String lightsensor_id;
	
	@Value("${server.address}")
	private String serverIP;
	
	@Value("${server.port}")
	private String serverPORT;
	
	@Autowired
	SensorDataService sensorDataService;
	
	@RequestMapping(value = "/temphumi", method = RequestMethod.GET)
    public ModelAndView temphumiService(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("normal temphumi page");
		
		mv.setViewName("/service/temphumipage");
		
		//온도와 습도값을 가져온다.//
		//세션 등록//
		//사용자 정보 출력(세션)//
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<SensorValue> data = sensorDataService.gettemphumidata(temphumisensor_id, user.getUsername());
		
		System.out.println("sensor id: " + data.get(0).getId().getSensor_id());
		
		mv.addObject("tempvalue", data.get(0).getSensor_value_1());
		mv.addObject("humivalue", data.get(0).getSensor_value_2());
		
		return mv;
    }
	
	@RequestMapping(value = "/light", method = RequestMethod.GET)
    public ModelAndView lightService(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("normal light page");
		
		mv.setViewName("/service/lightpage");
		
		//온도와 습도값을 가져온다.//
		//사용자 정보 출력(세션)//
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		List<SensorValue> data = sensorDataService.getlightdata(lightsensor_id, user.getUsername());

		System.out.println("sensor id: " + data.get(0).getId().getSensor_id());
		
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
		mv.addObject("user_id", user.getUsername().toString());
		mv.addObject("lightsensor_id", lightsensor_id);
		
		mv.addObject("room1value", data.get(0).getSensor_value_1());
		mv.addObject("room2value", data.get(0).getSensor_value_2());
		mv.addObject("room3value", data.get(0).getSensor_value_3());
		
		mv.addObject("room1valueonoff", data.get(0).getSensor_value_1_on_off_flag());
		mv.addObject("room2valueonoff", data.get(0).getSensor_value_2_on_off_flag());
		mv.addObject("room3valueonoff", data.get(0).getSensor_value_3_on_off_flag());
		
		return mv;
    }
	
	@RequestMapping(value = "/tip", method = RequestMethod.GET)
    public ModelAndView tipService(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("normal tip page");
		
		mv.setViewName("/service/tippage");
		
		return mv;
    }
}
