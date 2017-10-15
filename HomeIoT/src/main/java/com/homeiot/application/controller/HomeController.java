package com.homeiot.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
		
		//세션 등록//
		//사용자 정보 출력(세션)//
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user name :" + user.getUsername());
		
		mv.addObject("user_id", user.getUsername());
		
		return mv;
    }
}
