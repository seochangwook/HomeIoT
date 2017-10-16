package com.homeiot.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeiot.application.model.EnrollModel;

@Repository
public interface AuthDao extends JpaRepository<EnrollModel, Long>{
	@Procedure(name = "enrolldup")
    String dupenroll(
    		@Param("IN_ENROLL_TYPE") int type, 
    		@Param("IN_USER_ID") String userid,
    		@Param("IN_USER_PSWD") String userpswd,
    		@Param("IN_USER_NAME") String username,
    		@Param("IN_USER_ADDRESS") String useraddress,
    		@Param("IN_USER_PHONENUMBER") String userphonenumber,
    		@Param("IN_MAIL_PUSH") int mailpush,
    		@Param("IN_ROLE") String role
    );
}
