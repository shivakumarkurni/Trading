package com.hcl.trading.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer purchaseId;
	private Integer stockId;
	private Integer quantity;
	private Integer amount;
	private Integer userId;
	private LocalDate purchaseDate;
	private String purchaseStatus;

}
