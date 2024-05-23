package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClassTest;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.createorgwithdropdownobjectrepository.CreateNewOrganisationPageWithIndustry;
import com.comcast.crm.createorgwithdropdownobjectrepository.HomePage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrgInfoPage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrganisationPage;

public class CreateOrgWithIndustryTest extends BaseClass {

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

}
