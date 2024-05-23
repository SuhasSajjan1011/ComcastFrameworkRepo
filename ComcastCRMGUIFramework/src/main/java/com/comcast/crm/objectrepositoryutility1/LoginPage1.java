package com.comcast.crm.objectrepositoryutility1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage1 {
	WebDriver d  ;
	public LoginPage1(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	@FindBy(name="user_name")
    private WebElement usernameEdt;

    @FindBy(name="user_password")
     private WebElement passwordEdt;

    
    @FindBy(id="submitButton")
     private WebElement loginBtn;
    
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
   public void loginToApp(String Username,String Password) {
	   d.manage().window().maximize();
	   usernameEdt.sendKeys(Username);
	   passwordEdt.sendKeys(Password);
	   loginBtn.click();
   }
}
