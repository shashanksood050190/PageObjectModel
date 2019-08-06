package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="Contacts";

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage(); 
		//contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContacts();
	}
	
//	@Test(priority=1)
//	public void verifyContactPageLable()
//	{
//		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing");
//	}
//	
//	@Test(priority=2)
//	public void selectContactTest()
//	{
//		contactsPage.selectContactsByName("test");
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest()
//	{
//		contactsPage.selectContactsByName("test test");
//		contactsPage.selectContactsByName("test1 test1");
//	}
	
	@DataProvider()
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName,String lastName,String company) throws IOException
	{
		homePage.clickOnContacts();
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
