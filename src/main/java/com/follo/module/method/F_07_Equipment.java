package com.follo.module.method;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import report.ReportConfig;

public class F_07_Equipment extends Baseclass {

	public static void AddEquipment() throws Throwable {

		Wait(3000);
		PrintError("Add equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.AddEquipment);

		for(int AddEquipment =1; AddEquipment<=ReadFrom.rowcount; AddEquipment++)		{	

			Click("AddNewEquipment", EquipmentLocators);
			ReportConfig.PassedLogInfo("To add equipments" ,"Add new equipment button is clicked");
			Print("Add new equipment button is clicked");
			Wait(5000);
			WaitForTheElement("EquipmentName", EquipmentLocators);
			if(IsElementDisplayed("EquipmentName", EquipmentLocators)) {

				TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("Equipment name is entered as : " , ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				Print("Equipment name is entered as : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));

				Wait(2000);

				SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("Equipment type is entered as : " , ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));
				Print("Equipment type is entered as : " + ReadFrom.Excel(AddEquipment, 1, ReadFrom.AddEquipment));

				Wait(2000);

				SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("Contact person is entered as : " , ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));
				Print("Contact person is entered as : " + ReadFrom.Excel(AddEquipment, 2, ReadFrom.AddEquipment));

				Click("SubmitButton", EquipmentLocators);
				ReportConfig.PassedLogInfo("To add equipments" , "Submit button is clicked");
				Print("Submit button is clicked");
			}
			else {
				ReportConfig.FailedLogInfo("To add equipments" , "Equipment popup is not opened button is clicked");
				Print("Equipment popup is not opened button is clicked");

			}
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Equipment added successfully.']"));
				}
			});

