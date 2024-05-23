package com.comcast.crm.createorgmaintest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility1.CreateNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility1.HomePage;
import com.comcast.crm.objectrepositoryutility1.OrganisationInfoPage;
import com.comcast.crm.objectrepositoryutility1.OrganisationPage;

public class CreateOrgMainTest extends BaseClass{
	@Test
	public void createOrgTest() throws Exception
	{
		
		String orgName=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		HomePage hp= new HomePage(d);
		hp.getOrgLink().click();
		
		OrganisationPage op= new OrganisationPage(d);
		op.getCreateOrgButton().click();
		
		
		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(d);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();
		
		OrganisationInfoPage oip=  new OrganisationInfoPage(d);
		String actHeaderInfo=oip.getHeaderInfo().getText();
		
		if(actHeaderInfo.contains(orgName))
		{
			System.out.println(orgName+ " verified successfully");
		}else
		{
			System.out.println(orgName+ " verification failed");
		}
		
	}

}
