package com.seckill.nacos.repo;

import com.seckill.nacos.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends JpaRepository<Credit, String> {


  List<Credit> findByUsername(String username);
}
