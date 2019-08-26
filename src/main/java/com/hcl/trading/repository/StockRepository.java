package com.hcl.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.trading.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
