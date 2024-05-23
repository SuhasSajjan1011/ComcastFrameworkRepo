package com.comcast.createcontactmaintest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.createcontactobjectrepository.ContactInfoPage;
import com.comcast.crm.createcontactobjectrepository.ContactPage;
import com.comcast.crm.createcontactobjectrepository.CreateContactWithSupportDate;
import com.comcast.crm.objectrepositoryutility1.HomePage;

public class CreateContactMainTest extends Base {
	@Test
	public void createContactTest() throws Exception
	{
		
		HomePage hp = new HomePage(d);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(d);
		cp.getCreateContactImg().click();

		String lastName = eLib.readDataFromExcel("Sheet1", 7, 4) + jLib.getRandomNumber();

		cp.getContactLastNameEdt().sendKeys(lastName);

		cp.getContactSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(d);
		String actContactHeaderInfo = cip.getContactHeaderInfo().getText();

		if (actContactHeaderInfo.contains(lastName)) {
			System.out.println(lastName + " is  verified");
		} else {
			System.err.println(lastName + " mismatching");
		}
		
		
		
		

	}

	@Test
	public void CreateContactWithSupportDateTest() throws Exception {
		HomePage hp = new HomePage(d);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(d);
		cp.getCreateContactImg().click();
		String lastName = eLib.readDataFromExcel("Sheet1", 7, 4) + jLib.getRandomNumber();
		CreateContactWithSupportDate cwsd = new CreateContactWithSupportDate(d);
		cp.getContactLastNameEdt().sendKeys(lastName);
		cwsd.contactWithDate();
		cp.getContactSaveBtn().click();
		ContactInfoPage cip = new ContactInfoPage(d);
		String actHeaderInfo = cip.getContactHeaderInfo().getText();
		if (actHeaderInfo.contains(lastName)) {
			System.out.println(lastName + " verified successfully");
		} else {
			System.err.println(lastName + " verification failed");
		}
	}

}
