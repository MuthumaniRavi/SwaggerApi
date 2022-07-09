package com.pojo;

import java.util.ArrayList;
/**
 * 
 * @author Muthumani
 * @Description get response as json for get address
 * @created Date 07/01/2022
 */
public class GetAddress_Output_Pojo {
	 private int status;
	    private String message;
	    private ArrayList<Datas> data;
	    /**
	     * Getters
	     */
		public int getStatus() {
			return status;
		}
		public String getMessage() {
			return message;
		}
		public ArrayList<Datas> getData() {
			return data;
		}
}
