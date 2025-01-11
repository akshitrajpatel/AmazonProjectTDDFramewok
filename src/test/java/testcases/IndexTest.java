package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SearchResultPage;
import pageobjects.SignInPage;

public class IndexTest extends BaseClass{
	HomePage hp;
	SignInPage signin;
	IndexPage index;
	SearchResultPage searchpage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("IndexTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test (groups = "Smoke")
	public void clickonuracct() throws Throwable {
		index = new IndexPage();
		hp = new HomePage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		Thread.sleep(500);
		index.movehovertosignin();
		Boolean result = index.clickonurorder();
		Assert.assertTrue(result);
	
	}
	
	@Test(groups = "Sanity")
	public void selecteachorderoptions() throws Throwable {
		index = new IndexPage(); hp = new HomePage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		index.movehovertosignin();
		index.clickonurorder(); 
		Boolean result1 =index.clickonorderhistory();
		Assert.assertTrue(result1);
		index.eachorderoptions();
		searchpage = index.searchproduct(prop.getProperty("ProductName"));
	}
	
	
	
	

}
