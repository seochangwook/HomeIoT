package com.homeiot.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo") //실제 작업할 테이블명으로 치환//
//해당 테이블에 관련된 프로시저 정의//
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "enrolldup", 
            procedureName = "ENROLL_USER",
            parameters = {
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_ENROLL_TYPE", type = Integer.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_USER_ID", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_USER_PSWD", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_USER_NAME", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_USER_ADDRESS", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_USER_PHONENUMBER", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_MAIL_PUSH", type = Integer.class),
               @StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_ROLE", type = String.class),
               @StoredProcedureParameter(mode = ParameterMode.OUT, name = "OUT_RESULT_VALUE", type = String.class)
            })
})
public class EnrollModel implements Serializable{
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="user_pswd")
	private String user_password;
	
	@Column(name="role")
	private String role;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
