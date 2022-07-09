package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author Muthumani
 * @Description to maintain all the reusable methods
 * @created Date 07/01/2022
 *
 */

public class BaseClass {
	/**
	 * instane for request and response
	 */
	public static RequestSpecification reqSpec;
	public static Response response;
	
/**
 * @param key
 * @param value
 *  @Description To addHeader for request specification
 * @created Date 07/01/2022
 */
	public static void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
/**
 * 
 * @param headers
 * @Description To add multiple headers for request specification
 * @created Date 07/01/2022
 */
	public static void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}
/**
 * 
 * @param key
 * @param value
 * @Description to add query parameter for request specification
 * @created Date 07/01/2022
 */
	public static void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
/**
 * 
 * @param key
 * @param value
 * @Description To add path parameter for request specification
 * @created Date 07/01/2022
 */
	public static void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}
/**
 * 
 * @param body
 * @Description to add the request body as string
 * @created Date 07/01/2022@
 */
	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}
/**
 * 
 * @param body
 * @Description To add request body as Object
 * @created Date 07/01/2022
 */
	public static void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}
	/**
	 * @Description multipart use to change the profile picture through api automation
 * @created Date 07/01/2022
	 */

	public static void multipart() {
		reqSpec = reqSpec.multiPart("profile_picture", new File("C:\\Users\\Muthumani\\eclipse-workspace\\OMRBranchAPIAutomation\\target\\IMG-20180902-WA0006.jpg"));
	}
/**
 * 
 * @param reqType
 * @param endPoint
 * @return Response
 * @Description To pass request endpoint to server as per the request type
 * @created Date 07/01/2022
 */
	public static Response requestType(String reqType, String endPoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}
/**
 * 
 * @param response
 * @Description to get the statuscode from url response
 * @created Date 07/01/2022
 * @return int
 */
	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
/**
 * 
 * @param response
 * @return ResponseBody<?>
 * @Description To get the reponse body
 * @created Date 07/01/2022
 */
	public static ResponseBody<?> getResponsebody(Response response) {
		ResponseBody<?> body = response.getBody();
		return body;
	}
/**
 * 
 * @param response
 * @return String 
 * @Description To convert the response body as simple string format in single line json
 * @created Date 07/01/2022
 */
	public static String getResBodyAsString(Response response) {
		String asString = getResponsebody(response).asString();
		return asString;

	}
/**
 * 
 * @param response
 * @return String 
 * @Description To convert response body as pretty json format in json
 * @created Date 07/01/2022
 */
	public static String getResBodyAsPrettyString(Response response) {
		String asPrettyString = getResponsebody(response).asPrettyString();
		return asPrettyString;

	}
/**
 * 
 * @param json
 * @Description  To get the ressponse body
 * @created Date 07/01/2022
 */
	public static void requestBody(String json) {
		reqSpec = reqSpec.body(json);
	}
/**
 * 
 * @param username
 * @param password
 * @Description to use basic authendication 
 * @created Date 07/01/2022
 */
	public static void basicAuth(String username, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}
/**
 * 
 * @param key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 * @Description To read the values from the property files
 * @created Date 07/01/2022
 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "//config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

}
