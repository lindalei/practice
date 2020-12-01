package com.seckill.seckill.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

  @Id
  @GeneratedValue(generator = "uuidGenerator")
  @GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "stock_id", insertable = false, nullable = false, updatable = false, length = 40)
  private String id;

  @Column(name = "name", nullable = false, length = 40)
  private String name;

  @Column(name = "stock", nullable = false, length = 40)
  private Long stock;

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }
}
