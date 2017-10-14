package com.homeiot.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserDetailInfo {
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="user_phonenumber")
	private String user_phonenumber;
	
	@Column(name="user_name")
	private String user_name;

	@OneToMany 
	@JoinColumn(name="user_id") 
	private List<SensorValue> sensorvalue;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<SensorValue> getSensorvalue() {
		return sensorvalue;
	}

	public void setSensorvalue(List<SensorValue> sensorvalue) {
		this.sensorvalue = sensorvalue;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
