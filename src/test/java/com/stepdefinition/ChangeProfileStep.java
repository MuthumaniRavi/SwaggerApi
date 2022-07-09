package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Muthumani
 * @Description change the profile picture through API automation
 * @created Date 07/01/2022
 */
public class ChangeProfileStep extends BaseClass {
	/**
	 * @Description User add headers and bearer authendication for accessing profile
	 *              endpoint
	 * @created Date 07/01/2022
	 */
	@Given("User add headers and bearer authendication for accessing profile endpoint")
	public void userAddHeadersAndBearerAuthendicationForAccessingProfileEndpoint() {
		List<Header> h = new ArrayList<Header>();
		h.add(new Header("Content-Type", "multipart/form-data"));
		h.add(new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken()));
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Description User add multipart for change the profile picture
	 * @created Date 07/01/2022
	 */
	@When("User add multipart for change the profile picture")
	public void userAddMultipartForChangeTheProfilePicture() {
		multipart();
	}

	/**
	 * 
	 * @param changeProfilePicRequest
	 * @Description User send post request for change the profile picture
	 * @created Date 07/01/2022
	 */
	@When("User send {string} request for change the profile picture")
	public void userSendRequestForChangeTheProfilePicture(String changeProfilePicRequest) {
		response = requestType(changeProfilePicRequest, EndPoints.CHANGEPROFILEPIC);

	}

	/**
	 * 
	 * @param expected
	 * @Description User verify the updated profile picture response message
	 * @created Date 07/01/2022
	 */
	@Then("User verify the updated profile picture response message matches with {string}")
	public void userVerifyTheUpdatedProfilePictureResponseMessageMatchesWith(String expected) {
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeProfilePic_Output_Pojo.getMessage();
		System.out.println("Response message: "+message);
		Assert.assertEquals("verify Change profile picture message", expected,
				changeProfilePic_Output_Pojo.getMessage());

	}

}
