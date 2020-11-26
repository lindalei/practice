package com.mymq.mymq.service.imp;

import com.mymq.mymq.config.MQSender;
import com.mymq.mymq.entity.Account;
import com.mymq.mymq.entity.Message;
import com.mymq.mymq.mapper.AccountMapper;
import com.mymq.mymq.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {
  @Autowired
  MQSender sender;
  @Autowired
  AccountMapper accountMapper;
  @Autowired
  TransactionTemplate transactionTemplate;

  @Override
  public List<Account> queryAccount(String userId) {
    return accountMapper.queryAcount(userId);
  }

  @Override
  public void updateAccount(String userId, int amount) {
    String messageId = (String) transactionTemplate.execute(new TransactionCallback<Object>() {
      @Override
      public String doInTransaction(TransactionStatus transactionStatus) {
        Account account = new Account();
        account.setAmount(amount);
        account.setUserId(userId);
        int count = accountMapper.updateAccount(account);
        if (count == 1) {
          System.out.println("update success");
          String messageId = "transfer" + System.currentTimeMillis();
          return messageId;
        } else {
          return null;
        }
      }
    });

    if (messageId != null) {
      Message message = new Message();
      message.setAmount(amount);
      message.setMessageId(messageId);
      message.setStatus("unconfirmed");
      message.setUserId(userId);
      sender.send("linda.exchange", "linda.routing", message);
    }
  }
}
