package com.homeiot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipinfo")
public class TipModel {
	@Id
	@Column(name="tip_id")
	private String tip_id;
	
	@Column(name="tip_name")
	private String tip_name;
	
	@Column(name="tip_content")
	private String tip_content;
	
	@Column(name="tip_ref_address")
	private String tip_ref_address;

	public String getTip_id() {
		return tip_id;
	}

	public void setTip_id(String tip_id) {
		this.tip_id = tip_id;
	}

	public String getTip_name() {
		return tip_name;
	}

	public void setTip_name(String tip_name) {
		this.tip_name = tip_name;
	}

	public String getTip_content() {
		return tip_content;
	}

	public void setTip_content(String tip_content) {
		this.tip_content = tip_content;
	}

	public String getTip_ref_address() {
		return tip_ref_address;
	}

	public void setTip_ref_address(String tip_ref_address) {
		this.tip_ref_address = tip_ref_address;
	}
}
