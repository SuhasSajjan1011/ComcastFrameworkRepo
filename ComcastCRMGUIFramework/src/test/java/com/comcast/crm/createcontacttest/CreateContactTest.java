package com.comcast.crm.createcontacttest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.createcontactobjectrepository.ContactInfoPage;
import com.comcast.crm.createcontactobjectrepository.ContactPage;
import com.comcast.crm.objectrepositoryutility1.HomePage;

public class CreateContactTest extends Base {
	@Test
	public void createContactTest() throws Exception {
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
}
