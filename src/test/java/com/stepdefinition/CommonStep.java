package com.stepdefinition;


import org.junit.Assert;


import com.base.BaseClass;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Muthumani
 *@Description common steps in all the scenarios in API automation
 * @created Date 07/01/2022
 */
public class CommonStep extends BaseClass{
	/**
	 * 
	 * @param exceptedStatusCode
	 * @Description User verify status code is 200
	 * @created Date 07/01/2022
	 */
	@Then("User verify status code is {int}")
	public void userVerifyStatusCodeIs(int exceptedStatusCode) {
		LoginStep.commonVariables.setActualStatusCode(getStatusCode(response));
		System.out.println("Status Code: "+LoginStep.commonVariables.getActualStatusCode());
		Assert.assertEquals("verify status code",exceptedStatusCode, LoginStep.commonVariables.getActualStatusCode());
	}
}
