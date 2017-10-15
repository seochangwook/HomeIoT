package com.homeiot.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.homeiot.application.service.LoginServiceImpl;

@EnableWebSecurity
public class MultiSecurityConfig {
	@Autowired
	ShaPasswordEncoder shapasswordencoder;
	@Autowired
	LoginServiceImpl loginservice;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//Custom Login & PasswordEncoding(SHA)//
		//Global -> 모든 곳의 Config에 적용//
        auth.userDetailsService(loginservice).passwordEncoder(shapasswordencoder);
    }

	@Configuration
	@Order(1)                                                        
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/admin/mainbasic") 
				.authorizeRequests()
				.anyRequest().hasRole("ADMIN")
				.and()
				.exceptionHandling().accessDeniedPage("/autherror.do")
				.and()
				.httpBasic();
		}
	}

	@Configuration                                                   
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
	        	.csrf()
	         	.disable()
	         	.authorizeRequests()
	         	.antMatchers("/")
	         	.hasRole("ADMIN")
	         	.and()
	         	.exceptionHandling().accessDeniedPage("/autherror.do")
	         	.and()
	         	.formLogin()
	         	.usernameParameter("j_username")
	         	.passwordParameter("j_password")
	         	.loginProcessingUrl("/j_spring_security_check")
	         	.loginPage("/login.do")
	         	.failureUrl("/loginerror.do")
	         	.defaultSuccessUrl("/main.do")
	         	.permitAll();
		}
	}

	@Bean
	public ShaPasswordEncoder shapasswordencode(){
		return new ShaPasswordEncoder();
	}
	
	@Bean
	public LoginServiceImpl loginservice(){
		return new LoginServiceImpl();
	}
}
