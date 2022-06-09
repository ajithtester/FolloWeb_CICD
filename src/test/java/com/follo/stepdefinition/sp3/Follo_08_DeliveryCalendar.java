package com.follo.stepdefinition.sp3;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_08_DeliveryCalendar;
import com.follo.module.method.F_13_CraneCalender;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_08_DeliveryCalendar extends Baseclass {

	@Given("User clicks delivery calendar button")
	public void user_clicks_delivery_calendar_button() throws Throwable {

		try {

			ReportConfig.ReportCreateFeatureTest("To verify the calendar feature");
			ReportConfig.ReportCreateScenarioTest("To click delivery calendar button from the menu");
		//	Click("DFOW", DFOWLocators);

			// ClickPageUp();

			if(IsElementDisplayed("DeliveryCalendar", DeliveryCalendarLocators)){
				Print("Delivery calendar button is displayed");
				Click("DeliveryCalendar", DeliveryCalendarLocators);
				Print("Delivery calendar button is clicked");
				ReportConfig.Givenlogpass("User clicks delivery calendar button","Delivery calendar button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Delivery calendar button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User clicks delivery calendar button","Delivery calendar button is not clicked because : " + e.getMessage());

		}

	}

	@Given("User adds new delivery")
	public void user_adds_new_delivery() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To add delivery");
			F_08_DeliveryCalendar.Adddelivery();
			ReportConfig.Givenlogpass("User adds new delivery","Delivery calendar added successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User adds new delivery","Delivery calendar not added because : " + e.getMessage());
		}
	}

	@Given("User search and view the delivery request")
	public void user_search_and_view_the_delivery_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Search delivery request");

			F_08_DeliveryCalendar.SearchDelivery();
			ReportConfig.Givenlogpass("User search and view the delivery request","Delivery calendar searched successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the delivery request","Delivery calendar not searched because : " + e.getMessage());
		}
	}


	@Given("User edit a delivery request")
	public void user_edit_a_delivery_request() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Edit a delivery request");

			F_08_DeliveryCalendar.EditDelivery();
			ReportConfig.Givenlogpass("User edit a delivery request","Delivery calendar edited successfully");


		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edit a delivery request","Delivery calendar not edited because : " + e.getMessage());
		}
	}


	@Given("User filter the delivery request based on company name")
	public void user_filter_the_delivery_request_based_on_company_name() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Filter a delivery request");

			F_08_DeliveryCalendar.FilterDelivery();
			ReportConfig.Givenlogpass("User filter the delivery request based on company name","Delivery calendar filtered successfully");


		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter the delivery request based on company name","Delivery calendar not filtered because : " + e.getMessage());
		}
	}

	@Given("User view the request info")
	public void user_view_the_request_info() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view and delivers the request");

			//F_08_DeliveryCalendar.ViewDeliveryInfo();
			ReportConfig.Givenlogpass("User view the request info","Delivery calendar info viewed successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User view the request info","Delivery calendar info not viewed because : " + e.getMessage());
		}
	}

	@And("User add a comment")
	public void user_add_a_comment() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add a comment");

			F_08_DeliveryCalendar.AddComment();
			ReportConfig.Andlogpass("User add a comment","User add a comment successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Andlogfail("User add a comment","Comment not added because : " + e.getMessage());
		}

	}

	@And("User view history")
	public void user_view_history() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view and delivers the request");

			F_08_DeliveryCalendar.ViewHistory();
			ReportConfig.Andlogpass("User view history","History viewed successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Andlogfail("User view history","History not viewed because : " + e.getMessage());
		}

	}

	@Then("User delivers the request")
	public void user_delivers_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User delivers the request");

			F_08_DeliveryCalendar.Deliver();
			ReportConfig.Thenlogpass("User delivers the request","Request delivers successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Thenlogfail("User delivers the request","Request not delivers because : " + e.getMessage());
		}

	}

	@Given("User approve or reject the request")
	public void user_approve_or_reject_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view and approve or reject the request");

			F_08_DeliveryCalendar.ApproveOrReject();
			ReportConfig.Givenlogpass("User approve or reject the request","User approve or reject the request successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User approve or reject the request","Approve or reject failed because : " + e.getMessage());
		}
	}


	@Given("User push a delivery request to void")
	public void user_push_a_delivery_request_to_void() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Push a delivery request to void");

			F_08_DeliveryCalendar.PushToVoid();
			ReportConfig.Givenlogpass("User push a delivery request to void","Request pushed to void successfully");


		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User push a delivery request to void","Request pushed to void failed because : " + e.getMessage());
		}

	}
	
	@Given("User add attachment to the delivery calendar request")
	public void user_add_attachment_to_the_delivery_calendar_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add attachment to the delivery calendar request");
			F_08_DeliveryCalendar.AddAttcahment();
			ReportConfig.Givenlogpass("User add attachment to the delivery delivery request", "Attcahment added successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ReportConfig.Givenlogfail("User add attachment to the delivery calendar request", "Attcahment add failed because : " + e.getMessage());

		}
	}
}
