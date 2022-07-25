package com.hamitmizrak.atm.sql.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createdDate;
}
