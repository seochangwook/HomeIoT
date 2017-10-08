package com.homeiot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeiot.application.model.SensorValue;
import com.homeiot.application.model.UserDetailInfo;
import com.homeiot.application.model.UserInfo;

@Repository
public interface UserDataDao extends JpaRepository<UserInfo, String>{
	List<UserInfo> findAll();
	
	@Query(nativeQuery = true, value = 
			"SELECT user_id "
			+ "FROM userinfo "
			+ "WHERE user_id = :user_id")
	List<UserInfo> getUserInfo(@Param("user_id") String user_id);
}
