package com.homeiot.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.homeiot.application.data.SensorValueCompositeKey;

@Entity
@Table(name="sensorvalue") //Table name//
public class SensorValue {
	@EmbeddedId
	private SensorValueCompositeKey id;
	
	@Column(name="sensor_name")
	private String sensor_name;
	
	@Column(name="sensor_value_1")
	private String sensor_value_1;
	
	@Column(name="sensor_value_2")
	private String sensor_value_2;
	
	@Column(name="sensor_reg_date")
	private Date sensor_reg_date;
	
	@Column(name="sensor_modify_date")
	private String sensor_modify_date;

	public SensorValueCompositeKey getId() {
		return id;
	}

	public void setId(SensorValueCompositeKey id) {
		this.id = id;
	}

	public String getSensor_name() {
		return sensor_name;
	}

	public void setSensor_name(String sensor_name) {
		this.sensor_name = sensor_name;
	}

	public String getSensor_value_1() {
		return sensor_value_1;
	}

	public void setSensor_value_1(String sensor_value_1) {
		this.sensor_value_1 = sensor_value_1;
	}

	public String getSensor_value_2() {
		return sensor_value_2;
	}

	public void setSensor_value_2(String sensor_value_2) {
		this.sensor_value_2 = sensor_value_2;
	}

	public Date getSensor_reg_date() {
		return sensor_reg_date;
	}

	public void setSensor_reg_date(Date sensor_reg_date) {
		this.sensor_reg_date = sensor_reg_date;
	}

	public String getSensor_modify_date() {
		return sensor_modify_date;
	}

	public void setSensor_modify_date(String sensor_modify_date) {
		this.sensor_modify_date = sensor_modify_date;
	}
	
}
