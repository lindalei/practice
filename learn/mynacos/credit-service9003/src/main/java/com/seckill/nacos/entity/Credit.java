package com.seckill.nacos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit")
public class Credit {

  @Id
  @GeneratedValue(generator = "uuidGenerator")
  @GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "credit_id", insertable = false, nullable = false, updatable = false, length = 40)
  private String id;

  @Column(name = "point", nullable = false, length = 40)
  private Long point;

  @Column(name = "username", nullable = false, length = 40)
  private String username;

  public Long getPoint() {
    return point;
  }

  public void setPoint(Long point) {
    this.point = point;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
