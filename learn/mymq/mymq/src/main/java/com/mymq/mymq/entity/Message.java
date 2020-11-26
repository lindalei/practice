package com.mymq.mymq.entity;

public class Message {
  Integer id;
  String messageId;
  String userId;
  int amount;
  String status;

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessageId() {
    return messageId;
  }

  public String getUserId() {
    return userId;
  }

  public int getAmount() {
    return amount;
  }

  public String getStatus() {
    return status;
  }
}
