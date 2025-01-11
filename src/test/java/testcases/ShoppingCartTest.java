package testcases;

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

public class ShoppingCartTest extends BaseClass {
	HomePage hp; MyAccount account;
	SignInPage signin; IndexPage index;
	SearchResultPage searchpage;
	AddtoCart add2cart; ShoppingCart shoppingcart;
	CheckoutPage checkout;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("ShoppingCartTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void openshoppingcart() throws Throwable {
		hp = new HomePage();index = new IndexPage();
		account = new MyAccount();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
		shoppingcart = new ShoppingCart();
		shoppingcart = account.clickoncart();
		Thread.sleep(500);
		String result = shoppingcart.confirmitemincart();
		System.out.println(result);
		
		String display = shoppingcart.checkproductqty();
		System.out.println(display);
		
		String newqty = shoppingcart.changeprdqty("1");
		System.out.println("QTY: " + newqty);
		
		checkout = shoppingcart.clickproccedtocheckout();
	
	}


}
