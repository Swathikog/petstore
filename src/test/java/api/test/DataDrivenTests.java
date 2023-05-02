package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostuser(String userId,String userName,String fName,String lName,String useremail,String pwd,String ph) 
	{
		UserPOJO userpayload=new UserPOJO();
		
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fName);
		userpayload.setLastName(lName);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
			
		Response resp=UserEndpoints.createuser(userpayload);
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testdeleteuser(String userName) {
	Response resp=	UserEndpoints.deleteuser(userName);
		resp.getStatusCode();
	}
	
}
