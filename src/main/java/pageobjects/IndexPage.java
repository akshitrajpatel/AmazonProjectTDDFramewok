package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@id=\"nav-link-accountList\"]")WebElement signinopt;
	@FindBy(xpath="//*[@id=\"a-page\"]/div[1]/div/ul[1]/li[1]/span/a/div")WebElement urorders;
	@FindBy(xpath="/html/body/div[1]/section/div/div[3]/ul")WebElement orderoptions;
	@FindBy(id="a-autoid-1-announce")WebElement orderhistory;
	@FindBy(xpath="/html/body/div[1]/section/div/div[3]/ul/li[2]")WebElement buyagainopt;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div[3]/ul/li[4]/span")WebElement ntytshippedopt;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[4]/div/ul/li[5]")WebElement cancelledopt;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/div")WebElement remebermechkbox;
	@FindBy(id="nav-search")WebElement searchbar;
	@FindBy(id="twotabsearchtextbox")WebElement searchbox;
	@FindBy(id="nav-search-submit-button")WebElement searchbtn;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getcurrurl() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public void movehovertosignin() throws Throwable {
		Actionclass.click(driver, signinopt);
		Thread.sleep(1500);
	}
	
	public boolean clickonurorder()throws Throwable {
		Actionclass.click(driver, urorders);
		Thread.sleep(1500);
		return Actionclass.isDisplayed(driver, orderoptions);
	}
	
	public boolean clickonorderhistory() {
		return Actionclass.isEnabled(driver, orderhistory);
	}
	
	public void eachorderoptions() throws Throwable {
		Actionclass.click(driver, orderhistory);
		Actionclass.click(driver, buyagainopt);
		Thread.sleep(500);
		Actionclass.click(driver, ntytshippedopt);
		Thread.sleep(500);
		Actionclass.click(driver, cancelledopt);
		System.out.println("All the options are clickable");
	}
	
	public SearchResultPage searchproduct(String ProductName) {
		Actionclass.mouseOverElement(driver, searchbar);
		Actionclass.type(searchbox, ProductName);
		Actionclass.click(driver, searchbtn);
		return new SearchResultPage();
	}
	
	
}
