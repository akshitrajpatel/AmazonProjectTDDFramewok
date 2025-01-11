package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class AddtoCart extends BaseClass {
	
	@FindBy(id="quantity")WebElement quantity;
	@FindBy(id="submit.add-to-cart")WebElement add2cartbtn;
	@FindBy(id="attachSiNoCoverage")WebElement nowarrenty;
	@FindBy(css="#sw-atc-details-single-container")WebElement added2cartconfirm;
	@FindBy(id="nav-link-accountList")WebElement uracct;
	
	public AddtoCart() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterquantity(String qty) {
		Actionclass.selectByVisibleText(qty, quantity);
	}

	public void clickonaddtocart() {
		Actionclass.explicitWait(driver, add2cartbtn, Duration.ofSeconds(50));
		Actionclass.click(driver, add2cartbtn);
	}
	
	public void clickonnowarrenty() {
		Actionclass.explicitWait(driver, add2cartbtn, Duration.ofSeconds(100));
		Actionclass.click(driver, nowarrenty);
	}
	
	public boolean confirmadded() {
	return Actionclass.isDisplayed(driver, added2cartconfirm);
	}
	
	public MyAccount clickonmenubtn() {
		Actionclass.fluentWait(driver, uracct, 20);
		Actionclass.click(driver, uracct);
		return new MyAccount();
	}
	 
}
