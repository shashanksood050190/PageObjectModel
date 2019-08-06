package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	

	@FindBy(xpath="//*[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a")
	WebElement newContactLink;
	
	@FindBy(xpath="//*[@id='main-nav']/a[6]")
	WebElement tasksLink;
	
	@FindBy(xpath="//*[@id='main-nav']/a[5]")
	WebElement dealsLink;
	
	//initializing page objects
	
	public HomePage() throws IOException {
	
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() throws IOException
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUsername()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		newContactLink.click();
	}
}
