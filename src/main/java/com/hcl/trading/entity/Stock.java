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
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stockId;
	private String stockName;
	private String stockSector;
	private Integer stockPrice;
	private Integer stockQuantity;

}
