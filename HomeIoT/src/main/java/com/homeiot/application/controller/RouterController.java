package com.homeiot.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.homeiot.application.model.SensorValue;

@RestController
public class RouterController {
	@Value("${server.address}")
	private String serverIP;
	
	@Value("${server.port}")
	private String serverPORT;
	
	private static final Logger logger =
			LoggerFactory.getLogger(ServiceController.class);
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		System.out.println("route page");
		
		mv.setViewName("router");
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
		
		//세션 등록//
		//사용자 정보 출력(세션)//
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user name :" + user.getUsername());
				
		mv.addObject("userid", user.getUsername());
		
		return mv;
    }
}
