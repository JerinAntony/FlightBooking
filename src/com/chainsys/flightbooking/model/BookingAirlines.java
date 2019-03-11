package com.chainsys.flightbooking.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class BookingAirlines {

	private int id;
	private AirlinesFlight airlinesId;
	private int adultSeats;
	private int childSeats;
	private int infant;
	private String coPassangersname;
	private int price;
	private LocalDate bookingDate;
	private int cancelStatus;
	private String pnrNo;
	private Passangers passenger_id;
	private int createdBy;
	private Timestamp createdTime;
	private int updatedBy;
	private Timestamp updatedTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AirlinesFlight getAirlinesId() {
		return airlinesId;
	}

	public void setAirlinesId(AirlinesFlight airlinesId) {
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

	public int getInfant() {
		return infant;
	}

	public void setInfant(int infant) {
		this.infant = infant;
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

	public int getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(int cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "BookingAirlines [id=" + id + ", airlinesId=" + airlinesId
				+ ", adultSeats=" + adultSeats + ", childSeats=" + childSeats
				+ ", infant=" + infant + ", coPassangersname="
				+ coPassangersname + ", price=" + price + ", bookingDate="
				+ bookingDate + ", cancelStatus=" + cancelStatus + ", pnrNo="
				+ pnrNo + ", passenger_id=" + passenger_id + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", updatedBy="
				+ updatedBy + ", updatedTime=" + updatedTime + "]";
	}

}
