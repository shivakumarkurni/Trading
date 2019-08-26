package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDto implements Serializable{

	private static final long serialVersionUID = -8927268341185149124L;
	
	private Long mobileNo;
	private String password;
}
