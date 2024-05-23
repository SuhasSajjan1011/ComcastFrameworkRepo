package com.comcast.crm.createorgwithPhnoObjrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgWithPhNo{
	
	WebDriver d;
	public CreateNewOrgWithPhNo(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phnNoEdt;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getPhnNoEdt() {
		return phnNoEdt;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrgWithPhn(String orgName,String phnNo)
	{
	orgNameEdt.sendKeys(orgName);
	phnNoEdt.sendKeys(phnNo);
	}
	
	

	
	      

}
