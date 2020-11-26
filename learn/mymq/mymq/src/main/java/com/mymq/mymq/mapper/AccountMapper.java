package com.mymq.mymq.mapper;

import com.mymq.mymq.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
  @Update("update account set amount=amount-#{amount}, update_time=now() where userId=#{userId}")
  int updateAccount(Account account);

  @Insert("insert account(userId, amount, update_time) values(#{userId},#{amount},#{update_time})")
  int addAccount();

  @Select("select * from account where userId=#{userId}")
  List<Account> queryAcount(String userId);
}
