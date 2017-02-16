package com.atsc.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jitendra
 *
 */
@XmlRootElement
public class Customer {
	
	private String firstName;
	private String customerLongitude;
	private String customerLatitude;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstName, String customerLongitude,
			String customerLatitude) {
		super();
		this.firstName = firstName;
		this.customerLongitude = customerLongitude;
		this.customerLatitude = customerLatitude;
	}
	

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCustomerLongitude() {
		return customerLongitude;
	}
	public void setCustomerLongitude(String customerLongitude) {
		this.customerLongitude = customerLongitude;
	}
	public String getCustomerLatitude() {
		return customerLatitude;
	}
	public void setCustomerLatitude(String customerLatitude) {
		this.customerLatitude = customerLatitude;
	}


}
