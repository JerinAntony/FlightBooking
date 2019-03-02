package com.chainsys.flightbooking.model;

public class Airlines {

	private int id;
	private String flightName;
	private String flightNo;
	private int adultSeats;
	private int childSeats;
	private int adultPrice;
	private int childPrice;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
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

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", flightName=" + flightName
				+ ", flightNo=" + flightNo + ", adultSeats=" + adultSeats
				+ ", childSeats=" + childSeats + ", adultPrice=" + adultPrice
				+ ", childPrice=" + childPrice + ", status=" + status + "]";
	}

}
