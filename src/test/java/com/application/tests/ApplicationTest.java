package com.application.tests;

import org.testng.annotations.Test;

import com.application.actions.AdminPageActions;
import com.application.actions.ForgotLoginInfoPageActions;
import com.application.actions.LoginPageActions;
import com.application.actions.RegistrationPageActions;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	
	LoginPageActions loginpage; 
	RegistrationPageActions regpage;
	ForgotLoginInfoPageActions forgotpage;
	
	@Test(priority=1, groups= {"Sanity"})
	public void verifyApplicationLogo() {
		loginpage =LoginPageActions.getActions();
		loginpage.launchApplication();
		loginpage.verifyLogo();
	}
	
	@Test(priority=2, groups= {"Smoke"})
	public void verifyApplicationTitle() {
		loginpage =LoginPageActions.getActions();
		loginpage.launchApplication();
		loginpage.verifyTitle();
	}
	
	@Test(priority=3, groups= {"Sanity"})
	public void verifyApplicationLoginPageHeader() {
		loginpage =LoginPageActions.getActions();
		loginpage.launchApplication();
		loginpage.verifyLoginPageHeader();
	}
	
	@Test(priority=4, groups= {"Sanity","Regression"})
	public void verifyApplicationCaption() {
		loginpage =LoginPageActions.getActions();
		loginpage.launchApplication();
		loginpage.verifyCaption();
	}
	
	@Test(priority=5, groups= {"Sanity","Regression"},dataProvider="testdata")
	public void verifyApplicationLogin(String username, String password) {
		loginpage =LoginPageActions.getActions();
		loginpage.launchApplication();
		loginpage.enterUsernameAndPassword(username, password);
		loginpage.clickOnLoginButton();
		loginpage.verifyLoginIsSuccessful();
	}
	
	@Test(priority=6, groups= {"Sanity"})
	public void verifyRegistrationPage() {
		loginpage =LoginPageActions.getActions();
		regpage = RegistrationPageActions.getActions();
		loginpage.launchApplication();
		loginpage.getRegistrationPage();
		regpage.verifyWhetherRegistrationPageisLaunched();
	}
	
	@Test(priority=7, groups= {"Sanity"})
	public void verifyRegistrationPageHeader() {
		loginpage =LoginPageActions.getActions();
		regpage = RegistrationPageActions.getActions();
		loginpage.launchApplication();
		loginpage.getRegistrationPage();
		regpage.verifyWhetherRegistrationPageisLaunched();
		regpage.verifyRegistrationPageHeader();
	}
	
	@Test(priority=8, groups= {"Sanity"})
	public void verifyForgotLoginPage() {
		loginpage =LoginPageActions.getActions();
		forgotpage = ForgotLoginInfoPageActions.getActions();
		loginpage.launchApplication();
		loginpage.getRegistrationPage();
		forgotpage.verifyWhetherRegistrationPageisLaunched();
	}
	
	@Test(priority=9, groups= {"Sanity"})
	public void verifyForgotLoginPageHeader() {
		loginpage =LoginPageActions.getActions();
		forgotpage = ForgotLoginInfoPageActions.getActions();
		loginpage.launchApplication();
		loginpage.getRegistrationPage();
		forgotpage.verifyWhetherRegistrationPageisLaunched();
		forgotpage.verifyRegistrationPageHeader();
	}

}
