package com.chainsys.flightbooking.model;

public class Airlines {

	private int id;
	private String airlinesName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlinesName() {
		return airlinesName;
	}

	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", airlinesName=" + airlinesName + "]";
	}

}
