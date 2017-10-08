package com.homeiot.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.homeiot.application.model.SensorValue;

@RestController
public class RouterController {
	private static final Logger logger =
			LoggerFactory.getLogger(ServiceController.class);
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("route page");
		
		mv.setViewName("router");
		
		return mv;
    }
}
