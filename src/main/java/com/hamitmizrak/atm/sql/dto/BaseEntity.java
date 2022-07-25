package com.hamitmizrak.atm.sql.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data

abstract public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createdDate;
	
	public BaseEntity() {
		super();
	}
	
	public BaseEntity(Long id) {
		super();
		this.id = id;
	}
	
}
