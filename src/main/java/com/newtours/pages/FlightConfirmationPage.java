package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//font[contains(text(),'Confirmation')]")
	private WebElement flightConfirmationtext;
	
	@FindBy(xpath="//font[contains(text(),'USD')]")
	private List<WebElement> prices;
	
	@FindBy(linkText="SIGN-OFF")
	private WebElement signOff;
	
	public FlightConfirmationPage(WebDriver driver) {
		
		this.driver= driver;
		this.wait= new WebDriverWait(this.driver,10);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(this.driver, this);
	}
	
	public String printConfirmation()
	{
		wait.until(ExpectedConditions.visibilityOf(flightConfirmationtext));
		System.out.println("Confirmation--->"+flightConfirmationtext.getText());
		System.out.println("Prices---->"+prices.get(1).getText());
		String price=prices.get(1).getText();
		signOff.click();
		return price;
	}

}
