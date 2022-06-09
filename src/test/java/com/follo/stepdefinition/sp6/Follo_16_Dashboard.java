package com.follo.stepdefinition.sp6;

import java.io.IOException;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_04_Companies;
import com.follo.module.method.F_16_Dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_16_Dashboard extends Baseclass {
	String CountFromDashboard;
	String CountFromList;

	@Given("User clicks dashboard")
	public void user_clicks_dashboard() throws Throwable, IOException {

		try {

			Wait(3000);
			ReportConfig.ReportCreateFeatureTest("To verify the Dashboard");
			ReportConfig.ReportCreateScenarioTest("To redirect to delivery request page from dashboard");
			if(IsElementDisplayed("Dashboard", DashboardLocators)) {

				JsClick("Dashboard", DashboardLocators);
				Print("Dashboard button is clicked");
				ReportConfig.Givenlogpass("User clicks dashboard","Dashboard button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Dashboard button is not clicked");
			ReportConfig.Givenlogfail("User clicks dashboard","Dashboard button is not clicked because : " + e.getMessage());
		}	    
	}

	@And("User Clicks no of delivers")
	public void user_clicks_no_of_delivers() throws Throwable {

		try {
			Wait(3000);
			Waitfortheelement("NoOfDeliveries", DashboardLocators);
			if(IsElementDisplayed("NoOfDeliveries", DashboardLocators)) {

				JsClick("NoOfDeliveries", DashboardLocators);
				Print("No Of Deliveries button is clicked");
				ReportConfig.Andlogpass("User Clicks no of delivers","No Of Deliveries button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("No Of Deliveries button is not clicked");
			ReportConfig.Andlogfail("User Clicks no of delivers","No Of Deliveries button is not clicked because : " + e.getMessage());
		}
	}

	@Then("User should be redirected to deliver request")
	public void user_should_be_redirected_to_deliver_request() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("DeliveryRequestPage", DashboardLocators)) {

				Print("Delivery request page is displayed");
				ReportConfig.Thenlogpass("User should be redirected to deliver request","Delivery request page is displayed");
			}
		} 
		catch (Exception e) {
			PrintError("Delivery request page is not displayed");
			ReportConfig.Thenlogfail("User should be redirected to deliver request","Delivery request page is not displayed because : " + e.getMessage());
		}
	}

	@Given("User clicks dashboard from deliver request page")
	public void user_clicks_dashboard_from_deliver_request_page() throws Throwable { 

		try {

			Wait(3000);
			ReportConfig.ReportCreateScenarioTest("To redirect to company page from dashboard");
			if(IsElementDisplayed("Dashboard", DashboardLocators)) {

				JsClick("Dashboard", DashboardLocators);
				Print("Dashboard button is clicked");
				ReportConfig.Givenlogpass("User clicks dashboard from deliver request page","Dashboard button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Dashboard button is not clicked");
			ReportConfig.Givenlogfail("User clicks dashboard from deliver request page","Dashboard button is not clicked because : " + e.getMessage());
		}

	}

	@And("User Clicks no of companies")
	public void user_clicks_no_of_companies() throws Throwable {

		try {
			Wait(3000);
			Waitfortheelement("NoOfCompanies", DashboardLocators);
			if(IsElementDisplayed("NoOfCompanies", DashboardLocators)) {

				JsClick("NoOfCompanies", DashboardLocators);
				Print("No Of Companies button is clicked");
				ReportConfig.Andlogpass("User Clicks no of Companies","No Of Companies button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("No Of Companies button is not clicked");
			ReportConfig.Andlogfail("User Clicks no of Companies","No Of Companies button is not clicked because : " + e.getMessage());
		}


	}

	@Then("User should be redirected to companies")
	public void user_should_be_redirected_to_companies() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("CompanyPage", DashboardLocators)) {

				Print("Company page is displayed");
				ReportConfig.Thenlogpass("User should be redirected to companies page","Company page is displayed");
			}
		} 
		catch (Exception e) {
			PrintError("Company page is not displayed");
			ReportConfig.Thenlogfail("User should be redirected to companies page","Company page is not displayed because : " + e.getMessage());
		}

	}

	@Given("User clicks dashboard from companies page")
	public void user_clicks_dashboard_from_companies_page() throws Throwable { 

		try {

			Wait(3000);
			ReportConfig.ReportCreateScenarioTest("To redirect to members page from dashboard");
			if(IsElementDisplayed("Dashboard", DashboardLocators)) {

				JsClick("Dashboard", DashboardLocators);
				Print("Dashboard button is clicked");
				ReportConfig.Givenlogpass("User clicks dashboard from companies page","Dashboard button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Dashboard button is not clicked");
			ReportConfig.Givenlogfail("User clicks dashboard from companies page","Dashboard button is not clicked because : " + e.getMessage());
		}

	}

	@And("User Clicks no of members")
	public void user_clicks_no_of_members() throws Throwable, IOException {

		try {
			Wait(3000);
			Waitfortheelement("NoOfMembers", DashboardLocators);
			if(IsElementDisplayed("NoOfMembers", DashboardLocators)) {

				JsClick("NoOfMembers", DashboardLocators);
				Print("No Of Members button is clicked");
				ReportConfig.Andlogpass("User Clicks no of Members","No Of Members button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("No Of Members button is not clicked");
			ReportConfig.Andlogfail("User Clicks no of Members","No Of Members button is not clicked because : " + e.getMessage());
		}


	}

	@Then("User should be redirected to members")
	public void user_should_be_redirected_to_members() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("MemberPage", DashboardLocators)) {

				Print("Member page is displayed");
				ReportConfig.Thenlogpass("User should be redirected to Member page","Member page is displayed");
			}
		} 
		catch (Exception e) {
			PrintError("Member page is not displayed");
			ReportConfig.Thenlogfail("User should be redirected to Member page","Member page is not displayed because : " + e.getMessage());
		}


	}

	@Given("User clicks dashboard from members page")
	public void user_clicks_dashboard_from_members_page() throws Throwable {
		try {

			Wait(3000);
			ReportConfig.ReportCreateScenarioTest("To redirect to equipment page from dashboard");
			if(IsElementDisplayed("Dashboard", DashboardLocators)) {

				JsClick("Dashboard", DashboardLocators);
				Print("Dashboard button is clicked");
				ReportConfig.Givenlogpass("User clicks dashboard from Member page","Dashboard button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Dashboard button is not clicked");
			ReportConfig.Givenlogfail("User clicks dashboard from Member page","Dashboard button is not clicked because : " + e.getMessage());
		}
	}

	@And("User Clicks no of equipment")
	public void user_clicks_no_of_equipment() throws Throwable {

		try {
			Wait(3000);
			Waitfortheelement("NoOfEquipments", DashboardLocators);
			if(IsElementDisplayed("NoOfEquipments", DashboardLocators)) {

				JsClick("NoOfEquipments", DashboardLocators);
				Print("No Of Equipments button is clicked");
				ReportConfig.Andlogpass("User Clicks no of Equipments","No Of Equipments button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("No Of Equipments button is not clicked");
			ReportConfig.Andlogfail("User Clicks no of Equipments","No Of Equipments button is not clicked because : " + e.getMessage());
		}
	}

	@Then("User should be redirected to equipment")
	public void user_should_be_redirected_to_equipment() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("EquipmentPage", DashboardLocators)) {

				Print("Equipment page is displayed");
				ReportConfig.Thenlogpass("User should be redirected to Equipment page","Equipment page is displayed");
			}
		} 
		catch (Exception e) {
			PrintError("Equipment page is not displayed");
			ReportConfig.Thenlogfail("User should be redirected to Equipment page","Equipment page is not displayed because : " + e.getMessage());
		}

	}

	@Given("User click Dashboard")
	public void user_click_dashboard() throws Throwable {

		try {

			Wait(3000);
			ReportConfig.ReportCreateScenarioTest("To click dashboard");
			if(IsElementDisplayed("Dashboard", DashboardLocators)) {

				JsClick("Dashboard", DashboardLocators);
				Print("Dashboard button is clicked");
				ReportConfig.Givenlogpass("User clicks dashboard","Dashboard button is clicked");
			}
		} 
		catch (Exception e) {
			PrintError("Dashboard button is not clicked");
			ReportConfig.Givenlogfail("User clicks dashboard","Dashboard button is not clicked because : " + e.getMessage());
		}

	}

	@Then("User validate the no of deliveries")
	public void user_validate_the_no_of_deliveries() throws Throwable  {


		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of deliveries");

			Wait(3000);
			Waitfortheelement("DeliveryCount", DashboardLocators);
			CountFromDashboard = GetText("DeliveryCount", DashboardLocators);

			JsClick("NoOfDeliveries", DashboardLocators);

			Wait(3000);
			Waitfortheelement("DeliveryRequestList", DashboardLocators);

			int Count  = 	SizeOfTheList("DeliveryRequestList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of deliveries",("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of deliveries",("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of deliveries",("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList));

		}


	}

	@Given("User validate the no of companies")
	public void user_validate_the_no_of_companies() throws Throwable, IOException {


		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of companies");

			Wait(3000);
			Waitfortheelement("CompanyCount", DashboardLocators);
			CountFromDashboard = GetText("CompanyCount", DashboardLocators);

			JsClick("NoOfCompanies", DashboardLocators);

			Wait(3000);
			Waitfortheelement("CompanyList", DashboardLocators);

			int Count  = 	SizeOfTheList("CompanyList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of Companies : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of companies",("Dashboard value : " + CountFromDashboard + " , No of Companies : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of companies",("Dashboard value : " + CountFromDashboard + " , No of Companies : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of companies",("Dashboard value : " + CountFromDashboard + " , No of companies : " + CountFromList));

		}


	}

	@Given("User validate the no of members")
	public void user_validate_the_no_of_members() throws Throwable, IOException {

		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of members");


			Wait(3000);
			Waitfortheelement("MemberCount", DashboardLocators);
			CountFromDashboard = GetText("MemberCount", DashboardLocators);

			JsClick("NoOfMembers", DashboardLocators);

			Wait(3000);
			Waitfortheelement("MemberList", DashboardLocators);

			int Count  = 	SizeOfTheList("MemberList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of Companies : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of members",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of requests : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of members",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of members",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));

		}
	}

	@Given("User validate the no of equipment")
	public void user_validate_the_no_of_equipment() throws Throwable, IOException {



		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of equipments");


			Wait(3000);
			Waitfortheelement("EquipmentCount", DashboardLocators);
			CountFromDashboard = GetText("EquipmentCount", DashboardLocators);

			JsClick("NoOfEquipments", DashboardLocators);

			Wait(3000);
			Waitfortheelement("EquipmentList", DashboardLocators);

			int Count  = 	SizeOfTheList("EquipmentList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of equipments : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of equipments",("Dashboard value : " + CountFromDashboard + " , No of equipments : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of equipments : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of equipments",("Dashboard value : " + CountFromDashboard + " , No of equipments : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of equipments",("Dashboard value : " + CountFromDashboard + " , No of equipments : " + CountFromList));

		}
	}


	@Given("User adds a request")
	public void user_adds_a_request() throws Throwable {

		try {

			Wait(2000);
			F_16_Dashboard.AddRequest();
			ReportConfig.Givenlogpass("User adds a request to the list","Request added successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User adds a request to the list","Request add failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}


	@Then("User adds a company")
	public void user_adds_a_company() throws Throwable {

		try {

			Wait(2000);

			F_16_Dashboard.AddCompany();
			ReportConfig.Givenlogpass("User adds a Company to the list","Company added successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User adds a Company to the list","Company add failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}
	}

	@Then("User adds a members")
	public void user_adds_a_members() throws Throwable {

		try {

			//Wait(2000);
			//	JsClick("NoOfMembers", DashboardLocators);
			Wait(2000);
			Click("InviteMembers", DashboardLocators);

			F_16_Dashboard.AddMembers();
			F_16_Dashboard.SelectCompany();
			Wait(2000);
			Click("SendInvitesButton", DashboardLocators);
			ReportConfig.Givenlogpass("User adds a members to the list","Members added successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User adds a members to the list","Members add failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Then("User adds a equipment")
	public void user_adds_a_equipment() throws Throwable {

		try {

			Wait(2000);

			F_16_Dashboard.AddEquipment();
			ReportConfig.Givenlogpass("User adds a Company to the list","Company added successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User adds a Company to the list","Company add failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}


	@Then("validate the no of deliveries")
	public void validate_the_no_of_deliveries() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of deliveries");

			Wait(3000);
			Waitfortheelement("DeliveryRequestList", DashboardLocators);

			int Count  = 	SizeOfTheList("DeliveryRequestList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			Wait(3000);

			JsClick("Dashboard", DashboardLocators);

			Wait(3000);
			Waitfortheelement("DeliveryCount", DashboardLocators);

			CountFromDashboard = GetText("DeliveryCount", DashboardLocators);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of deliveries in the list : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of deliveries in the list",("Dashboard value : " + CountFromDashboard + " , No of deliveries in the list : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of deliveries in the list : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of deliveries in the list",("Dashboard value : " + CountFromDashboard + " , No of deliveries in the list : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of deliveries in the list",("Dashboard value : " + CountFromDashboard + " , No of deliveries in the list : " + CountFromList));

		}



	}

	@Given("User deletes a company")
	public void user_deletes_a_company() throws Throwable {

		try {

			Wait(2000);
			JsClick("NoOfCompanies", DashboardLocators);
			Wait(2000);
			F_16_Dashboard.DeleteCompany();
			ReportConfig.Givenlogpass("User deletes a Company from the list","Company deleted successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User deletes a Company from the list","Company deleted failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}


	@Then("validate the no of companies")
	public void validate_the_no_of_companies() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To Validate the no of companies");

			Wait(3000);
			Waitfortheelement("CompanyList", DashboardLocators);

			int Count  = 	SizeOfTheList("CompanyList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			Wait(3000);

			JsClick("Dashboard", DashboardLocators);

			Wait(3000);
			Waitfortheelement("CompanyCount", DashboardLocators);

			CountFromDashboard = GetText("CompanyCount", DashboardLocators);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of companies in the list : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of companies in the list",("Dashboard value : " + CountFromDashboard + " , No of companies in the list : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of companies in the list : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of companies in the list",("Dashboard value : " + CountFromDashboard + " , No of companies in the list : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of companies in the list",("Dashboard value : " + CountFromDashboard + " , No of companies in the list : " + CountFromList));

		}

	}

	@Given("User deletes a members")
	public void user_deletes_a_members() throws Throwable {

		try {
			Wait(2000);
			JsClick("NoOfMembers", DashboardLocators);
			Wait(2000);
			F_16_Dashboard.DeleteMembers();
			ReportConfig.Givenlogpass("User deletes a member from the list","Members deleted successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User deletes a members from the list","Members deleted failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Then("validate the no of members")
	public void validate_the_no_of_members() throws Throwable {

		try {

			Wait(4000);
			Waitfortheelement("MemberList", DashboardLocators);

			int Count  = 	SizeOfTheList("MemberList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			Wait(3000);

			JsClick("Dashboard", DashboardLocators);

			Wait(3000);
			Waitfortheelement("MemberCount", DashboardLocators);
			CountFromDashboard = GetText("MemberCount", DashboardLocators);

			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of members in the list : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of members in the list",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of members in the list : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of members in the list",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of members in the list",("Dashboard value : " + CountFromDashboard + " , No of members : " + CountFromList));

		}
	}


	@Given("User deletes a equipment")
	public void user_deletes_a_equipment() throws Throwable {

		try {

			Wait(2000);
			JsClick("NoOfEquipments", DashboardLocators);
			Wait(2000);
			F_16_Dashboard.DeleteEquipment();
			ReportConfig.Givenlogpass("User deletes a equipment from the list","Equipment deleted successsfully");

		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User deletes a equipment from the list","Equipment deleted failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Then("validate the no of equipment")
	public void validate_the_no_of_equipment() throws Throwable {


		try {

			Wait(4000);
			Waitfortheelement("EquipmentList", DashboardLocators);

			int Count  = 	SizeOfTheList("EquipmentList", DashboardLocators);
			CountFromList =Integer.toString(Count);

			Wait(3000);

			JsClick("Dashboard", DashboardLocators);

			Wait(3000);
			Waitfortheelement("EquipmentCount", DashboardLocators);
			CountFromDashboard = GetText("EquipmentCount", DashboardLocators);
			if(IsEqual(CountFromDashboard, CountFromList)) {
				Print("Dashboard value : " + CountFromDashboard + " , No of equipment in the list : " + CountFromList);
				ReportConfig.Givenlogpass("User validate the no of equipment in the list",("Dashboard value : " + CountFromDashboard + " , No of equipment : " + CountFromList));
			}
			else {
				PrintError("Dashboard value : " + CountFromDashboard + " , No of equipment in the list : " + CountFromList);
				ReportConfig.Givenlogfail("User validate the no of equipment in the list",("Dashboard value : " + CountFromDashboard + " , No of equipment : " + CountFromList));
			}
		} catch (Throwable e) {
			Print(e.getMessage());
			ReportConfig.Givenlogfail("User validate the no of equipment in the list",("Dashboard value : " + CountFromDashboard + " , No of equipment : " + CountFromList));

		}

	}


	@Given("User validate the upcoming list")
	public void user_validate_the_upcoming_list() throws Throwable {

		try {

			Wait(2000);
			ReportConfig.ReportCreateScenarioTest("To Validate the upcoming list");

			int UpcomingList = 	SizeOfTheList("UpcomingList", DashboardLocators);
			Print("No of request listed are : " + UpcomingList);
			if(UpcomingList==10) {

			
				ReportConfig.Givenlogpass("User validate the upcoming list","No of request listed are : " + UpcomingList);
				try {
					if(IsElementDisplayed("Bluetruck", DashboardLocators)) {
						int Bluetruck = 	SizeOfTheList("Bluetruck", DashboardLocators);

						Print("No of delivery request " + Bluetruck);
						ReportConfig.Givenlogpass("User validate the upcoming list","No of delivery request " + Bluetruck);
					}
				}
				catch (Exception e) {

					Print("Delivery request is not present in the upcoming list");
					ReportConfig.Givenlogpass("User validate the upcoming list","Delivery request is not present in the upcoming list");
				}

				try {
					if(IsElementDisplayed("Cranelift", DashboardLocators)) {

						int Cranelift = 	SizeOfTheList("Cranelift", DashboardLocators);
						Print("No of Crane request " + Cranelift);
						ReportConfig.Givenlogpass("User validate the upcoming list","No of Crane request " + Cranelift);

					}
				}
				catch (Exception e){
					Print("Crane request is not present in the upcoming list");
					ReportConfig.Givenlogpass("User validate the upcoming list","Crane request is not present in the upcoming list");
				}
			}
			else {
				ReportConfig.Givenlogfail("User validate the upcoming list","Upcoming list has more than 10 values");
				
			}
		} 

		catch (Exception e) {
			ReportConfig.Givenlogfail("User validate the upcoming list","Upcoming list validation failed because : " + e.getMessage());
			PrintError(e.getMessage());
		}

	}


}
