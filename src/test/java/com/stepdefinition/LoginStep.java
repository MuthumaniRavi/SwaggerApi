package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.CommonVariables_Pojo;
import com.pojo.Login_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author Muthumani
 * @Description user login perform through API automation
 * @created Date 07/01/2022
 */
public class LoginStep extends BaseClass {
	Response response;
	public static CommonVariables_Pojo commonVariables = new CommonVariables_Pojo();

	/**
	 * @Description user add header
	 * @created Date 07/01/2022
	 */
	@Given("user add header")
	public void userAddHeader() {
		addHeader("Content-Type", "application/json");
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description User add basic authendication for login
	 * @created Date 07/01/2022
	 */
	@Given("User add basic authendication for login")
	public void userAddBasicAuthendicationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
	}

	/**
	 * 
	 * @param loginRequest
	 * @Description User send post request for login endpoint
	 * @created Date 07/01/2022
	 * 
	 */
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String loginRequest) {
		response = requestType(loginRequest, EndPoints.LOGIN);

	}

	/**
	 * 
	 * @param string
	 * @Description User verify the login response body firstname and get the
	 *              logtoken
	 * @created Date 07/01/2022
	 * 
	 */
	@Then("User verify the login response body firstname present {string} and get the logtoken")
	public void userVerifyTheLoginResponseBodyFirstnamePresentAndGetTheLogtoken(String exepectedFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		System.out.println("Response First_Name: "+login_Output_Pojo.getData().getFirst_name());
		Assert.assertEquals( "verify firstname is MUTHUMANI", exepectedFirstName,login_Output_Pojo.getData().getFirst_name());
		commonVariables.setLogtoken(login_Output_Pojo.getData().getLogtoken());
		System.out.println("Response Logtoken: "+login_Output_Pojo.getData().getLogtoken());
	}
}
