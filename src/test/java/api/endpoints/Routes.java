package api.endpoints;

/*
 Swagger URI=https://petstore.swagger.io/v2
 
 Create user(post): //petstore.swagger.io/v2/user;
 Get user(post): //petstore.swagger.io/v2/user/{username};
 Update user(post): //petstore.swagger.io/v2/user/{username};
 Delete user(post): //petstore.swagger.io/v2/user/{username}; 
  
 */

public class Routes {

	//user module
	public static String baseurl="https://petstore.swagger.io/v2/";
	
	public static String createurl=baseurl +"user";
	public static String geturl=baseurl +"user/{username}";
	public static String updateurl=baseurl +"user/{username}";
	public static String deleteurl=baseurl +"user/{username}";
	
	//create store module url's
	//create pet module url's
	
}
