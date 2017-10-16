package com.homeiot.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {
	@Value("${server.address}")
	private String serverIP;
	
	@Value("${server.port}")
	private String serverPORT;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login/loginview");
			
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
		
		System.out.println("security login adjust");
		
		return mv;
	}
	
	//로그인 실패 관련 처리 페이지//
	@RequestMapping(value = "/loginerror.do", method = RequestMethod.GET)
		public ModelAndView loginerror(ModelAndView mv) {
		mv.setViewName("error/loginerrorview");
			
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
		
		System.out.println("login error");
			
		return mv;
	}
	
	//권한관련 에러처리 페이지//
	@RequestMapping(value = "/autherror.do", method = RequestMethod.GET)
		public ModelAndView authaccesserror(ModelAndView mv) {
		mv.setViewName("error/autherrorview");
		
		mv.addObject("serverip", serverIP);
		mv.addObject("serverport", serverPORT);
				
		System.out.println("login access auth error");
				
		return mv;
	}
}
