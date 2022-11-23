package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPageActions extends LoginPageElements {

	public void launchApplication() {
		driver.get(ReadProp.readData("Config.properties", "URL"));
		log("pass", "Application Launched Successfully");
	}

	public void verifyLogo() {
		Assert.assertTrue(logo.isDisplayed());
		log("pass", "Application Logo Displayed Successfully");
	}
	
	public void verifyTitle() {
		Assert.assertEquals(getPageTitle(),ReadProp.readData("Config.properties", "title") );
		log("pass", "Application Title is as expected");
	}
	
	public void verifyCaption() {
		Assert.assertEquals(getElementText(caption),ReadProp.readData("Config.properties", "caption") );
		log("pass", "Application caption is as expected");
	}
	
	public void verifyLoginPageHeader() {
		Assert.assertEquals(getElementText(loginSectionHeader),ReadProp.readData("Config.properties", "loginHeader") );
		log("pass", "Application login header is as expected");
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		enterInfo(usernameTextbox, username);
		enterInfo(passwordTextbox, password);
		log("pass", "Updated user credentials successfully");
	}
	
	public void clickOnLoginButton() {
		clickOnElement(loginButton);
		log("pass", "Clicked on Login button successfully");
	}
	
	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewLinkLocator, 10);
		log("pass", "Clicked on Login button successfully");
	}
	
	public void getRegistrationPage() {
		clickOnElement(registerLink);
		log("pass", "Clicked on register Link successfully");
	}
	
	public void getForgotLoginInfoPage() {
		clickOnElement(forgotLoginLink);
		log("pass", "Clicked on forgot login info Link successfully");
	}

	public static LoginPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPageActions.class);
	}

}
