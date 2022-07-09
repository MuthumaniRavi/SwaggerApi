package com.omr.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.Address_Output_Pojo;
import com.pojo.ChangeProfilePic_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * 
 * @author Muthumani
 * @Description Swagger omrbrack website login and perform some actions through
 *              API
 * @created Date 07/01/2022
 *
 */
public class OMRBranchClub extends BaseClass {
	String logtoken;
	String address_id;

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description To perform login through API
	 * @created Date 07/01/2022
	 */
	@Test(priority = 1)
	public void login() throws FileNotFoundException, IOException {// login
		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
		Response response = requestType("POST", EndPoints.LOGIN);
		System.out.println("==============================Deserialization===============================");
		System.out.println(getStatusCode(response));
		// System.out.println(getResBodyAsPrettyString(response));
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		System.out.println("first_name : " + login_Output_Pojo.getData().getFirst_name());
		logtoken = login_Output_Pojo.getData().getLogtoken();
	}

	/**
	 * @Description To perform Add Address through API
	 * @created Date 07/01/2022
	 */
	@Test(priority = 2)
	public void addAddress() {// post
		// Add Headers
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		System.out.println("==============================Serialization===============================");
		// add payLoad //serialization
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo("saravana", "suriya", "8610988167",
				"pomtreeApartment", 33, 344, 56, "641501", "thuraippakam", "home");
		addBody(addAddress_Input_Pojo);
		System.out.println(addAddress_Input_Pojo.getAddress());
		// req Type
		Response response = requestType("POST", EndPoints.ADDADDRESS);
		System.out.println("Status Code : " + getStatusCode(response));

		// //Deserialization
		Address_Output_Pojo address_Output_Pojo = response.as(Address_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
		System.out.println(message);
		address_id = String.valueOf(address_Output_Pojo.getAddress_id());
		System.out.println(address_id);

	}

	/**
	 * @Description update the existing address through API
	 * @created Date 07/01/2022
	 */
	@Test(priority = 3)
	public void updateAddress() {
		// Add Headers
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		System.out.println("==============================Serialization===============================");
		// add payLoad //se rialization
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(address_id, "saravana",
				"suriya", "8610988167", "pomtreeApartment", 33, 344, 56, "641501", "thuraippakam", "home");
		addBody(updateAddress_Input_Pojo);
		System.out.println(updateAddress_Input_Pojo.getAddress());
		// req Type
		Response response = requestType("PUT", EndPoints.UPDATEADDRESS);
		System.out.println("Status Code : " + getStatusCode(response));

		// //Deserialization

		UpdateAddress_Output_Pojo UpdateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		System.out.println(UpdateAddress_Output_Pojo.getMessage());

	}

	/**
	 * @Description To get the address
	 * @created Date 07/01/2022
	 */
	@Test(priority = 4)
	public void getAddress() {
		// Add Headers
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		// req Type
		Response response = requestType("GET", EndPoints.GETADDRESS);
		System.out.println("Status Code : " + getStatusCode(response));
		GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);
		String message = getAddress_Output_Pojo.getMessage();
		System.out.println(message);

	}

	/**
	 * @Description To delete the requested address id
	 * @created Date 07/01/2022
	 */
	@Test(priority = 5)
	public void deleteAddress() {
		// Add Headers
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		addBody(deleteAddress_Input_Pojo);
		// req Type
		Response response = requestType("DELETE", EndPoints.DELETEADDRESS);
		System.out.println("Status Code : " + getStatusCode(response));

		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		System.out.println(deleteAddress_Output_Pojo.getMessage());

	}

	/**
	 * @Description To change the profile picture through API
	 * @created Date 07/01/2022
	 */
	@Test(priority = 6)
	public void changeProfilePicture() {
		// Add Headers
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		// 2 pass from data
		multipart();

		Response response = requestType("POST", EndPoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeProfilePic_Output_Pojo.getMessage();
		System.out.println(message);
	}

}
