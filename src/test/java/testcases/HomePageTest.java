package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.HomePage;

public class HomePageTest extends BaseClass {
	
	HomePage hp;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp(); snaps("HomePageTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test (groups = "Smoke")
	public void verifylogo() throws Throwable {
		hp= new HomePage();
		boolean result = hp.validateamazonlogo();
		Assert.assertTrue(result);
		
	}
	
	
}
