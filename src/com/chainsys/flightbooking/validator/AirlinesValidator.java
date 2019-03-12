package com.chainsys.flightbooking.validator;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.flightbooking.dao.AirlinesDAO;
import com.chainsys.flightbooking.model.Airlines;

public class AirlinesValidator {

	/**
	 * Method to check airlines name already available in table
	 * 
	 * @param airlinesname
	 * @return
	 */
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

	/**
	 * Method to Validate airlines name
	 * 
	 * @param value
	 * @return
	 */
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

	public boolean dobValidate(LocalDate fatherdob) {
		boolean isdate = false;
		if (fatherdob.isAfter(LocalDate.now())
				|| fatherdob.equals(LocalDate.now())) {
			isdate = true;
		} else {
			isdate = false;
		}
		return isdate;
	}
}
