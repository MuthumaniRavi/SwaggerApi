package com.pojo;
/**
 * 
 * @author Muthumani
 * @Description Common variables class use to store the common values throughout the API automationexecution 
 * @created Date 07/01/2022
 */
public class CommonVariables_Pojo {
	private String logtoken;
	private String address_id;
	private int actualStatusCode;
	/**
	 * Getters
	 */
	public int getActualStatusCode() {
		return actualStatusCode;
	}

	public void setActualStatusCode(int actualStatusCode) {
		this.actualStatusCode = actualStatusCode;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}
}
