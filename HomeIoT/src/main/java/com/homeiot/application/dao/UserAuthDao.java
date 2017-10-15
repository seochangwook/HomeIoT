package com.homeiot.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeiot.application.model.UserAuth;

@Repository
public interface UserAuthDao extends JpaRepository<UserAuth, String>{
	@Query(nativeQuery = true, value = 
			"SELECT user_id, user_pswd, role "
			+ "FROM userinfo "
			+ "WHERE user_id = :user_id")
	List<UserAuth> getUserAuthInfo(@Param("user_id") String user_id);
}
