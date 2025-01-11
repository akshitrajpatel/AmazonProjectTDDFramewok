package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.AddtoCart;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SearchResultPage;
import pageobjects.SignInPage;

public class SRPTest extends BaseClass {
	HomePage hp;
	SignInPage signin;
	IndexPage index;
	SearchResultPage searchpage;
	AddtoCart add2cart;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("SRPTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test (groups = "Sanity")
	public void verifysearchbar() throws Throwable {
		hp = new HomePage();
		boolean result = hp.seesearchtab();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void opensearchproduct() throws Throwable {
		hp = new HomePage();index = new IndexPage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		index.searchproduct(prop.getProperty("ProductName"));
		Thread.sleep(1500); searchpage = new SearchResultPage();
		searchpage.chooseproduct();
		Thread.sleep(500);
	    boolean result = searchpage.producttitle();
	    Assert.assertTrue(result);
	  add2cart=searchpage.reviewproductdetails();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
