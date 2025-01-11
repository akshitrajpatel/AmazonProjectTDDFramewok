package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Actionclass;
import basepackage.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]")WebElement productresult;
	@FindBy(id="title")WebElement title;
	@FindBy(id="productOverview_feature_div")WebElement productdetails;

	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void chooseproduct() throws Throwable {
		Actionclass.scrollDown(productresult);
		Thread.sleep(1500);
		Actionclass.click(driver, productresult);
	}
	
	public boolean producttitle() {
		return Actionclass.isEnabled(driver, title);

	}
	
	
	public AddtoCart reviewproductdetails() {
		Actionclass.isDisplayed(driver, productdetails);
		
		return new AddtoCart();
	}
	

}
