import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCID_002_POST_Request {
	
	
	@Test
	void registrationSuccessful()
	{
	
	//SpecifyBAse URI
	 RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	
	//Request object
	 RequestSpecification rsp= RestAssured.given();
	
	//Response object
	 Response res=rsp.request(Method.GET, "/Hyderabad");
	
	 // Print response in console window
	 String responseBody= res.getBody().asString();
	 System.out.println("Response body is : "+responseBody);
	 
	 // Validation od status code
	 int statusCode=res.getStatusCode();
	 System.out.println("status code is : "+statusCode);
	 Assert.assertEquals(statusCode, 200);
	 		
	 //Validation of status line
	 String statusLine=res.getStatusLine();
	 System.out.println("Status line is : "+statusLine);
	 Assert.assertEquals(statusLine, "HTTPS/1.1 200 OK");
	 
	Headers allHeaders= res.headers(); 

}
}