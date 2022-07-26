package com.hamitmizrak.atm.sql.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
abstract public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	protected Date createdDate;
	
	// parametresiz constructor
	public BaseEntity() {
	}
	
	// parametreli constructor
	public BaseEntity(Long id) {
		this.id = id;
	}
	
}
