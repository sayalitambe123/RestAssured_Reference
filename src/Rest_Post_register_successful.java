import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import org.testng.Assert;


public class Rest_Post_register_successful {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		
		String RequestBody = "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}";
		
		
		
		String ResponseBody = given().header("Content-Type","Application/Json").body(RequestBody).
				when().post("api/register").then().extract().response().asPrettyString();
		System.out.println(ResponseBody);
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_id = JspResponse.getString("id");
		String Res_token = JspResponse.getString("token");
		
		
		Assert.assertNotEquals(Res_id, null);
		Assert.assertNotEquals(Res_id, 0);
		Assert.assertEquals(Res_token, "QpwL5tke4Pnpja7X4");
	}

}
