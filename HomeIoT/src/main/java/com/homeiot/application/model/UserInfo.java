package com.homeiot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserInfo {
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="user_pswd")
	private String user_pswd;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="user_phonenumber")
	private String user_phonenumber;
	
	@Column(name="mailpush_use")
	private int mailpush_use;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pswd() {
		return user_pswd;
	}

	public void setUser_pswd(String user_pswd) {
		this.user_pswd = user_pswd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_phonenumber() {
		return user_phonenumber;
	}

	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}

	public int getMailpush_use() {
		return mailpush_use;
	}

	public void setMailpush_use(int mailpush_use) {
		this.mailpush_use = mailpush_use;
	}
}
