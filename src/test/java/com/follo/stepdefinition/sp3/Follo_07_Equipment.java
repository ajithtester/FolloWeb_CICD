package com.follo.stepdefinition.sp3;

import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_07_Equipment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import report.ReportConfig;

public class Follo_07_Equipment extends Baseclass {



	@Given("User clicks equipment button")
	public void user_clicks_equipment_button() throws Throwable {

		try {

			ReportConfig.ReportCreateFeatureTest("To verify the equipment feature");
			ReportConfig.ReportCreateScenarioTest("To click equipment button from the menu");
			if(IsElementDisplayed("EquipmentButton", EquipmentLocators)){
				Print("Equipment button is displayed");
				Click("EquipmentButton", EquipmentLocators);
				Print("Equipment button is displayed");
				ReportConfig.Givenlogpass("User clicks equipment button","Equipment button is clicked");


			}
		} 
		catch (Exception e) {

			PrintError("Equipment button is not clicked");
			PrintError(e.getMessage());

			ReportConfig.Givenlogfail("User clicks equipment button","Equipment button is not clicked because : " + e.getMessage());
		}

	}

	@Given("User adds new equipment")
	public void user_adds_new_equipment() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To add equipments");
			F_07_Equipment.AddEquipment();
			ReportConfig.Givenlogpass("User adds new equipment","Equipment added successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User adds new equipment","Equipment not added because : " + e.getMessage());
		}

	}


	@Given("User edit a equipment from the list")
	public void user_edit_a_equipment_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To edit equipments");
			F_07_Equipment.EditEquipment();
			ReportConfig.Givenlogpass("User edit a equipment from the list","Equipment edited successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User edit a equipment from the list","Equipment not edited because : " + e.getMessage());
		}


	}

	@Given("User filter the company based on equipment name")
	public void user_filter_the_company_based_on_equipment_name() throws Throwable {


		try {
			ReportConfig.ReportCreateScenarioTest("To filter equipments");
			F_07_Equipment.FilterEquipment();
			ReportConfig.Givenlogpass("User filter the company based on equipment name","Equipment filtered successfully");

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User filter the company based on equipment name","Equipment not filtered because : " + e.getMessage());
		}

	}

	@Given("User search and view the equipment")
	public void user_search_and_view_the_equipment() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To search equipments");
			F_07_Equipment.SearchEquipment();
			ReportConfig.Givenlogpass("User search and view the equipment","Equipment searched successfully");


		} 
		catch (Exception e) {

			PrintError(e.getMessage());

			ReportConfig.Givenlogfail("User search and view the equipment","Equipment not searched because : " + e.getMessage());

		}

	}


	@Given("User delete a equipment from the list")
	public void user_delete_a_equipment_from_the_list() throws Throwable {

		try {
			ReportConfig.ReportCreateScenarioTest("To delete equipments");
			F_07_Equipment.DeleteEquipment();
			ReportConfig.Givenlogpass("User delete a equipment from the list","Equipment deleted successfully");
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ReportConfig.Givenlogfail("User delete a equipment from the list","Equipment not deleted because : " + e.getMessage());
		}
	}


	@Given("User selects all equipment")
	public void user_selects_all_equipment() throws Throwable {

		try {
			Wait(2000);
			ReportConfig.ReportCreateScenarioTest("Delete all equipments");
			if(IsElementDisplayed("SelectAll", EquipmentLocators)){

				Click("SelectAll", EquipmentLocators);


				Print("All equipments are selected");
				ReportConfig.Givenlogpass("User selects all equipment","All equipments are selected");

			}
		} catch (Exception e) {
			PrintError("All equipments are not selected");
			ReportConfig.Givenlogfail("User selects all equipment","All equipments are not selected because : " + e.getMessage());
		}

	}

	@And("User clicks remove button and click yes from the equipment popup")
	public void user_clicks_remove_button_and_click_yes_from_the_equipment_popup() throws Throwable {

		try {
			if(IsElementDisplayed("RemoveButton", EquipmentLocators)){
				Click("RemoveButton", EquipmentLocators);
				Print("Remove button is clicked");



				Wait(2000);
				Click("YesDelete", EquipmentLocators);


				Print("Yes button is clicked");

				ReportConfig.Andlogpass("User clicks remove button and click yes from the equipment popup","Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Detele button is not clicked");
			ReportConfig.Andlogfail("User clicks remove button and click yes from the equipment popup","Remove button is not clicked because : " + e.getMessage());



		}

	}

	@Then("All the equipment should be deleted")
	public void all_the_equipment_should_be_deleted() throws Throwable {

		try {

			if(IsElementDisplayed("NoRecordFound", EquipmentLocators)) {
				Print("No record found is dispayed : All equipments are deleted");
				ReportConfig.Thenlogpass("All the equipment should be deleted","No record found is dispayed : All equipments are deleted");

			}
		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All equipments are not deleted");
			ReportConfig.Thenlogfail("All the equipment should be deleted","No record found is dispayed : All equipments are not deleted because : " + e.getMessage());

		}

	}


}
