package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.AddtoCart;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.MyAccount;
import pageobjects.SearchResultPage;
import pageobjects.ShoppingCart;
import pageobjects.SignInPage;

public class EndtoEndTest extends BaseClass {
	HomePage hp; MyAccount account;
	SignInPage signin; IndexPage index;
	SearchResultPage searchpage;
	AddtoCart add2cart; ShoppingCart shoppingcart;
	CheckoutPage checkout;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp(); snaps("EndtoEndTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = "Regression")
	public void End2EndTest() throws Throwable {
		hp = new HomePage();index = new IndexPage();
		account = new MyAccount();signin = hp.clickonsignin();
		searchpage = new SearchResultPage();add2cart = new AddtoCart();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		index.searchproduct(prop.getProperty("ProductName"));
		searchpage.chooseproduct();
		add2cart.enterquantity("1");
		add2cart.clickonaddtocart();
		Thread.sleep(500);
		add2cart.clickonnowarrenty();
		shoppingcart = new ShoppingCart();
		shoppingcart.clickproccedtocheckout();
		checkout = new CheckoutPage();
		Thread.sleep(500);
		checkout.clickship();
		boolean result = checkout.seeordersummary();
		Assert.assertTrue(result);
		
		String totalitem = checkout.getitem();
		System.out.println(totalitem);
		
		String totalprice = checkout.getamt();
		System.out.println(totalprice);
		
		checkout.clickonamazon();
		checkout.clickreturntocart();
		checkout.clickonsaveforlater();
		hp.clickhomepage();
		System.out.println("!!End to End Testing Completed!!");
		
		
	}
	
	
	
}
