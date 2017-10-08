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
}
