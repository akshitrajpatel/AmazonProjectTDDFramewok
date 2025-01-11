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
import pageobjects.ShoppingCart;
import pageobjects.SignInPage;

public class MyAccountTest extends BaseClass {
	HomePage hp; MyAccount account;
	SignInPage signin; IndexPage index;
	SearchResultPage searchpage;
	AddtoCart add2cart; ShoppingCart shoppingcart;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("MyAccountTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}

	@Test(groups = "Sanity")
	public void addnewaddressinmyaccount() throws Throwable {
		hp = new HomePage();index = new IndexPage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		add2cart = new AddtoCart(); 
		add2cart.clickonmenubtn();
		account = new MyAccount();
		account.clickonaddressbtn();
		account.clickonaddaddress();
		boolean result = account.validateaddnewaddresspage();
		Assert.assertTrue(result);
		
		boolean result1 = account.selectedcountry();
		Assert.assertTrue(result1);
		
		account.addnewaddress(prop.getProperty("Fullname"), prop.getProperty("PHnum"), 
				prop.getProperty("Address"), prop.getProperty("City"));
		
		account.selectprovience("Ontario");
		account.addpostalcode(prop.getProperty("PC"));
		
		account.submitnewaddress();
		account.clickoriginaladd();
		account.savenewadd();
		Thread.sleep(500);
		
	}
	
	@Test (groups = "Sanity")
	public void confirmnewaddressisadded() throws Throwable {
		hp = new HomePage();index = new IndexPage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		add2cart = new AddtoCart(); 
		add2cart.clickonmenubtn();
		account = new MyAccount();
		account.clickonaddressbtn();
		
		boolean outcome = account.cfmaddedaddpage();
		Assert.assertTrue(outcome);
		shoppingcart = new ShoppingCart();
		
		shoppingcart = account.clickoncart();
		
	}
	
}
