package com.homeiot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeiot.application.model.UserDetailInfo;

@Repository
public interface UserDetailDataDao extends JpaRepository<UserDetailInfo, String>{
	@Query(nativeQuery = true, value = 
			"SELECT a.user_id, b.user_id, a.user_address, a.user_phonenumber, a.user_name, a.mailpush_use "
			+ "FROM userinfo a, sensorvalue b "
			+ "WHERE a.user_id = b.user_id AND a.user_id = :user_id")
	List<UserDetailInfo> getUserDetailInfo(@Param("user_id") String user_id);
}
