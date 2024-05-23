package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganisationPageWithIndustry {

	WebDriver d;

	public CreateNewOrganisationPageWithIndustry(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);

	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public void selectIndustryDropDown(String industryValue) throws Exception {
		WebDriverUtility wLib = new WebDriverUtility();

		//ExcelUtility eLib = new ExcelUtility();
		//String industryValue =eLib.readDataFromExcel("Sheet1",4,8);
		 
		wLib.select(industryDropDown,industryValue);

	}
	
	public void selectTypeDropDown(String type) throws Exception {
		WebDriverUtility wLib = new WebDriverUtility();
		
		//ExcelUtility eLib = new ExcelUtility();
		//String type =eLib.readDataFromExcel("Sheet1",4,9);
		wLib.select(typeDropDown, type);

	}
	

}
