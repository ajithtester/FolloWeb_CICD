package com.follo.stepdefinition.sp3;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_09_Void;

import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_09_Void extends Baseclass {


	@Given("User clicks Void button")
	public void user_clicks_void_button() throws Throwable {

		try {
			Wait(5000);
			ReportConfig.ReportCreateFeatureTest("To verify the Void feature");
			ReportConfig.ReportCreateScenarioTest("To click void button from the menu");
			if(IsElementDisplayed("DeliveryCalendar", DFOWLocators)) {
				Click("DeliveryCalendar", DFOWLocators);

				ClickPageDown();

				Click("Settings", DFOWLocators);
				Print("Settings button is clicked");
			}
			ClickPageDown();
			Wait(2000);
			ClickPageDown();
	
			F_09_Void.VoidList();

			if(IsElementDisplayed("VoidList", VoidLocators)){
				Print("Void list button is displayed");
				Click("VoidList", VoidLocators);
				Print("Void list button is clicked");
				ReportConfig.Givenlogpass("User clicks Void button","Void list button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Void list button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User clicks Void button","Void list button is not clicked because : " + e.getMessage());

		}


	}

	@Given("User search and view the void request")
	public void user_search_and_view_the_void_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Search Void request");

			F_09_Void.SearchVoid();
			ReportConfig.Givenlogpass("User search and view the void request","Void request is searched successfully");
		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the void request","Void request searched failed because : " + e.getMessage());
		}

	}

	@Given("User filter void request")
	public void user_filter_void_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Filter Void request");

			F_09_Void.FilterVoid();
			ReportConfig.Givenlogpass("User filter void request","Void request is filtered successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter void request","Void request filter failed because : " + e.getMessage());
		}

	}
	
	@Given("User restore Void request")
	public void user_restore_void_request() throws Throwable {
	
		try {
			ReportConfig.ReportCreateScenarioTest("Restore Void request");

			F_09_Void.RestoreDelivery();
			ReportConfig.Givenlogpass("User filter void request","Void request is restored successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter void request","Void request is not restored successfully because : " + e.getMessage());
		}
		
	}
	
}
