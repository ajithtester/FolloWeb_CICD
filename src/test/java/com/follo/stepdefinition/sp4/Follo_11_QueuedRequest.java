package com.follo.stepdefinition.sp4;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_11_QueuedRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_11_QueuedRequest extends Baseclass{


	@Given("User clicks queued requests button from the menu")
	public void user_clicks_queued_requests_button_from_the_menu() throws Throwable {


		try {
			ReportConfig.ReportCreateFeatureTest("To verify the queued requests feature");
			ReportConfig.ReportCreateScenarioTest("To click queued requests button from the menu");
			Waitfortheelement("QueuedDelivery", QueuedRequestLocators);
			if(IsElementDisplayed("QueuedDelivery", QueuedRequestLocators)) {

				Click("QueuedDelivery", QueuedRequestLocators);
				Print("Queued delivery button is clicked");
				ReportConfig.Givenlogpass("User clicks queued requests button from the menu","Queued delivery button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Queued delivery button is not clicked");
			ReportConfig.Givenlogfail("User clicks queued requests button from the menu","Queued delivery button is not clicked because : " + e.getMessage());
		}
	}

	@Given("User clicks queued request import button")
	public void user_clicks_queued_request_import_button() throws Throwable {
		ReportConfig.ReportCreateScenarioTest("Import Queued Request list");


	}

	@Then("Queued request list from the excel should get added")
	public void queued_request_list_from_the_excel_should_get_added() {


	}

	@Given("User edit a queued request from the list")
	public void user_edit_a_queued_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Edit a queued request from the list");
			F_11_QueuedRequest.EditQueuedRequest();
			ReportConfig.Givenlogpass("User edit a queued request from the list","Queued delivery is edited successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User edit a queued request from the list","Queued delivery edit failed because : " + e.getMessage());

		}
	}

	@Given("User save a queued request from the list")
	public void user_save_a_queued_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Save a queued request from the list");
			F_11_QueuedRequest.SaveQueuedRequest();
			ReportConfig.Givenlogpass("User save a queued request from the list","Queued delivery is saved successfully");		
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User save a queued request from the list","Queued delivery save failed because : " + e.getMessage());

		}

	}


	@Given("User deletes a queued request from the list")
	public void user_deletes_a_queued_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Delete a queued request from the list");

			F_11_QueuedRequest.DeleteRequest();
			ReportConfig.Givenlogpass("User deletes a queued request from the list","Queued delivery is deleted successfully");		



		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User deletes a queued request from the list","Queued delivery delete failed because : " + e.getMessage());

		}

	}

	@Given("User search and view the queued request from the list")
	public void user_search_and_view_the_queued_request_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Search a queued request from the list");

			F_11_QueuedRequest.SearchQueuedRequest();
			ReportConfig.Givenlogpass("User search and view the queued request from the list","Queued delivery is searched successfully");		

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User search and view the queued request from the list","Queued delivery search failed because : " + e.getMessage());

		}


	}

	@Given("User filter the queued request from the list")
	public void user_filter_the_queued_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Filter a queued request from the list");

			F_11_QueuedRequest.FilterQueuedRequest();
			ReportConfig.Givenlogpass("User filter the queued request from the list","Queued delivery is filtered successfully");		



		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User filter the queued request from the list","Queued delivery filter failed because : " + e.getMessage());

		}


	}

}
