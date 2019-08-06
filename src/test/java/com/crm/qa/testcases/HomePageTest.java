package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage(); 
		contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePagetitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRM","Home Page title did not match");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException {
		contactsPage= homePage.clickOnContacts();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	 
}
