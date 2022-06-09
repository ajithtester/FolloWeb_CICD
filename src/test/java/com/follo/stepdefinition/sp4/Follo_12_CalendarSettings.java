package com.follo.stepdefinition.sp4;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_11_QueuedRequest;
import com.follo.module.method.F_12_CalendarSettings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_12_CalendarSettings extends Baseclass {
	
	
	@Given("User clicks settings button from the menu")
	public void user_clicks_settings_button_from_the_menu() throws Throwable {
		

		try {
			ReportConfig.ReportCreateFeatureTest("To verify the Calendar settings feature");
			ReportConfig.ReportCreateScenarioTest("To click settings button from the menu");

			Click("Settings", CalendarSettingsLocators);
			Wait(2000);
			ClickPageDown();
			if(IsElementDisplayed("CalendarSettings", CalendarSettingsLocators)){
				Print("Calendar settings button is displayed");
				ReportConfig.Givenlogpass("User clicks settings button from the menu","Calendar settings button is displayed");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not displayed");
			ReportConfig.Givenlogfail("User clicks settings button from the menu","Calendar settings button is not displayed because : " + e.getMessage());

		}
	   
	    
	}

	@And("User clicks Calendar settings button from the menu")
	public void user_clicks_calendar_settings_button_from_the_menu() throws Throwable {
		
		try {
			
			Click("CalendarSettings", CalendarSettingsLocators);
			Waitfortheelement("Calendar", CalendarSettingsLocators);
			if(IsElementDisplayed("Calendar", CalendarSettingsLocators)){
				
				Print("Calendar settings button is clicked");
				ReportConfig.Andlogpass("User clicks Calendar settings button from the menu","Calendar settings button is clicked");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not clicked");
			ReportConfig.Andlogfail("User clicks Calendar settings button from the menu","Calendar settings button is not clicked because : " + e.getMessage());

		}
	   
	    
	}

	@Given("User add new event in Calendar settings")
	public void user_add_new_event_in_calendar_settings() throws Throwable {
	   
		
		try {
			ReportConfig.ReportCreateScenarioTest("To add new event in Calendar settings");

			F_12_CalendarSettings.AddEvent();	
			ReportConfig.Givenlogpass("User add new event in Calendar settings","Calendar settings button is displayed");

		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add new event in Calendar settings","Calendar settings button is not displayed because : " + e.getMessage());

		}
	}
	
	@Given("User search and view the event from the calendar settings")
	public void user_search_and_view_the_event_from_the_calendar_settings() throws Throwable {

		
		try {
			ReportConfig.ReportCreateScenarioTest("To search a event in Calendar settings");
			F_12_CalendarSettings.SearchEvent();
			ReportConfig.Givenlogpass("User search and view the event from the calendar settings","Calendar settings button is displayed");


			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User search and view the event from the calendar settings","Calendar settings button is not displayed because : " + e.getMessage());

		}
	}
	
	@Given("User edit a event request from the calendar settings")
	public void user_edit_a_event_request_from_the_calendar_settings() throws Throwable {
		
	try {
		ReportConfig.ReportCreateScenarioTest("To edit a event in Calendar settings");
			F_12_CalendarSettings.EditEvent();
			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User edit a event request from the calendar settings","Event updated failed because : " + e.getMessage());

		}
	}
}
