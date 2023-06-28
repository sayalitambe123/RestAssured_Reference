import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import org.testng.Assert;


public class Rest_Post_Login_successful {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		String RequestBody = "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}";		
		
		String ResponseBody = given().header("Content-type", "Application/Json").body(RequestBody).
				when().post("api/login").then().extract().response().asPrettyString();
		System.out.println(ResponseBody);
		
		JsonPath jspResponse = new JsonPath(ResponseBody);
		String Res_token = jspResponse.getString("token");
		
		Assert.assertEquals(Res_token,"QpwL5tke4Pnpja7X4");		
		
	}
}
