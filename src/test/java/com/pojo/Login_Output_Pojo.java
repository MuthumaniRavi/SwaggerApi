package com.pojo;
/**
 * 
 * @author Muthumani
 * @Description get response as json for login
 * @created Date 07/01/2022
 */
public class Login_Output_Pojo {
	private int status;
    private String message;
    private Data data;
    private String refer_msg;
    private int cart_count;
    private String role;
    /**
     * Getters
     */
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Data getData() {
		return data;
	}
	public String getRefer_msg() {
		return refer_msg;
	}
	public int getCart_count() {
		return cart_count;
	}
	public String getRole() {
		return role;
	}
}
