package com.hcl.trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.trading.dto.TrendingStocksDTO;
import com.hcl.trading.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query(value = "SELECT * FROM purchase p WHERE p.user_id=:userId AND p.purchase_status=:status", nativeQuery = true)
	public List<Purchase> findByUserIdAndPurchaseStatus(@Param("userId") Integer userId,
			@Param("status") String status);

	@Query("SELECT New com.hcl.trading.dto.TrendingStocksDTO(p.stockId,s.stockName,count(p.stockId)) FROM Purchase p,Stock s WHERE p.stockId = s.stockId and p.purchaseStatus=:purchaseStatus Group By p.stockId")

	public List<TrendingStocksDTO> findByPurchaseStatus(@Param("purchaseStatus") String purchaseStatus);

}
