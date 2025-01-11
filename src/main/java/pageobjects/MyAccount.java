package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class MyAccount extends BaseClass {

	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]")WebElement youraddressbtn;
	@FindBy(id="ya-myab-plus-address-icon")WebElement addaddress;
	@FindBy(id="address-ui-widgets-reload-url")WebElement addnewaddresspage;
	@FindBy(id="address-ui-widgets-countryCode")WebElement country;
	@FindBy(id="address-ui-widgets-enterAddressFullName")WebElement fullname;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")WebElement phonenumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")WebElement enteraddress;
	@FindBy(id="address-ui-widgets-enterAddressCity")WebElement entercity;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")WebElement provience;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")WebElement postalcode;
	@FindBy(id="address-ui-widgets-form-submit-button")WebElement submitaddress;
	@FindBy(id="address-ui-widgets-original-address-block_id")WebElement originaladd;
	@FindBy(id="a-autoid-9")WebElement saveadd;
	@FindBy(id="ya-myab-display-address-block-0")WebElement cfmpage;
	@FindBy(xpath="//*[@id=\"nav-cart\"]")WebElement cartoption;
	
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonaddressbtn() {
		Actionclass.click(driver, youraddressbtn);
	}
	
	public void clickonaddaddress() {
		Actionclass.click(driver, addaddress);
	}
	
	public boolean validateaddnewaddresspage() {
		Actionclass.implicitWait(driver, 20);
		return Actionclass.isEnabled(driver, addnewaddresspage);
	}
	
	public boolean selectedcountry() {
		return Actionclass.isDisplayed(driver, country);
	}
	
	public void addnewaddress(String name, String phnum, String add, String city) {
		Actionclass.implicitWait(driver, 50);
		Actionclass.selectBySendkeys(name, fullname);
		Actionclass.selectBySendkeys(phnum, phonenumber);
		Actionclass.selectBySendkeys(add, enteraddress);
		Actionclass.selectBySendkeys(city, entercity);
	}
	
	public void selectprovience(String pro) {
		Actionclass.click(driver, provience);
		Actionclass.fluentWait(driver, provience, 50);
		Actionclass.selectByValue(provience, pro);
	}
	
	public void addpostalcode(String code) {
		Actionclass.implicitWait(driver,50);
		Actionclass.selectBySendkeys(code, postalcode);
		System.out.println("The address was added successfully");
		
	}
	
	public void submitnewaddress() {
		Actionclass.click(driver, submitaddress);
	}
	
	public void clickoriginaladd() {
		Actionclass.implicitWait(driver,50);
		Actionclass.click(driver, originaladd);
	}
	
	public void savenewadd() {
		Actionclass.implicitWait(driver,50);
		Actionclass.click(driver, saveadd);
	}
	
	public boolean cfmaddedaddpage() {
		Actionclass.implicitWait(driver,50);
		return Actionclass.isDisplayed(driver, cfmpage);
	}
	
	public ShoppingCart clickoncart() {
		Actionclass.click(driver, cartoption);
		return new ShoppingCart();
	}
}

