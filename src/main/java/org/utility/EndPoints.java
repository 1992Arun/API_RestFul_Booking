package org.utility;

public enum EndPoints {
	
	getBookings("booking/"),
	createBooking("booking"),
	updateBooking("booking/"),	
	partialUpdateBooking("booking/"),
	deleteBooking("booking/"),
	createAuth("auth");
	public String getResource() {
		return resource;
	}

	String resource;
	
	EndPoints(String resource){
		
		this.resource=resource;
		
	}

}
