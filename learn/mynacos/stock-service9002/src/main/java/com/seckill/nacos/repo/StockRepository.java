package com.seckill.nacos.repo;

import com.seckill.nacos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

  @Modifying
  @Query("UPDATE Stock s SET s.stockCount = :stockCount WHERE s.productId = :productId")
  void deductStock(@Param("stockCount") Integer stockCount, @Param("productId") Long productId);


  Optional<Stock> findByProductId(Long productId);
}
