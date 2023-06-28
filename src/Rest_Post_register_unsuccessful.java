import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class Rest_Post_register_unsuccessful {

	public static void main(String[] args) {
		
		RestAssured.baseURI ="https://reqres.in/";
		
		String RequestBody = "{\r\n"
				+ "    \"email\": \"sydney@fife\"\r\n"
				+ "}";
		
	
		String ResponseBody = given().headers("Content-Type", "Application/Json").body(RequestBody).
				when().post("api/register").then().extract().response().asPrettyString();
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String res_error = JspResponse.getString("error");
		
		Assert.assertEquals(res_error, "Missing password");
	}

}
