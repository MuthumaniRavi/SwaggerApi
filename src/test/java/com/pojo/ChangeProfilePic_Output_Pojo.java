package com.pojo;

/**
 * 
 * @author Muthumani
 * @Description get response as json for change profile picture
 * @created Date 07/01/2022
 */
public class ChangeProfilePic_Output_Pojo {
	/**
	 * JSON Object references
	 */
	private int status;
	private String message;
	private ChangeProfileData data;
	private int cart_count;

	/**
	 * Getters
	 */
	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public ChangeProfileData getData() {
		return data;
	}

	public int getCart_count() {
		return cart_count;
	}

}
