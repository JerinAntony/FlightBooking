package com.chainsys.flightbooking.validator;

import java.util.List;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.model.Airlines;

public class AirlinesValidator {

	public boolean airlinesAlreadyExists(String airlinesname) {
		boolean isAvailable = false;
		AirlinesDAO airlinesDAO = new AirlinesDAO();
		try {
			List<Airlines> airlinesList = airlinesDAO.findAll();
			for (Airlines airline : airlinesList) {
				if (airline.getAirlinesName().equals(airlinesname)) {
					isAvailable = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAvailable;
	}

	public boolean validString(String value) {
		boolean isValid = false;
		String filter = "[a-zA-Z]+";
		if (value.matches(filter)) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}
}
