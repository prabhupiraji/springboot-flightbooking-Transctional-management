package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.PaymentInfo;

public interface PaymentRepo  extends JpaRepository<PaymentInfo, Long>{

}
