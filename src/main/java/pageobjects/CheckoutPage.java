package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class CheckoutPage extends BaseClass {
	
	@FindBy(id="nav-cart")WebElement checkoutcart;

	@FindBy(id="shipToThisAddressButton")WebElement clickshiptothisaddress;
	
	@FindBy(id="spc-order-summary")WebElement ordersummary;
	@FindBy(xpath="/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[2]/"
			+ "table/tbody/tr[1]/td[1]")WebElement items;
	@FindBy(xpath="/html/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[2]/"
			+ "div/div/div/div[2]/table/tbody/tr[9]")WebElement totalamt;
	
	@FindBy(xpath="//*[@id=\"banner-image\"]")WebElement clickamazon;
	@FindBy(css="#a-popover-content-2 > div:nth-child(2) > div:nth-child(2)")WebElement selectreturntocart;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/"
			+ "div[3]/div[1]/span[3]/span/input")WebElement saveforlater;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncart() {
		Actionclass.click(driver, checkoutcart);
	}
	
	
	public void clickship() {
		Actionclass.implicitWait(driver, 150);
		Actionclass.click(driver, clickshiptothisaddress);
	}
	
	public boolean seeordersummary() {
		Actionclass.implicitWait(driver, 50);
		return Actionclass.isDisplayed(driver, ordersummary);
	}
	
	public String getitem() {
		Actionclass.implicitWait(driver, 30);
		String Totalitems = items.getText();
		return  Totalitems;}
	
	
	public String getamt() {
		Actionclass.implicitWait(driver, 30);
		String TotalPrice= totalamt.getText();
		return TotalPrice;
	}

	public void clickonamazon() {
		Actionclass.implicitWait(driver, 30);
		Actionclass.click(driver, clickamazon);
	}

	public void clickreturntocart() {
		Actionclass.implicitWait(driver, 20);
	 Actionclass.click(driver, selectreturntocart);
	}
	
	public void clickonsaveforlater() {
		Actionclass.implicitWait(driver, 30);
		Actionclass.click(driver, saveforlater);
	}
	
}
