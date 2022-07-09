package com.pojo;
/**
 * 
 * @author Muthumani
 * @Description request as json for delete address by using POJO class
 * @created Date 07/01/2022
 */
public class DeleteAddress_Input_Pojo {
	private String address_id;
/**
 * Constructor act as a Setters where as Getters to get the address_id
 */
	public DeleteAddress_Input_Pojo(String address_id) {
		this.address_id = address_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	
}
