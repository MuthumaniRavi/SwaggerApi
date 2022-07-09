package com.pojo;

/**
 * 
 * @author Muthumani
 * @Description Add address serialization for input json(set the json values for
 *              an objects)
 * @created Date 07/01/2022
 */
public class AddAddress_Input_Pojo {
	/**
	 * JSON object references
	 */
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
	 * @Description To set the json object values by passing the constructor
	 *              arguments
	 * @created Date 07/01/2022
	 */
	public AddAddress_Input_Pojo(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
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
	 * @Description Getters
	 * @created Date 07/01/2022
	 */
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
