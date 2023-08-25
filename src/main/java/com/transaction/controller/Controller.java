package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.FlightBookingRequest;
import com.transaction.dto.FlightBookingResponse;
import com.transaction.service.FlightService;

@RestController
@EnableTransactionManagement
public class Controller {
	@Autowired
	private  FlightService flightService;
	
	
	@PostMapping("/bookflight")
	public FlightBookingResponse bookingFlight(@RequestBody FlightBookingRequest flightBookingRequest) {
		return flightService.bookingFlight(flightBookingRequest);
		
	}

}
