package com.homeiot.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeiot.application.dao.UserAuthDao;
import com.homeiot.application.model.UserAuth;

@Service("authservice")
public class LoginServiceImpl implements UserDetailsService{
	@Autowired
	UserAuthDao userAuthDao;
	@Autowired
	ShaPasswordEncoder passwordEncoder;

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		String usercheck = "true";
		System.out.println("***************<Security Check>***************");
		System.out.println("Auth Checking...");
		
		UserDetails user = null;
		
		//데이터베이스에서 데이터가 있는지 검증//
		userAuthDao.findAll();
		List<UserAuth> userinfo = userAuthDao.getUserAuthInfo(passwordEncoder.encodePassword(userid, null));
		
		//null이면 해당 유저정보가 없다는 의미//
		if(userinfo == null){
			System.out.println("**********************************************");
			
			throw new UsernameNotFoundException("No user found with userid" + userid);
		}
		
		else if(userinfo != null){
			System.out.println("==> user id: " + userinfo.get(0).getUser_id());
			System.out.println("==> user password: " + userinfo.get(0).getUser_password());
			System.out.println("==> user role: " + userinfo.get(0).getRole());
			System.out.println("user id encrypt: " + passwordEncoder.encodePassword(userinfo.get(0).getUser_id(), null));
			System.out.println("password encode: " + passwordEncoder.encodePassword(userinfo.get(0).getUser_password(), null));
			
			Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

		    roles.add(new SimpleGrantedAuthority(userinfo.get(0).getRole()));
		    
		    user = new User(
		    		userinfo.get(0).getUser_id(), 
		    		passwordEncoder.encodePassword(userinfo.get(0).getUser_password(), null), 
		    		roles
		    );

			System.out.println("Auth Checking Success...");
			
			//user를 반환하면 form에서 처리한 값하고 비교를 하게 된다.(Spring Security 인증사용)//
			System.out.println("**********************************************");
			
			return user;
		}
		
		return user;
	}
}
