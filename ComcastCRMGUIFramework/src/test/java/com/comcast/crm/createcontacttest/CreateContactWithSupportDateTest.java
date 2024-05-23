package com.comcast.crm.createcontacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.createcontactobjectrepository.ContactInfoPage;
import com.comcast.crm.createcontactobjectrepository.ContactPage;
import com.comcast.crm.createcontactobjectrepository.CreateContactWithSupportDate;
import com.comcast.crm.createcontactobjectrepository.HomePage;

public class CreateContactWithSupportDateTest extends Base {

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
