import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
public class Rest_Post_Login_Unsuccessful {
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		String RequestBody = "{\r\n"
				+ "    \"email\": \"peter@klaven\"\r\n"
				+ "}";
		
		String ResponseBody = given().header("Content-type","Application/json").body(RequestBody).
				when().post("api/login").then().extract().response().asPrettyString();
		
		System.out.println(ResponseBody);
		
		JsonPath jspResponse = new JsonPath(ResponseBody);
		String error = jspResponse.getString("error");
		
		Assert.assertEquals(error, "Missing password");
	}

}
