package com.homeiot.application.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SensorValueCompositeKey implements Serializable{
	private static final long serialVersionUID = -7418165531339916268L;
	
	@Column(name="sensor_id")
	private String sensor_id;
	
	@Column(name="user_id")
	private String user_id;
	
	public String getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sensor_id == null) ? 0 : sensor_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorValueCompositeKey other = (SensorValueCompositeKey) obj;
		if (sensor_id == null) {
			if (other.sensor_id != null)
				return false;
		} else if (!sensor_id.equals(other.sensor_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
}
