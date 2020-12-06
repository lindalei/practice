package com.seckill.nacos.service;

import com.seckill.nacos.entity.Credit;
import com.seckill.nacos.repo.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

  @Autowired
  CreditRepository creditRepository;

  @Transactional
  public void updateCredit(String username, Long point) {
    List<Credit> stock = creditRepository.findByUsername(username);
    if (stock.isEmpty()) {
      Credit credit = new Credit();
      credit.setPoint(point);
      credit.setUsername(username);
      creditRepository.save(credit);
    } else {
      Credit credit = stock.get(0);
      credit.setPoint(point);
      creditRepository.save(credit);
    }
  }
}
