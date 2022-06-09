package com.follo.stepdefinition.sp4;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_10_DeliveryRequest;

import io.cucumber.java.en.Given;
import report.ReportConfig;

public class Follo_10_DeliveryRequest extends Baseclass {

	@Given("User clicks All requests button from the menu")
	public void user_clicks_all_requests_button_from_the_menu() throws Throwable {

		try {

			Wait(3000);
			ReportConfig.ReportCreateFeatureTest("To verify the Delivery requests feature");
			ReportConfig.ReportCreateScenarioTest("To click All requests button from the menu");
			if(IsElementDisplayed("AllRequest", DeliveryRequestLocators)) {

				JsClick("AllRequest", DeliveryRequestLocators);
				Wait(2000);
				ClickPageDown();
				Print("All request button is clicked");
				ReportConfig.Givenlogpass("User clicks All requests button from the menu","All request button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("All request button is not clicked");
			ReportConfig.Givenlogfail("User clicks All requests button from the menu","All request button is clicked because : " + e.getMessage());
		}	    
	}

	@Given("User clicks Delivery requests button from the menu")
	public void user_clicks_delivery_requests_button_from_the_menu() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User clicks Delivery requests button from the menu");

			if(IsElementDisplayed("DeliveryRequestFromMenu", DeliveryRequestLocators)) {

				Click("DeliveryRequestFromMenu", DeliveryRequestLocators);
				Print("Delivery request button is clicked");
				ReportConfig.Givenlogpass("User clicks Delivery requests button from the menu","Delivery request button is clicked");	

			}
		} 
		catch (Exception e) {
			PrintError("Delivery request button is not clicked");
			ReportConfig.Givenlogfail("User clicks Delivery requests button from the menu","Delivery request button is not clicked because : " + e.getMessage());


		}
	}

	@Given("User add new delivery request")
	public void user_add_new_delivery_request() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User add new delivery request");
			F_10_DeliveryRequest.AddDeliverRequest();	
			ReportConfig.Givenlogpass("User add new delivery request","Delivery request added succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add new delivery request","Delivery request add failed because : " + e.getMessage());

		}

	}

	@Given("User search and view the delivery request from the list")
	public void user_search_and_view_the_delivery_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User search and view the delivery request from the list");
			F_10_DeliveryRequest.SearchRequest();	
			ReportConfig.Givenlogpass("User search and view the delivery request from the list","Delivery request searched succesfully");	



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the delivery request from the list","Delivery request search failed because : " + e.getMessage());

		}
	}

	@Given("User edit a delivery request from the list")
	public void user_edit_a_delivery_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("User edit a delivery request from the list");
			F_10_DeliveryRequest.EditRequest();	
			ReportConfig.Givenlogpass("User edit a delivery request from the list","Delivery request edited succesfully");	



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edit a delivery request from the list","Delivery request edit failed because : " + e.getMessage());

		}

	}

	@Given("User filter the delivery request from the list")
	public void user_filter_the_delivery_request_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To filter delivery request");

			F_10_DeliveryRequest.FilterRequest();	
			ReportConfig.Givenlogpass("User filter the delivery request from the list","Delivery request filtered succesfully");	
		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter the delivery request from the list","Delivery request filter failed because : " + e.getMessage());
		}

	}

	@Given("User view the request information")
	public void user_view_the_request_information() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view the request information");

			F_10_DeliveryRequest.ViewRequestInfo();	
			ReportConfig.Givenlogpass("User view the request information","Delivery request info viewed succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User view the request information","Delivery request info viewed failed because : " + e.getMessage());

		}


	}

	@Given("User add a comment to the request")
	public void user_add_a_comment_to_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add a comment to the request");
			F_10_DeliveryRequest.AddComment();
			ReportConfig.Givenlogpass("User add a comment to the request","User added a comment to the request succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add a comment to the request","Comment add failed because : " + e.getMessage());	
		}


	}

	@Given("User view the history of the request")
	public void user_view_the_history_of_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User view the history of the request");
			F_10_DeliveryRequest.ViewHistoryInfo();	
			ReportConfig.Givenlogpass("User view the history of the request","Delivery request history viewed succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User view the history of the request","Delivery request history view failed because : " + e.getMessage());	

		}


	}
	
	@Given("User add attachment to the deliver request")
	public void user_add_attachment_to_the_deliver_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User add attachment to the deliver request");
			F_10_DeliveryRequest.Attachment();	
			ReportConfig.Givenlogpass("User add attachment to the deliver request","Attachment added succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User add attachment to the deliver request","Attachment add failed because : " + e.getMessage());	

		}
		
	}
	
	

	@Given("User deliver the request")
	public void user_deliver_the_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User deliver the request");

			F_10_DeliveryRequest.Deliver();	
			ReportConfig.Givenlogpass("User deliver the request","Delivery request delivered succesfully");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User deliver the request","Delivery request deliver failed because : " + e.getMessage());	

		}


	}

	@Given("User approve or reject the delivery request")
	public void user_approve_or_reject_the_delivery_request() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User approve or reject the delivery request");

			F_10_DeliveryRequest.ApproveOrReject();	
			ReportConfig.Givenlogpass("User approve or reject the delivery request","Delivery request ApproveOrReject is successfull");	

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User approve or reject the delivery request","Delivery request ApproveOrReject is failed because : " + e.getMessage());	

		}

	}

	@Given("User push a request to void")
	public void user_push_a_request_to_void() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("User push a request to void");
			F_10_DeliveryRequest.PushToVoid();	
			ReportConfig.Givenlogpass("User push a request to void","User pushed a request to void successfully");	



		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User push a request to void","User pushed a request to void failed because : " + e.getMessage());	

		}
	}

}
