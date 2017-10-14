package com.homeiot.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@Value("${server.address}")
	private String serverIP;
	
	@Value("${server.port}")
	private String serverPORT;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("route page");
		
		mv.setViewName("/home/homepage");
		
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
		mv.addObject("user_id", "scw3315");
		
		return mv;
    }
}
