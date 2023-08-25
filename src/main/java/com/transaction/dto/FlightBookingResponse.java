package com.transaction.dto;

import com.transaction.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingResponse {

	private String bookingstatus;
	private Double totalfare;
	private String pnrno;
	private PassengerInfo passengerInfo;
}
