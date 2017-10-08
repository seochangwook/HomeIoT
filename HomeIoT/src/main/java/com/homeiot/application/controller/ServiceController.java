package com.homeiot.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	SensorDataService sensorDataService;
	
	@RequestMapping(value = "/temphumi", method = RequestMethod.GET)
    public ModelAndView temphumiService(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("normal main page");
		
		mv.setViewName("/service/temphumipage");
		
		//온도와 습도값을 가져온다.//
		List<SensorValue> data = sensorDataService.gettemphumidata("10001", "scw3315");
		
		System.out.println("sensor id: " + data.get(0).getId().getSensor_id());
		
		mv.addObject("tempvalue", data.get(0).getSensor_value_1());
		mv.addObject("humivalue", data.get(0).getSensor_value_2());
		
		return mv;
    }
	
	@RequestMapping(value = "/light", method = RequestMethod.GET)
    public ModelAndView lightService(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("normal main page");
		
		mv.setViewName("/service/lightpage");
		
		return mv;
    }
}
