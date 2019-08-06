package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement contactsLabel;
	
	@FindBy(name = "first_name")
	WebElement firstName;

	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']/input[@class='search']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		
		driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td/div[@class='ui fitted read-only checkbox']")).click();
	}

	public void createNewContact(String ftName,String ltName,String comp)
	{
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
