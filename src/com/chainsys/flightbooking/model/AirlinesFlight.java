package com.chainsys.flightbooking.model;

public class AirlinesFlight {

	private int id;
	private Airlines flightName;
	private String flightNo;
	private int adultSeats;
	private int childSeats;
	private int adultPrice;
	private int childPrice;
	private String flightClass;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airlines getFlightName() {
		return flightName;
	}

	public void setFlightName(Airlines flightName) {
		this.flightName = flightName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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

	public int getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(int adultPrice) {
		this.adultPrice = adultPrice;
	}

	public int getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(int childPrice) {
		this.childPrice = childPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "AirlinesFlight [id=" + id + ", flightName=" + flightName
				+ ", flightNo=" + flightNo + ", adultSeats=" + adultSeats
				+ ", childSeats=" + childSeats + ", adultPrice=" + adultPrice
				+ ", childPrice=" + childPrice + ", flightClass=" + flightClass
				+ ", status=" + status + "]";
	}

}
