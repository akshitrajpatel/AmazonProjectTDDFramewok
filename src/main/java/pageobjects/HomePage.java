package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actionDriver.Actionclass;
import basepackage.BaseClass;

public class HomePage extends BaseClass {
	

	
	@FindBy(id="nav-logo")WebElement amazonlogo;
	@FindBy(id="twotabsearchtextbox")WebElement searchbar;
	@FindBy(xpath="//a[@id=\"nav-link-accountList\"]")WebElement signinbtn;
	@FindBy(id="nav-flyout-ya-signin")WebElement click;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateamazonlogo()throws Throwable {
		return Actionclass.isDisplayed(driver, amazonlogo);
	}
	
	public void clickhomepage() {
		Actionclass.click(driver, amazonlogo);
	}
	
	public boolean seesearchtab()throws Throwable {
		return Actionclass.isEnabled(driver, searchbar);
	}
	
	
	public SignInPage clickonsignin() throws Throwable{
		Actionclass.click(driver, signinbtn);
		
		//Actions action = new Actions(driver);
		//action.moveToElement(signinbtn).click(signinbtn).build().perform();
		
		return new SignInPage();
	}

		
	
}
