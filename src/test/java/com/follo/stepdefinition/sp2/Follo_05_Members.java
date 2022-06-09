package com.follo.stepdefinition.sp2;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_05_Members;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_05_Members extends Baseclass {


	@Given("User clicks members button")
	public void user_clicks_members_button() throws Throwable {


		try {

			ReportConfig.ReportCreateFeatureTest("To verify the members feature");
			ReportConfig.ReportCreateScenarioTest("To click members button from the menu");
			if(IsElementDisplayed("MembersButton", MembersLocators)){
				Click("MembersButton", MembersLocators);
				Print("Members button is clicked");
				ReportConfig.Givenlogpass("User clicks members button","Members button is clicked");
				

			}
		} 
		catch (Exception e) {
			PrintError("Members button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User clicks members button","Members button is not clicked because : " + e.getMessage());
	
		}
	}



	@Given("User enters invite members button")
	public void user_enters_invite_members_button() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To send invites to Members");

			if(IsElementDisplayed("InviteMembers", MembersLocators)){
				Click("InviteMembers", MembersLocators);
				Print("Invite members button is clicked");
				ReportConfig.Givenlogpass("User enters invite members button","Invite members button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Invite members button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User enters invite members button","Invite members button is not clicked because : " + e.getMessage());

		}
	}


	@And("User enters members mailid")
	public void user_enters_members_mailid() throws Throwable {

		try {

			F_05_Members.InviteMembers();
			ReportConfig.Andlogpass("User enters members mailid","Invite sent to the users");

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Andlogfail("User enters members mailid","Invite not sent to the users because : " + e.getMessage());
		}
	}

	@And("User assign company and role to the member")
	public void user_assign_company_and_role_to_the_member() throws Throwable {

		try {

			F_05_Members.SelectCompany();
			ReportConfig.Andlogpass("User assign company and role to the member","company and role assigned to the members");

		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Andlogfail("User assign company and role to the member","company and role not assigned to the members because : " + e.getMessage());
		}
	}


	@And("User clicks send invite button")
	public void user_clicks_send_invite_button() throws Throwable {


		try {
			MoveToElement("SendInvitesButton", MembersLocators);
			if(IsElementDisplayed("SendInvitesButton", MembersLocators)){
				Click("SendInvitesButton", MembersLocators);
				Print("Send invites button is clicked");
				ReportConfig.Andlogpass("User clicks send invite button","Send invites button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Send invites button is not clicked");
			PrintError(e.getMessage());
			ReportConfig.Andlogfail("User clicks send invite button","Send invites button is not clicked because : " + e.getMessage());

		}

	}

	@Then("User should see the invite sent success message")
	public void user_should_see_the_invite_sent_success_message() throws Throwable {

		try {
			F_05_Members.InviteSentPopup();
			if(IsElementDisplayed("SuccessMessage", MembersLocators)){
				Click("SuccessMessage", MembersLocators);
				Print("Invite sent successfully");
				ReportConfig.Thenlogpass("User should see the invite sent success message","Send invites button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Invite sent failed");
			PrintError(e.getMessage());
			ReportConfig.Thenlogfail("User should see the invite sent success message","Send invites button is clicked because : " + e.getMessage());
		}

	}

	@Given("User edit a member from the list")
	public void user_edit_a_member_from_the_list() throws Throwable {
		try {
			ReportConfig.ReportCreateScenarioTest("Edit a member from the list");
			F_05_Members.EditMembers();
			ReportConfig.Givenlogpass("User edit a member from the list","Members are edited successfully");

		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			
			ReportConfig.Givenlogfail("User edit a member from the list","Members are not edited because : " + e.getMessage());


		}
	}

	@Given("User search and view the members")
	public void user_search_and_view_the_members() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Search a member from the list");
			F_05_Members.SearchMember();
			ReportConfig.Givenlogpass("User search and view the members","Members are searched successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and view the members","Members are not searched because : " + e.getMessage());

		}


	}

	@Given("User send reinvites to the pending members")
	public void user_send_reinvites_to_the_pending_members() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To send re-invites to members in pending state");
			F_05_Members.ReInviteMembers();
			ReportConfig.Givenlogpass("User send reinvites to the pending members","Reinvites are sent to members");

		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());
	
			ReportConfig.Givenlogfail("User send reinvites to the pending members","Reinvites are not sent to members because : " + e.getMessage());

		}
	}



	@Given("User search and filter the company based on role")
	public void user_search_and_filter_the_company_based_on_role() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("Filter Members based on role");

			F_05_Members.FilterMemberOnRole();
			ReportConfig.Givenlogpass("User search and filter the company based on role","Members are filtered successfully");

		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User search and filter the company based on role","Members are not filtered because : " + e.getMessage());


		}

	}

	@Given("User deletes a member from the list")
	public void user_deletes_a_member_from_the_list() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("Delete a member from the list");
			F_05_Members.DeleteMembers();
			ReportConfig.Givenlogpass("User deletes a member from the list","Members are deleted successfully");

		} 

		catch (Exception e) {
			PrintError(e.getMessage());
		
			ReportConfig.Givenlogfail("User deletes a member from the list","Members delete failed because : " + e.getMessage());


		}
	}



	@Given("User selects all members")
	public void user_selects_all_members() throws Throwable {

		try {
			Wait(2000);
			ReportConfig.ReportCreateScenarioTest("Delete all member except origin member from the list");
			if(IsElementDisplayed("SelectAll", MembersLocators)){
				Click("SelectAll", MembersLocators);
				Print("All members are selected");
				ReportConfig.Givenlogpass("User selects all members","All members are selected");

		
			}
		} catch (Exception e) {
			PrintError("All members are not selected");
			ReportConfig.Givenlogfail("User selects all members","All members are not selected because : " + e.getMessage());
		}

	}

	@And("User clicks remove button and click yes from the popup")
	public void user_clicks_remove_button_and_click_yes_from_the_popup() throws Throwable {

		try {
			if(IsElementDisplayed("RemoveButton", MembersLocators)){
				Click("RemoveButton", MembersLocators);
				Wait(2000);
				Click("YesDelete", MembersLocators);
				Print("Remove button is clicked");
				ReportConfig.Andlogpass("User clicks remove button and click yes from the popup","Remove button is clicked");

				
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			
			ReportConfig.Andlogpass("User clicks remove button and click yes from the popup","Remove button is not clicked because : " + e.getMessage());


		}
	}

	@Then("All the members except origin member should be deleted")
	public void all_the_members_except_origin_member_should_be_deleted() throws Throwable {


		try {

			F_05_Members.RemoveAll();
			ReportConfig.Thenlogpass("All the members except origin member should be deleted","All memebers are removed");
		} 

		catch (Exception e) {

			ReportConfig.Thenlogpass("All the members except origin member should be deleted","All memebers are removed because : " + e.getMessage());

		}
	}

}
