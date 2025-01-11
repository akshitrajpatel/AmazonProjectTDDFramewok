package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SignInPage;

public class SigninTest extends BaseClass {
	HomePage hp;
	SignInPage signin;
	IndexPage index;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("SigninTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void signin() throws Throwable {
		hp = new HomePage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
	   	Thread.sleep(1500);
		String actualurl = index.getcurrurl();
		String expectedurl = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
		Assert.assertEquals(actualurl, expectedurl);
		System.out.println("It is same as expected :) ");
	}
	
	
	
}
