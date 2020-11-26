package com.mymq.mymq.mapper;

import com.mymq.mymq.entity.Message;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
  @Select("select * from message where userId=#{userId} and status='notconfirmed'")
  List<Message> queryMessage(String userId);
}
