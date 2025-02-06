package org.putRequest;

public class PUTParent {

	private String firstname;
	
	private String lastname;
	
	private String totalprice;
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public void setDepositpaid(String depositpaid) {
		this.depositpaid = depositpaid;
	}



	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	private String depositpaid;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public String getDepositpaid() {
		return depositpaid;
	}


	public PUTBookingdates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(PUTBookingdates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	private PUTBookingdates bookingdates;
	
	private String additionalneeds;
	
	
}
