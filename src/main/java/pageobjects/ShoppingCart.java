package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class ShoppingCart extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"sc-active-Ca4cbe7cc-3e80-4cb7-890d-11ff544c1554\"]/div[4]")WebElement itemconfirmation;
	@FindBy(id="a-autoid-1")WebElement productqty;
	@FindBy(id="quantity")WebElement qtybtn;
	@FindBy(id="sc-buy-box-ptc-button")WebElement proceedtochkout;

	
	
	
	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}

	public String confirmitemincart() {
		Actionclass.fluentWait(driver, itemconfirmation, 150);
		String name = itemconfirmation.getText();
		return name;
	}
	
	public String checkproductqty() {
		Actionclass.implicitWait(driver, 20);
		String quantity = productqty.getText();
		return quantity;
	}
	
	public String changeprdqty(String qty) {
		Actionclass.selectByVisibleText(qty, qtybtn);
		Actionclass.implicitWait(driver, 20);
		return qty;
	}
	
	public CheckoutPage clickproccedtocheckout() {
		Actionclass.implicitWait(driver, 30);
		Actionclass.click(driver, proceedtochkout);
		return new CheckoutPage();
	}
	
	
}
