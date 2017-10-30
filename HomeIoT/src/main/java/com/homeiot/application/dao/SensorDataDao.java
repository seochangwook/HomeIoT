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
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_1 = :room1value, sensor_value_2 = :room2value, sensor_value_3 = :room3value, sensor_modify_date = :modifydate, "
			+ "sensor_value_1_on_off_flag = :sensor_value_1_on_off_flag, sensor_value_2_on_off_flag = :sensor_value_2_on_off_flag, sensor_value_3_on_off_flag =:sensor_value_3_on_off_flag "
			+ "WHERE sensor_id = '10002' AND user_id like %:user_id%"
	)
	int saveLightSensorData(
			@Param("room1value") String room1value, 
			@Param("room2value") String room2value, 
			@Param("room3value") String room3value,
			@Param("modifydate") String modifydate,
			@Param("user_id") String user_id,
			@Param("sensor_value_1_on_off_flag") String room1onoffflag,
			@Param("sensor_value_2_on_off_flag") String room2onoffflag,
			@Param("sensor_value_3_on_off_flag") String room3onoffflag);
	
	@Query(nativeQuery = true, value=
			"SELECT sensor_id, user_id "
			+ "FROM sensorvalue "
			+ "WHERE sensor_id = :sensor_id AND user_id = :user_id"
	)
	List<SensorValue> getSensordata(
			@Param("sensor_id") String sensor_id, 
			@Param("user_id") String user_id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_1_on_off_flag = :sensor_value_1_on_off_flag "
			+ "WHERE sensor_id = :sensor_id AND user_id like %:user_id%"
	)
	int updateRoom1OnOffStatus(
			@Param("sensor_value_1_on_off_flag") String sensor_value_1_on_off_flag,
			@Param("sensor_id") String sensor_id,
			@Param("user_id") String user_id
	);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_2_on_off_flag = :sensor_value_2_on_off_flag "
			+ "WHERE sensor_id = :sensor_id AND user_id like %:user_id%"
	)
	int updateRoom2OnOffStatus(
			@Param("sensor_value_2_on_off_flag") String sensor_value_2_on_off_flag,
			@Param("sensor_id") String sensor_id,
			@Param("user_id") String user_id
	);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_3_on_off_flag = :sensor_value_3_on_off_flag "
			+ "WHERE sensor_id = :sensor_id AND user_id like %:user_id%"
	)
	int updateRoom3OnOffStatus(
			@Param("sensor_value_3_on_off_flag") String sensor_value_3_on_off_flag,
			@Param("sensor_id") String sensor_id,
			@Param("user_id") String user_id
	);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value=
			"UPDATE sensorvalue "
			+ "SET sensor_value_1 = :motionvalue, sensor_modify_date = :modifydate "
			+ "WHERE sensor_id = :sensor_id AND user_id like %:user_id%"
	)
	int motiondataSave(
			@Param("motionvalue") String motionvalue,
			@Param("modifydate") String modifydate,
			@Param("sensor_id") String sensor_id,
			@Param("user_id") String user_id
	);
}
