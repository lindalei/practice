package com.seckill.nacos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order {

  @Id
  @GeneratedValue(generator = "uuidGenerator")
  @GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "order_id", insertable = false, nullable = false, updatable = false, length = 40)
  private String id;

  @Column(name = "username", nullable = false, length = 40)
  private String username;

  @Column(name = "productId", nullable = false, length = 40)
  private Long productId;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }
}
