package com.transaction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.dto.FlightBookingRequest;
import com.transaction.dto.FlightBookingResponse;
import com.transaction.entity.PassengerInfo;
import com.transaction.entity.PaymentInfo;
import com.transaction.repository.PassengerRepo;
import com.transaction.repository.PaymentRepo;
import com.transaction.util.PaymentUtils;

import jakarta.transaction.Transactional;

@Service

public class FlightService {

	@Autowired
	private PassengerRepo passengerRepo;
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Transactional
	//@Transctional is used to save the data if and if only when whole method exectued properly if any any exception it will not save any data 
	// without using transctional leads to data inconsistency and data redendency(duplicate)
	public FlightBookingResponse bookingFlight(FlightBookingRequest flightBookingRequest) {
	
		//getting passenger information from userrequest
		PassengerInfo passengerInfo=flightBookingRequest.getPassengerInfo();
		
		//saving passenger information from userrequest into database
		passengerInfo=passengerRepo.save(passengerInfo);
		
		//getting payment information from userrequest
		PaymentInfo paymentInfo=flightBookingRequest.getPaymentInfo();
		
		//valdating acount number and payingamount 
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getTotalfare());
		
		//if valid acount number and suffcient balance then only genrate below info and saved to payment db
		paymentInfo.setPassengerId(passengerInfo.getPid());
		paymentInfo.setAmount(passengerInfo.getTotalfare());
		paymentInfo=paymentRepo.save(paymentInfo);
		
		return new FlightBookingResponse("SUCCESS", passengerInfo.getTotalfare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
}
