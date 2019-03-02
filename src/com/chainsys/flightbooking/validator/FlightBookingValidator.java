package com.chainsys.flightbooking.validator;

import com.chainsys.flightbooking.exceptions.InvalidSeats;
import com.chainsys.flightbooking.model.BookingAirlines;

public class FlightBookingValidator {

	public void checkFlightBooking(BookingAirlines bookairlines)
			throws Exception {
		if (bookairlines.getAdultSeats() == 0) {
			throw new InvalidSeats("Invalid Seat Selection");
		}
	}
}
