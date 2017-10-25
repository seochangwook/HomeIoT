package com.homeiot.application.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeiot.application.service.AuthService;

@RestController
public class AuthAjaxController {
	@Autowired
	AuthService authService;
	
	@Autowired
	ShaPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/logoutajax", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> logout(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultmap = new HashMap<String, Object>();

		boolean is_insert_success = false;

		//로그아웃//
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("--------------------------");
		System.out.println("auth name info: " + auth.getName());
		System.out.println("auth detail info: " + auth.getDetails());
		System.out.println("auth detail info: " + auth.getPrincipal());
		System.out.println("--------------------------");
		
		//로그아웃 상태인지 점검//
		//logout()시 HttpSession을 이용하기에 내부적으로 세션을 만료시킴//
		System.out.println("auth info: " + auth);
		
		if(auth != null){
			 new SecurityContextLogoutHandler().logout(request, response, auth);
			 
			 is_insert_success = true;
			 
			 System.out.println("logout success...");
		}
		
		resultmap.put("resultmsg", ""+is_insert_success);
		
		System.out.println("logout process...");
		
		return resultmap;
	}
	
	@RequestMapping(value = "/duplicatecheck", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> dupCheck(@RequestBody Map<String, Object> info) {	
		System.out.println("in user id: " + info.get("in_user_id") + " / type: " + info.get("in_type"));
			
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		int resultCode = authService.dupCheckService(passwordEncoder.encodePassword(info.get("in_user_id").toString(),null), info.get("in_type").toString());
		
		System.out.println("result code: " + resultCode);
		
		retVal.put("result", ""+resultCode);
		
		return retVal;
	}
	
	@RequestMapping(value = "/enroll", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> enroll(@RequestBody Map<String, Object> info) {	
		System.out.println("in user id: " + info.get("in_user_id") + " / type: " + info.get("in_type"));
		System.out.println("user name: " + info.get("in_username"));
		System.out.println("user password: " + info.get("in_userpassword")); //암호화 필요//
		System.out.println("user address: " + info.get("in_useraddress"));
		System.out.println("user phonenumber: " + info.get("in_userphonenumber"));
		System.out.println("user mailpush: " + info.get("in_usermailpush"));
		System.out.println("user role: " + info.get("in_role"));
			
		Map<String, Object> retVal = new HashMap<String, Object>(); 
		
		int resultCode = authService.enrollService(
				info.get("in_type").toString(),
				passwordEncoder.encodePassword(info.get("in_user_id").toString(), null),
				info.get("in_userpassword").toString(),
				info.get("in_username").toString(),
				info.get("in_useraddress").toString(),
				info.get("in_userphonenumber").toString(),
				info.get("in_usermailpush").toString(),
				info.get("in_role").toString()
				);
		
		System.out.println("result code: " + resultCode);
		
		retVal.put("result", ""+resultCode);
		
		return retVal;
	}
}
