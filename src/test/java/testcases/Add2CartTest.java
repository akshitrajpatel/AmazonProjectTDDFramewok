package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.AddtoCart;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.MyAccount;
import pageobjects.SearchResultPage;
import pageobjects.SignInPage;

public class Add2CartTest extends BaseClass {
	HomePage hp; MyAccount account;
	SignInPage signin; IndexPage index;
	SearchResultPage searchpage;
	AddtoCart add2cart;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("Add2CartTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test (groups = {"Smoke","Regression"})
	
	public void addproducttocart() throws Throwable {
		
		hp = new HomePage();index = new IndexPage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		index.searchproduct(prop.getProperty("ProductName"));
		Thread.sleep(500); searchpage = new SearchResultPage();
		searchpage.chooseproduct();
		add2cart = new AddtoCart();
		add2cart.enterquantity("2");
		add2cart.clickonaddtocart();
		Thread.sleep(500);
		add2cart.clickonnowarrenty();
		Thread.sleep(500);
		boolean result = add2cart.confirmadded();
		Assert.assertTrue(result);
		System.out.println("Assert :" + result  + 
				" = The product is added to cart successfully!!");
		
		account = add2cart.clickonmenubtn();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
