import java.time.LocalDateTime;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Rest_Put_Reference {

	public static void main(String[] args) {
		
		// Declaring Base URI
		RestAssured.baseURI = "https://reqres.in/";
		
		//Declaring requestBody in string variable
		String RequestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		//Declaring expected results
		JsonPath JspRequest = new JsonPath(RequestBody);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdatetime = LocalDateTime.now();
		String current = currentdatetime.toString().substring(0,10); 
		
		//Declaring ResponseBody
		String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).
				when().put("/api/users/2").then().extract().response().asPrettyString();
		System.out.println(ResponseBody);
		//Fetching Response body 
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0, 10);
		//Validation 
		Assert.assertEquals(Res_name, Req_name);		
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, current);
		
	}

}
