package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoints {

	public static Response createuser(UserPOJO payload) {
		
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.createurl);
		return res;
	}
	
	public static Response getuser(String userName) {
		
		Response res=given()
		.pathParam("username", userName)
		.when()
		.get(Routes.geturl);
		return res;
	}
public static Response updateuser(String userName,UserPOJO payload) {
		
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.post(Routes.updateurl);
		return res;
	}

public static Response deleteuser(String userName) {
	
	Response res=given()
	.pathParam("username", userName)
	.when()
	.post(Routes.deleteurl);
	return res;
}
}
