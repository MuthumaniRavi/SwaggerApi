package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.payload.Payload;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.Address_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Muthumani
 * @Description Add the address through the API Request and make action on the
 *              address through API like update the address, get the addresses
 *              and delete the address
 * @created Date 07/01/2022
 */
public class AddressStep extends BaseClass {
	/**
	 * @Description User add headers and bearer authendication for accessing address
	 *              endpoint
	 * @created Date 07/01/2022
	 */
	@Given("User add headers and bearer authendication for accessing address endpoint")
	public void userAddHeadersAndBearerAuthendicationForAccessingAddressEndpoint() {
		List<Header> h = new ArrayList<Header>();
		h.add(new Header("Content-Type", "application/json"));
		h.add(new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken()));
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param mobileNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @Description User add request body for add address
	 * @created Date 07/01/2022
	 */
	@When("User add request body for add address {string},{string},{string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userAddRequestBodyForAddAddressAnd(String firstName, String lastName, String mobileNo, String apartment,
			String state, String city, String country, String zipCode, String address, String addressType) {

		AddAddress_Input_Pojo createAddress = Payload.createAddress(firstName, lastName, mobileNo, apartment,
				Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipCode, address,
				addressType);

		addBody(createAddress);

	}

	/**
	 * 
	 * @param addRequest
	 * @Description User send post request for add new address
	 * @created Date 07/01/2022
	 */
	@When("User send {string} request for add new address")
	public void userSendRequestForAddNewAddress(String addRequest) {
		response = requestType(addRequest, EndPoints.ADDADDRESS);

	}

	/**
	 * 
	 * @param excepted
	 * @Description User verify the created address response message
	 * @created Date 07/01/2022
	 */
	@Then("User verify the created address response message matches with {string} and get address id")
	public void userVerifyTheCreatedAddressResponseMessageMatchesWithAndGetAddressId(String excepted) {
		Address_Output_Pojo address_Output_Pojo = response.as(Address_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
//		System.out.println(excepted);
//		System.out.println(message);
		System.out.println("Response message: "+message);
		Assert.assertEquals("verify add address message", excepted, address_Output_Pojo.getMessage());

		LoginStep.commonVariables.setAddress_id(String.valueOf(address_Output_Pojo.getAddress_id()));

	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param mobileNo
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipCode
	 * @param address
	 * @param addressType
	 * @Description User add request body for update address
	 * @created Date 07/01/2022
	 */
	@When("User add request body for update address {string},{string},{string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userAddRequestBodyForUpdateAddressAnd(String firstName, String lastName, String mobileNo,
			String apartment, String state, String city, String country, String zipCode, String address,
			String addressType) {
		UpdateAddress_Input_Pojo updateAddress = Payload.updateAddress(LoginStep.commonVariables.getAddress_id(),
				firstName, lastName, mobileNo, apartment, Integer.parseInt(state), Integer.parseInt(city),
				Integer.parseInt(country), zipCode, address, addressType);
		addBody(updateAddress);

	}

	/**
	 * 
	 * @param updateRequest
	 * @Description User send put request for update the address
	 * @created Date 07/01/2022
	 */
	@When("User send {string} request for update the address")
	public void userSendRequestForUpdateTheAddress(String updateRequest) {
		response = requestType(updateRequest, EndPoints.UPDATEADDRESS);

	}

	/**
	 * 
	 * @param excepted
	 * @Description User verify the updated address response message
	 * @created Date 07/01/2022
	 */
	@Then("User verify the updated address response message matches with {string}")
	public void userVerifyTheUpdatedAddressResponseMessageMatchesWith(String excepted) {
		UpdateAddress_Output_Pojo UpdateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		System.out.println("Response message: "+UpdateAddress_Output_Pojo.getMessage());
		Assert.assertEquals("verify update address message", excepted, UpdateAddress_Output_Pojo.getMessage());

	}

	/**
	 * 
	 * @param getRequest
	 * @Description User send get request for get the address
	 * @created Date 07/01/2022
	 */
	@When("User send {string} request for get the address")
	public void userSendRequestForGetTheAddress(String getRequest) {
		response = requestType(getRequest, EndPoints.GETADDRESS);

	}

	/**
	 * 
	 * @param excepted
	 * @Description User get response body for address and verify the get address
	 *              response message
	 * @created Date 07/01/2022
	 */
	@Then("User get response body for address and verify the get address response message matches with {string}")
	public void userGetResponseBodyForAddressAndVerifyTheGetAddressResponseMessageMatchesWith(String excepted) {
		GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);
		System.out.println("Response message: "+ getAddress_Output_Pojo.getMessage());
		Assert.assertEquals("verify get address message", excepted, getAddress_Output_Pojo.getMessage());

	}

	/**
	 * @Description User add request body for delete address
	 * @created Date 07/01/2022
	 */
	@When("User add request body for delete address")
	public void userAddRequestBodyForAddress() {
		DeleteAddress_Input_Pojo deleteAddress = Payload.deleteAddress(LoginStep.commonVariables.getAddress_id());
		addBody(deleteAddress);

	}

	/**
	 * 
	 * @param string
	 * @Description User send delete request for delete address
	 * @created Date 07/01/2022
	 */
	@When("User send {string} request for delete address")
	public void userSendRequestForDeleteAddress(String string) {
		response = requestType("DELETE", EndPoints.DELETEADDRESS);

	}

	/**
	 * 
	 * @param excepted
	 * @Description User verify the deleted address response message
	 * @created Date 07/01/2022
	 */
	@Then("User verify the deleted address response message matches with {string}")
	public void userVerifyTheDeletedAddressResponseMessageMatchesWith(String excepted) {
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		System.out.println("Response message: "+deleteAddress_Output_Pojo.getMessage());
		Assert.assertEquals("verify delete address", excepted, deleteAddress_Output_Pojo.getMessage());

	}
}
