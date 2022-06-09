package com.follo.stepdefinition.sp1;

import com.follo.baseclass.Baseclass;
import com.follo.browser.launch.BrowserLaunch;
import com.follo.module.method.*;
import com.follo.excel.read.ReadFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_02_Login extends Baseclass {



	@Given("User launching the webapp url")
	public void user_launching_the_webapp_url() throws Throwable {


		try {

		//	ReportConfig.Reports();
			ReportConfig.ReportCreateFeatureTest("To verify the Login feature");
			ReportConfig.ReportCreateScenarioTest("Launch the app URL and navigate to login page");

			BrowserLaunch.LaunchTheAppURL("URL", AppProperties);

			String ActualTitle =	PageTitle();		
			String ExpectedTitle =	PropertyFile("PageTitle", AppProperties);
Print(ActualTitle);
Print(ExpectedTitle);
			if(IsEqual(ActualTitle, ExpectedTitle)) {

				
				ReportConfig.Givenlogpass("User launching the web url","Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched successfully");

				Print("Page title is : " + PropertyFile("URL", AppProperties) + ": Application launched successfully");
				
			}
			else {
				
				ReportConfig.Givenlogfail("User launching the web url","Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched failed");

				PrintError("Page title is : " + PropertyFile("URL", AppProperties) + ": Application launched failed");

			}

		} 

		catch (Exception e) {
			
			ReportConfig.Givenlogfail("User launching the web url","Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched failed");

			Print("Page title is : " + PropertyFile("URL", AppProperties) + ": Application launched failed");
		}

	}






	@And("User clicks the Login button")
	public void user_clicks_the_login_button() throws Throwable {


		try {
			
			Wait(3000);
			if(IsElementDisplayed("LoginButton", LoginPageLocators)) {

				Click("LoginButton", LoginPageLocators);

				
				ReportConfig.Andlogpass("User clicks the Login button","Login button in homepage is clicked");

				Print("Login button in homepage is clicked");

			}

		} catch (Exception e) {

			Print(e.getMessage());
			
			ReportConfig.Andlogfail("User clicks the Login button","Login button in homepage is not clicked");
			PrintError("Login button in homepage is not clicked");

		}


	}

	@Then("User should see login page")
	public void user_should_see_login_page() throws Throwable {

		try {
			

			Wait(2000);

			if(IsElementDisplayed("Email", LoginPageLocators)) {

				
				ReportConfig.Thenlogpass("User should see login page","Login page is displayed");

				Print("Login page is displayed");

			}

			else {

				
				ReportConfig.Thenlogfail("User should see login page","Login page is not displayed");

				PrintError("Login page is not displayed");

			}
		} 

		catch (Exception e) {

			
			ReportConfig.Thenlogfail("User should see login page","Login page is not displayed");

			PrintError("Login page is not displayed");

		}


	}

	@Given("User enter mail Id and password")
	public void user_enter_mail_id_and_password() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User logging in with valid credentials");

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , ReadFrom.Login));
			String email = ReadFrom.Excel(0, 1 , ReadFrom.Login);
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));
			ReportConfig.PassedLogInfo("Entered mailid is : ", email);


			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 1 , "Login"));
			String Password = ReadFrom.Excel(1, 1 , ReadFrom.Login);
			Print("Password is selected as : " + ReadFrom.Excel(1, 1 , "Login"));
			ReportConfig.PassedLogInfo("Entered Password is : ", Password);


		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");
			
			ReportConfig.Givenlogfail("User enter mail Id and password","Email and Mobile number is not filled");
			PrintError(e.getMessage());

		}

	}


	@And("User clicks the signin button")
	public void user_clicks_the_signin_button() throws Throwable {

		try {
			
			Wait(3000);
			
			Click("LoginButton", LoginPageLocators);
			ReportConfig.Andlogpass("User clicks the Login button","Login button is clicked");

			Print("Login button is clicked");


		} catch (Exception e) {

			Print(e.getMessage());
			
			ReportConfig.Andlogfail("User clicks the Login button","Login button is not clicked");
			PrintError("Login button is not clicked");

		}


	}



	@Then("User should see the login success message")
	public void user_should_see_the_login_success_message() throws Throwable {



		try {
			

			F_02_Login.Loginsucces();

			if(IsElementDisplayed("LoginSuccess", LoginPageLocators)) {
				Print("Dashboard is displayed : Login passed");

				
				ReportConfig.Thenlogpass("User should see the login success message","HomePage is displayed : Login passed");
			}
			else {
				Print("Dashboard is not displayed ");

				
				ReportConfig.Thenlogfail("User should see the login success message","HomePage is not displayed ");
			}

		} 	

		catch (Exception e) {
			
			ReportConfig.Thenlogfail("User should see the login success message","Dashboard is not displayed ");


		}


	}

	@Given("User clicks forgot password")
	public void user_clicks_forgot_password() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User opts for forgot password link");
			if(IsElementDisplayed("ForgotPassword", LoginPageLocators)) {
				Click("ForgotPassword", LoginPageLocators);
				Print("Forgot password is dispayed and it is clicked");

				
				ReportConfig.Givenlogpass("User clicks forgot password","Forgot password is dispayed and it is clicked");
			}

		} 

		catch (Exception e) {

			PrintError("Forgot password is not clicked");
			
			ReportConfig.Givenlogfail("User clicks forgot password","Forgot password is not clicked");


		}

	}

	@And("User enters mailId in the email feild")
	public void user_enters_mail_id_in_the_email_feild() throws Throwable {

		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , ReadFrom.Login));
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));
			ReportConfig.PassedLogInfo("EmailId is entered as : " , ReadFrom.Excel(0, 1 , "Login"));
			
			ReportConfig.Andlogpass("User enters mailId in the email feild","Mail id is entered");

		} 
		catch (Exception e) {

			PrintError("EmailId is not entered");
			
			ReportConfig.Andlogfail("User clicks forgot password","EmailId is not entered");



		}


	}

	@And("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Throwable {


		try {
			if(IsElementDisplayed("SubmitButton", LoginPageLocators)) {
				Click("SubmitButton", LoginPageLocators);
				Print("SubmitButton button is clicked");


				
				ReportConfig.Andlogpass("User clicks the submit button","SubmitButton button is clicked");

			}
		} catch (Exception e) {
			PrintError("SubmitButton button is not clicked");


			
			ReportConfig.Andlogfail("User clicks the submit button","SubmitButton button is not clicked");

		}

	}

	@Then("User should success message")
	public void user_should_success_message() throws Throwable {

		try {
			WaitForTheElement("MailSentMessage", LoginPageLocators);
			if(IsElementDisplayed("MailSentMessage", LoginPageLocators)) {
				Click("MailSentMessage", LoginPageLocators);
				Print("Mail sent popup is dispayed");


				
				ReportConfig.Thenlogpass("User should success message","Mail sent popup is dispayed");
			}

		} 

		catch (Exception e) {

			PrintError("Mail sent popup is not dispayed");
			
			ReportConfig.Thenlogfail("User should success message","Mail sent popup is not dispayed");




		}


	}




}
