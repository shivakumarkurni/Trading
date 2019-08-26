package com.hcl.trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trading.entity.Trading;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Integer> {
	List<Trading> findByStockId(Integer stockid);

}
