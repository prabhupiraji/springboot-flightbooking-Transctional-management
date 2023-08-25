package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.PassengerInfo;

public interface PassengerRepo  extends JpaRepository<PassengerInfo, Long>{

}
