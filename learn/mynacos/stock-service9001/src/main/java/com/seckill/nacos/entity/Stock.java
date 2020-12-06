package com.seckill.nacos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockCount")
public class Stock {

  @Id
  @GeneratedValue(generator = "uuidGenerator")
  @GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "stock_id", insertable = false, nullable = false, updatable = false, length = 40)
  private String id;

  @Column(name = "productId", length = 40)
  private Long productId;

  @Column(name = "stockCount", nullable = false, length = 40)
  private Integer stockCount;

  public Integer getStockCount() {
    return stockCount;
  }

  public void setStockCount(Integer stockCount) {
    this.stockCount = stockCount;
  }
}
