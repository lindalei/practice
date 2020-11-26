package com.mymq.mymq.service;

import com.mymq.mymq.entity.Account;

import java.util.List;

public interface TransferMoneyService {
  void updateAccount(String userId, int amout);
  List<Account> queryAccount(String userId);
}
