package org.postRequest;

public class Parent {

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

	public void setBookingdates(Bookingdates bookingdates) {
		this.bookingdates = bookingdates;
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

	public Bookingdates getBookingdates() {
		return bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	private Bookingdates bookingdates;
	
	private String additionalneeds;
	
	
}
