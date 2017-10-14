package com.homeiot.application.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeiot.application.dao.SensorDataDao;
import com.homeiot.application.model.SensorValue;

@Service
public class SensorDataServiceImpl implements SensorDataService{
	@Autowired
	SensorDataDao sensorDataDao;
	
	@Override
	public int temphumidataSave(String tempvalue, String humivalue, String date, String user_id) {
		return sensorDataDao.saveTempHumiSensorData(tempvalue, humivalue, date, user_id);
	}

	@Override
	public List<SensorValue> gettemphumidata(String sensor_id, String user_id) {
		sensorDataDao.findAll();
		
		return sensorDataDao.getSensordata(sensor_id, user_id);
	}

	@Override
	public int lightdataSave(String room1value, String room2value, String room3value, String date, String user_id) {
		sensorDataDao.findAll();
		
		return sensorDataDao.saveLightSensorData(room1value, room2value, room3value, date, user_id);
	}

	@Override
	public List<SensorValue> getlightdata(String sensor_id, String user_id) {
		sensorDataDao.findAll();
		
		return sensorDataDao.getSensordata(sensor_id, user_id);
	}
}
