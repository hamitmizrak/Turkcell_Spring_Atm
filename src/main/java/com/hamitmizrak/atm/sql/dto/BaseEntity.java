package com.hamitmizrak.atm.sql.dto;

import java.sql.Date;

abstract public class BaseEntity {
	
	private Long id;
	private Date createdDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
