package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class SignInPage extends BaseClass{
	
	@FindBy(id="ap_email")WebElement signin;
	@FindBy(id="continue")WebElement continuebtn;
	@FindBy(id="ap_password")WebElement password;
	@FindBy(id="signInSubmit")WebElement submitbtn;
	//@FindBy(name="rememberMe")WebElement remebermechkbox;

	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email) {
		Actionclass.type(signin, email);
		Actionclass.click(driver, continuebtn);
	}
	
	public IndexPage pw(String pswd) throws Throwable {
		Actionclass.type(password, pswd);
		//Actionclass.click(driver, remebermechkbox);
		Thread.sleep(500);
		Actionclass.click(driver, submitbtn);
		Thread.sleep(500);
		return new IndexPage();
	}
}