			if(IsElementDisplayed("EquipmentAdded", EquipmentLocators)) {
				Click("EquipmentAdded", EquipmentLocators);
				Print("Equipment added is : " + ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
				ReportConfig.PassedLogInfo("Equipment added is : " ,  ReadFrom.Excel(AddEquipment, 0, ReadFrom.AddEquipment));
			}
			else {

				PrintError("Equipment is not added");
				ReportConfig.FailedLogInfo("To add equipments" ,"Equipment is not added");
			}
		}
	}

	public static void EditEquipment() throws Throwable {

		PrintError("Edit equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.EditEquipment);

		for(int EditEquipmentDetails =1; EditEquipmentDetails<=ReadFrom.rowcount; EditEquipmentDetails++)	{


			int rowcount = SizeOfTheList("EditButtonLocator", EquipmentLocators);


			for(int EditButton =1; EditButton<=rowcount; EditButton++)	{

				WebElement EquipmentList =	FindElement("EquipmentList" , EquipmentLocators , EditButton);

				String EquipmentListList = 	GetTextFromTheElement(EquipmentList);


				String EditIt =	ReadFrom.Excel(EditEquipmentDetails, 0, ReadFrom.EditEquipment);


				if(IsEqual(EquipmentListList, EditIt)) {

					Wait(2000);

					WebElement Edit =	FindElement("EditButton" ,EquipmentLocators, EditButton);
					Click(Edit);
					Wait(2000);

					Clear("EquipmentName", EquipmentLocators);

					TypeDataInTheField("EquipmentName", EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("Equipment name is edited as : " , ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));
					Print("Equipment name is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 1, ReadFrom.EditEquipment));

					Wait(2000);

					SelectFromVisibleText("EquipmentType" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("Equipment type name is edited as : " , ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));
					Print("Equipment type  is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 2, ReadFrom.EditEquipment));


					Wait(2000);

					SelectFromVisibleText("ContactPerson" , EquipmentLocators, ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
					ReportConfig.PassedLogInfo("Contact person is edited as : " , ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));
					Print("Contact person is edited as : " + ReadFrom.Excel(EditEquipmentDetails, 3, ReadFrom.EditEquipment));

					Wait(2000);
					Click("SubmitButton", EquipmentLocators);

					Wait<WebDriver> MemberUpdated = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					MemberUpdated.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Equipment updated successfully.']"));
						}
					});

					if(IsElementDisplayed("EquipmentEdit", EquipmentLocators)) {

						Print("Updated equipment is : " + EquipmentListList );
						ReportConfig.PassedLogInfo("Updated equipment is : " , EquipmentListList );
					}
				}
			} 
		}
	}

	public static void SearchEquipment() throws Throwable {

		PrintError("Search equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchEquipment);

		for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{
			Click("SearchButton", EquipmentLocators);
			Wait(2000);

			TypeDataInTheField("Search", EquipmentLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment));
			ReportConfig.PassedLogInfo(ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) , " is entered in the search bar");
			Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment) + " is entered in the search bar");

			Wait(5000);


			int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);
			Print("No of equipment displayed : " + rowcount);

			for(int SearchedEquipment =1; SearchedEquipment<=rowcount; SearchedEquipment++)	{

				WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, SearchedEquipment);
				String EquipmentName =	GetTextFromTheElement(Equipment);

				Wait(2000);

				String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchEquipment);

				if(IsEqual(EquipmentName, SearchedValue)) {

					Wait(2000);
					Print("Displayed value is : " + EquipmentName);
					ReportConfig.PassedLogInfo("Displayed value is : " , EquipmentName);

					Wait(3000);
					break;

				}
				else {
					PrintError("Displayed value is : " + EquipmentName);
					ReportConfig.FailedLogInfo("Displayed value is : " ,  EquipmentName);
				}
			}

			Wait(5000);
			Clear("Search", EquipmentLocators);
			Wait(3000);
			Click("ClearSearch", EquipmentLocators);
			ReportConfig.PassedLogInfo("To search equipments","Clear search button is clicked");
			Print("Clear search button is clicked");
		}
	}


	public static void DeleteEquipment() throws Throwable {

		PrintError("Delete equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.DeleteEquipment);

		for(int DeleteEquipment =1; DeleteEquipment<=ReadFrom.rowcount; DeleteEquipment++)	{


			int rowcount = 	SizeOfTheList("DeleteButtonLocator", EquipmentLocators);
			Print("No of elements : " + rowcount);

			for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement Equipment =	FindElement("EquipmentList", EquipmentLocators, DeleteButton);

				String EquipmentName = 	GetTextFromTheElement(Equipment);

				String DeleteIt =	ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment);


				if(IsEqual(EquipmentName, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButton" ,EquipmentLocators, DeleteButton);
					Click(Delete);
					Wait(2000);

					Click("YesDelete", EquipmentLocators);
					ReportConfig.PassedLogInfo("To delete equipments", "Equipment is selected and delete button is clicked");
					Print("Equipment is selected and delete button is clicked");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Equipment deleted successfully.']"));
						}
					});

					if(IsElementDisplayed("EquipmentDeleted", EquipmentLocators)){
						Click("EquipmentDeleted", EquipmentLocators);
						Print("Equipment deleted is : " + ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
						ReportConfig.PassedLogInfo("Equipment deleted is : " , ReadFrom.Excel(DeleteEquipment, 0, ReadFrom.DeleteEquipment));
						break;
					}else {
						PrintError("Equipment not deleted");
						ReportConfig.FailedLogInfo("To delete equipments", "Equipment not deleted");

						Wait(3000);

						break;

					}
				}
			}
		}
	}

	public static void FilterEquipment() throws Throwable {

		PrintError("Filter equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterEquipment);

		for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

			Click("FilterIcon", EquipmentLocators);
			ReportConfig.PassedLogInfo("To filter equipments" ,"Filter icon is clicked");
			Print("Filter icon is clicked");
			Wait(6000);



			TypeDataInTheField("EquipmentNameInFilter", EquipmentLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
			ReportConfig.PassedLogInfo("Equipment name is entered as : " , ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));
			Print("Equipment name is entered as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment));

			Click("FilterApply", EquipmentLocators);
			ReportConfig.PassedLogInfo("To filter equipments", "Filter apply button is clicked");
			Print("Filter apply button is clicked");
			Wait(3000);

			int rowcount = 	SizeOfTheList("EquipmentLists", EquipmentLocators);
			Print("No of Equipmentsedisplayed : " + rowcount);


			for(int EquipmentLists =1; EquipmentLists<=rowcount; EquipmentLists++)	{

				WebElement Equipment =	FindElement("EquipmentList" , EquipmentLocators, EquipmentLists );
				String EquipmentName =	GetTextFromTheElement(Equipment);

				Wait(2000);

				String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterEquipment);


				if(	IsEqual(EquipmentName, FilteredValue)) {

					Wait(2000);
					Print("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
					ReportConfig.PassedLogInfo("Filtered value is : " , FilteredValue + " : Displayed value is : " + EquipmentName);
					Wait(3000);

				}
				else {
					PrintError("Filtered value is : " + FilteredValue + " : Displayed value is : " + EquipmentName);
					ReportConfig.FailedLogInfo("Filtered value is : ", FilteredValue + " : Displayed value is : " + EquipmentName);
				}


			}
			Click("FilterIcon", EquipmentLocators);
			ReportConfig.PassedLogInfo("To filter equipments", "Filter icon button is clicked");
			Print("Filter icon button is clicked");

			Wait(3000);
			Click("FilterReset", EquipmentLocators);
			ReportConfig.PassedLogInfo("To filter equipments", "Filter reset button is clicked");
			Print("Filter reset button is clicked");

			Wait(3000);
			//	Clear("SearchDfow", DFOWLocators);

		}
	}


}
