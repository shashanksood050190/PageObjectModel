package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {

	

	//PageFactory -OR:
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")
	WebElement loginbtn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement submitBtn;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[1]/a")
	WebElement signUpBtn;

	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a")
	WebElement crmLogo;
	
	//Initializing page objects
	
	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws IOException
	{
		loginbtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		return new HomePage();
	}

	

	
}
