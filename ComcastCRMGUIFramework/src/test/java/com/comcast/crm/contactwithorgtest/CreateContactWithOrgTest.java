package com.comcast.crm.contactwithorgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.contactwithorgobjectrepository.ContactChildWindowPage;
import com.comcast.crm.contactwithorgobjectrepository.ContactPage;
import com.comcast.crm.contactwithorgobjectrepository.CreateNewContactPage;
import com.comcast.crm.contactwithorgobjectrepository.OrgPage;
import com.comcast.crm.createcontactobjectrepository.HomePage;
import com.comcast.crm.objectrepositoryutility1.CreateNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility1.OrganisationPage;

public class CreateContactWithOrgTest extends Base
{
	@Test
	public void createContactWithOrgTest() throws Exception
	{
	String orgName=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
	HomePage hp = new HomePage(d);
	hp.getOrgLink().click();
	
	OrganisationPage op= new OrganisationPage(d);
	op.getCreateOrgButton().click();
	
	CreateNewOrganisationPage cnop= new CreateNewOrganisationPage(d);
	cnop.getOrgNameEdt().sendKeys(orgName);
	Thread.sleep(3000);
	
	
   cnop.getSaveBtn().click();
	
	Thread.sleep(3000);
	
	OrgPage op1= new OrgPage(d);
	op1.getContactLink().click();
	//hp.getContactLink().click();
	String lastName=eLib.readDataFromExcel("Sheet1", 7, 4)+jLib.getRandomNumber();
	
	
	ContactPage cp = new ContactPage(d);
	cp.getCreateContactImg().click();
	CreateNewContactPage cncp = new CreateNewContactPage(d);
	cncp.getLastNameEdt().sendKeys(lastName);
	
	cncp.getCreateOrgImg().click();
	
	wLib.switchToTabOnTitle(d,"Accounts&action");
	
	ContactChildWindowPage cwp= new ContactChildWindowPage(d);
		
	cwp.getOrgNameSearch().sendKeys(orgName);
	
	cwp.getSearchBtn().click();
	
	d.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
	
	
		
		
	}

}
