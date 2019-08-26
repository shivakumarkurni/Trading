package com.hcl.trading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String password;
	private Long mobileNo;

}
