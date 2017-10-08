package com.homeiot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homeiot.application.model.SensorValue;

@Repository
public interface SensorDataDao extends JpaRepository<SensorValue, String>{
	List<SensorValue> findAll();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_1 = :tempvalue, sensor_value_2 = :humivalue, sensor_modify_date = :modifydate "
			+ "WHERE sensor_id = '10001' AND user_id like %:user_id%"
	)
	int saveTempHumiSensorData(
			@Param("tempvalue") String tempvalue, 
			@Param("humivalue") String humivalue, 
			@Param("modifydate") String modifydate,
			@Param("user_id") String user_id);
	
	@Query(nativeQuery = true, value=
			"SELECT sensor_id, user_id "
			+ "FROM sensorvalue "
			+ "WHERE sensor_id = :sensor_id AND user_id = :user_id"
	)
	List<SensorValue> getSensordata(
			@Param("sensor_id") String sensor_id, 
			@Param("user_id") String user_id);
	
}
