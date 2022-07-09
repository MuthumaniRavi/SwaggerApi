package com.pojo;
/**
 * 
 * @author Muthumani
 * @Description Add address deserialization for output json(get the json object values)
 * @created Date 07/01/2022
 */
public class Address_Output_Pojo {
	public int status;
    public String message;
    public int address_id;
    /**
     * Getters
     */
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public int getAddress_id() {
		return address_id;
	}
}
