import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Rest_Get {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		
		String ResponseBody = given().header("Content-Type","Application/Json").
				when().get("api/users/2").then().extract().response().asPrettyString();
		
		System.out.println(ResponseBody);
		
		

	}

}
