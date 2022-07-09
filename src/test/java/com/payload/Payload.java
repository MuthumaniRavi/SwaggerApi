package com.payload;

import com.base.BaseClass;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;

/**
 * 
 * @author Muthumani
 * @Description Payload for request body
 * @created Date 07/01/2022
 *
 */
public class Payload extends BaseClass {
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mobileNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @return AddAddress_Input_Pojo
	 * @Description Add address request body for API request
	 * @created Date 07/01/2022
	 */
	public static AddAddress_Input_Pojo createAddress(String firstname, String lastname, String mobileNo,
			String apartment, int state, int city, int country, String zipCode, String address, String addressType) {
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(firstname, lastname, mobileNo,
				apartment, state, city, country, zipCode, address, addressType);
		// addBody(addAddress_Input_Pojo);
		return addAddress_Input_Pojo;
	}

	/**
	 * 
	 * @param address_id
	 * @param firstname
	 * @param lastname
	 * @param mobileNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @return UpdateAddress_Input_Pojo
	 * @Description Update address request body for API request
	 * @created Date 07/01/2022
	 */
	public static UpdateAddress_Input_Pojo updateAddress(String address_id, String firstname, String lastname,
			String mobileNo, String apartment, int state, int city, int country, String zipCode, String address,
			String addressType) {
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(address_id, firstname,
				lastname, mobileNo, apartment, state, city, country, zipCode, address, addressType);
		// addBody(updateAddress_Input_Pojo);
		return updateAddress_Input_Pojo;

	}

	/**
	 * @param address_id
	 * @return DeleteAddress_Input_Pojo
	 * @Description Delete request body for API request
	 * @created Date 07/01/2022
	 */
	public static DeleteAddress_Input_Pojo deleteAddress(String address_id) {
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		// addBody(deleteAddress_Input_Pojo);
		return deleteAddress_Input_Pojo;

	}
}
