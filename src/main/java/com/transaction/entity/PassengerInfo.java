package com.transaction.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="passengerInformation")
public class PassengerInfo {
	@Id
    @GeneratedValue
	private Long pid;
	private  String name;
	private String email;
	private String phoneno;
	private int age;
	private String source;
	private String Destination;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date travelDate;
	private String pickupTime;
	private String arrivalTime;
	private double totalfare;
	
}
