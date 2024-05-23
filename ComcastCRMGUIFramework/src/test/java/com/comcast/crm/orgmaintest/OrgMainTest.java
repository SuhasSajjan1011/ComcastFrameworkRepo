package com.comcast.crm.orgmaintest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.createorgwithPhnoObjrepository.CreateNewOrgWithPhNo;
import com.comcast.crm.createorgwithPhnoObjrepository.OrgPhnNoInfoPage;
import com.comcast.crm.createorgwithdropdownobjectrepository.CreateNewOrganisationPageWithIndustry;
import com.comcast.crm.createorgwithdropdownobjectrepository.HomePage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrgInfoPage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrganisationPage;
import com.comcast.crm.objectrepositoryutility1.CreateNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility1.OrganisationInfoPage;

public class OrgMainTest extends BaseClass {
	
	
	@Test
	public void createOrgTest() throws Exception
	{
		
		
		String orgName=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		HomePage hp= new HomePage(d);
		hp.getOrgLnk().click();
		
		com.comcast.crm.objectrepositoryutility1.OrganisationPage op= new com.comcast.crm.objectrepositoryutility1.OrganisationPage(d);
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

	
	@Test
	public void createOrgWithIndusTest() throws Exception {
		String orgName = eLib.readDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(d);
		hp.getOrgLnk().click();

		OrganisationPage op = new OrganisationPage(d);
		op.getCreateNewOrgImg().click();

		String industryValue = eLib.readDataFromExcel("Sheet1", 4, 8);
		String type = eLib.readDataFromExcel("Sheet1",4,9);

		CreateNewOrganisationPageWithIndustry cwi = new CreateNewOrganisationPageWithIndustry(d);
		cwi.getOrgNameEdt().sendKeys(orgName);
		cwi.selectIndustryDropDown(industryValue);
		cwi.selectTypeDropDown(type);
		cwi.getSaveBtn().click();
		Thread.sleep(3000);

		OrgInfoPage oip = new OrgInfoPage(d);
		String actOrgInfo = oip.getOrgHeaderInfo().getText();

		if (actOrgInfo.contains(orgName)) {
			System.out.println(orgName + " verified successfully");
		} else {
			System.err.println(orgName + " verification failed");
			Assert.fail();
		}

		String actIndustryValue = oip.getIndustryHeaderInfo().getText();
		if (actIndustryValue.equals(industryValue)) {
			System.out.println(industryValue + " verified successfully");
		} else {
			System.err.println(industryValue + " mismatching");
			Assert.fail();
		}

		String actType = oip.getTypeHeaderInfo().getText();
		if (actType.trim().equals(type)) {
			System.out.println(type + " verified successfully");
		} else {
			System.err.println(type + " mismatching");
			Assert.fail();
		}


}
	@Test
	public void createOrgWithPhnNoTest() throws Exception
	{
	   
	   HomePage hp = new HomePage(d);
	   hp.getOrgLnk().click();
	   
	   String orgName=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
	   
	   OrganisationPage op = new OrganisationPage(d);
	   op.getCreateNewOrgImg().click();
	   String phnNo = eLib.readDataFromExcel("Sheet1", 1, 4);
	   
	   CreateNewOrgWithPhNo cop= new CreateNewOrgWithPhNo(d);
	   cop.createOrgWithPhn(orgName, phnNo);
	   cop.getSaveBtn().click();
	   
	   OrgPhnNoInfoPage oip= new OrgPhnNoInfoPage(d);
	   
	   String actOrgName=oip.getOrgHeaderInfo().getText();
	   if(actOrgName.contains(orgName))
	   {
		   System.out.println(orgName+ " is verified successfully");
	   }else
	   {
		   System.err.println(orgName+ " mismatching");
		   Assert.fail();
	   }
	   
	   String actPhnNo=oip.getPhnCheckInfo().getText();
	   if(actPhnNo.trim().equals(phnNo))
	   {
		   System.out.println(phnNo+ " is verified successfully");  
	   }else
	   {
		   System.err.println(phnNo+ " mismatching");
		   Assert.fail();
	   }
	   
	  
	   }
	
	
	
	}
