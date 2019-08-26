package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDetailsDto implements Serializable{

	private static final long serialVersionUID = -5830836629700341766L;
	
	private Integer userId;
	private String message;
	private Integer statusCode;
}
