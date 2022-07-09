package com.pojo;

/**
 * 
 * @author Muthumani
 * @Description Request as json to update the address
 * @created Date 07/01/2022
 */
public class UpdateAddress_Input_Pojo {
	/**
	 * JSON object references
	 */
	private String address_id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String apartment;
	private int state;
	private int city;
	private int country;
	private String zipcode;
	private String address;
	private String address_type;

	/**
	 * 
	 * @param address_id
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @Description parameterized constructor use to set the value JSON requests
	 * @created Date 07/01/2022
	 */
	public UpdateAddress_Input_Pojo(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		this.address_id = address_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}

	/**
	 * Getters
	 */
	public String getAddress_id() {
		return address_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getApartment() {
		return apartment;
	}

	public int getState() {
		return state;
	}

	public int getCity() {
		return city;
	}

	public int getCountry() {
		return country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getAddress() {
		return address;
	}

	public String getAddress_type() {
		return address_type;
	}
}
