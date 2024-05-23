package com.comcast.crm.objectrepositoryutility1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganisationPage {
	WebDriver d;

	public CreateNewOrganisationPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industrydd;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgName)/// only for create organization name
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}

	public void createOrg(String orgName, String industry)// create organization name and select industry from dropdown
	{
		orgNameEdt.sendKeys(orgName);
		Select sel1 = new Select(industrydd);
		sel1.selectByVisibleText(industry);
		saveBtn.click();
	}

}
