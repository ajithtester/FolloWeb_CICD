package com.follo.stepdefinition.sp2;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_06_Gate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import report.ReportConfig;

public class Follo_06_Gate extends Baseclass{


	@Given("User clicks gate button")
	public void user_clicks_gate_button() throws Throwable {

		try {

			ReportConfig.ReportCreateFeatureTest("To verify the gate feature");
			ReportConfig.ReportCreateScenarioTest("To click gate button from the menu");
			if(IsElementDisplayed("GatesButton", GateLocators)){
				Print("Gates button is displayed");
				Click("GatesButton", GateLocators);
				Print("Gates button is clicked");
				ReportConfig.Givenlogpass("User clicks gate button","Gates button is clicked");
			

			}
		} 
		catch (Exception e) {
			PrintError("Gates button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User clicks gate button","Gates button is not clicked because : " + e.getMessage());
		}


	}


	@Given("User adds new gate")
	public void user_adds_new_gate() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To add gates");

			F_06_Gate.AddGate();
			ReportConfig.Givenlogpass("User adds new gate","Gates are added successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User adds new gate","Gates are not added because : " + e.getMessage());
		}

	}


	@Given("User edit a gate from the list")
	public void user_edit_a_gate_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("To edit gates");
			F_06_Gate.EditGate();
			ReportConfig.Givenlogpass("User edit a gate from the list","Gates are edited successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edit a gate from the list","Gates are not edited because : " + e.getMessage());
		}
		

	}
	
	@Given("User delete a gate from the list")
	public void user_delete_a_gate_from_the_list() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("To delete gates");
			F_06_Gate.DeleteGate();
			ReportConfig.Givenlogpass("User delete a gate from the list","Gates are deleted successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User delete a gate from the list","Gates are not deleted because : " + e.getMessage());	 
		}
	}
	
	@Given("User select all gates")
	public void user_select_all_gates() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("Delete all gates from the list");
			Wait(2000);
			if(IsElementDisplayed("SelectAll", GateLocators)){
				
				Click("SelectAll", GateLocators);


				Print("All gates are selected");
				ReportConfig.Givenlogpass("User select all gates","All gates are selected");
			}
		} catch (Exception e) {
			PrintError("All gates are not selected");
			ReportConfig.Givenlogfail("User select all gates","All gates are not selected because : " + e.getMessage());
		
		}
	    
	}

	@When("User clicks remove button and click yes from the delete popup")
	public void user_clicks_remove_button_and_click_yes_from_the_delete_popup() throws Throwable {
	 
		try {
			if(IsElementDisplayed("RemoveButton", GateLocators)){
				Click("RemoveButton", GateLocators);
				Print("Remove button is clicked");
				
				Wait(2000);
				Click("YesDelete", GateLocators);


				Print("Yes button is clicked");
				ReportConfig.Whenlogpass("User clicks remove button and click yes from the delete popup","Detele button is clicked");
			}
		} catch (Exception e) {
			PrintError("Detele button is not clicked");
			ReportConfig.Whenlogfail("User clicks remove button and click yes from the delete popup","Detele button is not clicked because : " + e.getMessage());



		}
	}

	@Then("All the gates should be deleted")
	public void all_the_gates_should_be_deleted() throws Throwable {
		
		try {

			if(IsElementDisplayed("NoRecordFound", GateLocators)) {
				Print("No record found is dispayed : All gates are deleted");
				ReportConfig.Thenlogpass("All the gates should be deleted","No record found is dispayed : All gates are deleted");
			}

		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All gates are not deleted");
			ReportConfig.Thenlogfail("All the gates should be deleted","No record found is not dispayed : All gates are not deleted because : " + e.getMessage());


		}

	   
	}
	
	@Given("User search and view the gates")
	public void user_search_and_view_the_gates() throws Throwable {
		
		try {
			ReportConfig.ReportCreateScenarioTest("Search gate");
			F_06_Gate.SearchGates();
			ReportConfig.Givenlogpass("User search and view the gates","Gates are searched successfilly");


		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the gates","Gates are not searched because : " + e.getMessage());

		}
	  
	}

}
