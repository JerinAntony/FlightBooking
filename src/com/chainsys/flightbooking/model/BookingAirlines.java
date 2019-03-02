package com.chainsys.flightbooking.model;

import java.time.LocalDate;

public class BookingAirlines {

	private int id;
	private Airlines airlinesId;
	private int adultSeats;
	private int childSeats;
	private String coPassangersname;
	private int price;
	private LocalDate bookingDate;
	private Passangers passenger_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airlines getAirlinesId() {
		return airlinesId;
	}

	public void setAirlinesId(Airlines airlinesId) {
		this.airlinesId = airlinesId;
	}

	public int getAdultSeats() {
		return adultSeats;
	}

	public void setAdultSeats(int adultSeats) {
		this.adultSeats = adultSeats;
	}

	public int getChildSeats() {
		return childSeats;
	}

	public void setChildSeats(int childSeats) {
		this.childSeats = childSeats;
	}

	public String getCoPassangersname() {
		return coPassangersname;
	}

	public void setCoPassangersname(String coPassangersname) {
		this.coPassangersname = coPassangersname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Passangers getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Passangers passenger_id) {
		this.passenger_id = passenger_id;
	}

	@Override
	public String toString() {
		return "BookingAirlines [id=" + id + ", airlinesId=" + airlinesId
				+ ", adultSeats=" + adultSeats + ", childSeats=" + childSeats
				+ ", coPassangersname=" + coPassangersname + ", price=" + price
				+ ", bookingDate=" + bookingDate + ", passenger_id="
				+ passenger_id + "]";
	}

}
