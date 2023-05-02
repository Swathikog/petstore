package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTest {

	Faker fake;
	UserPOJO userpayload;
	
	public Logger logging;
	@BeforeClass
	public void setupData() {
		
		fake=new Faker();
		userpayload=new UserPOJO();
		
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().emailAddress());
		userpayload.setPassword(fake.internet().password());
		userpayload.setPhone(fake.phoneNumber().cellPhone());
		
		logging=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void mainfirstTest() {
		logging.info("*******creating the Test*********");
		Response resp=UserEndpoints.createuser(userpayload);
		resp.then().log().all();
		Assert.assertEquals(resp.statusCode(), 200);	
		logging.info("*******User is Created*********");
	}
	
	@Test(priority=2)
	public void mainsecondTest() {
		Response resp=UserEndpoints.getuser(this.userpayload.getUsername());
		resp.then().log().all();
		resp.getStatusCode();
	}
	
	@Test(priority=3)
	public void mainthirdTest() {
		Response resp=UserEndpoints.updateuser(this.userpayload.getUsername(),userpayload);
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().emailAddress());
		resp.then().log().all();
		resp.getStatusCode();
	}
	@Test(priority=4)
	public void mainfourthTest() {
		Response resp=UserEndpoints.deleteuser(this.userpayload.getUsername());
		resp.then().log().body().statusCode(405);
		
	}
}
