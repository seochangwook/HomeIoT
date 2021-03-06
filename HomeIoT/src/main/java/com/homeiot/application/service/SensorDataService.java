package com.homeiot.application.service;

import java.util.List;
import java.util.Map;

import com.homeiot.application.model.SensorValue;


public interface SensorDataService {
	public int temphumidataSave(String tempvalue, String humivalue, String date, String user_id);
	public int lightdataSave(String room1value, String room2value, String room3value, String date, String user_id, String room1onoffflag, String room2onoffflag, String room3onoffflag);
	public List<SensorValue> gettemphumidata(String sensor_id, String user_id);
	public List<SensorValue> getlightdata(String sensor_id, String user_id);
	public int lightOnOffUpgrade(String user_id, String sensor_id, String roomnumber, String roomonoffflag);
	public int motiondataSave(String motionvalue, String sensor_id, String user_id, String date);
}
