package com.chainsys.flightbooking.model;

import java.sql.Timestamp;

public class FlightDestinations {

	private int id;
	private String place;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
		return "FlightDestinations [id=" + id + ", place=" + place
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", updatedBy=" + updatedBy + ", updatedTime=" + updatedTime
				+ "]";
	}
	
	
}
