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

public class F_06_Gate extends Baseclass{


	public static void AddGate() throws Throwable {

		Wait(3000);
		PrintError("Add Gate Started");
		ReadFrom.DynamicExcel(ReadFrom.AddGates);

		for(int AddGate =1; AddGate<=ReadFrom.rowcount; AddGate++)		{	

			Click("AddNewGate", GateLocators);
			ReportConfig.PassedLogInfo("To add gates" ,"Add new gate button is clicked");
			Print("Add new gate button is clicked");

			TypeDataInTheField("GateName", GateLocators, ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			ReportConfig.PassedLogInfo("Gate name is entered as : " , ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			Print("Gate name is entered as : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));

			Wait(2000);

			Click("SubmitButton", GateLocators);
			ReportConfig.PassedLogInfo("To add gates" ,"Submit button is clicked");
			Print("Submit button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Gate added successfully.']"));
				}
			});

			if(IsElementDisplayed("GateAdded", GateLocators)) {
				Click("GateAdded", GateLocators);
				Print("Gate added is : " + ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
				ReportConfig.PassedLogInfo("Gate added is : " , ReadFrom.Excel(AddGate, 0, ReadFrom.AddGates));
			}
			else {

				PrintError("Gate is not added");
				ReportConfig.FailedLogInfo("To add gates" ,"Gate is not added");
			}
		}
	}

	public static void EditGate() throws Throwable {
		PrintError("Edit Gate Started");
		ReadFrom.DynamicExcel(ReadFrom.EditGates);

		for(int EditGate = 1; EditGate<=ReadFrom.rowcount; EditGate++)	{


			int rowcount = 		SizeOfTheList("GateListLocator", GateLocators);
			Print("No of elements : " + rowcount);

			for(int GateList =1; GateList<=rowcount; GateList++)		{

				WebElement Gate =	FindElement("GateList", GateLocators, GateList);

				String GateName = 	GetTextFromTheElement(Gate);

				String EditIt =	ReadFrom.Excel(EditGate, 0, ReadFrom.EditGates);

				if(IsEqual(GateName, EditIt)) {

					WebElement EditButton =	FindElement("EditButtons", GateLocators, GateList);
					Click(EditButton);


					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//input[@placeholder='Gate Name*']"));
						}
					});

					Clear("GateName", GateLocators);
					TypeDataInTheField("GateName", GateLocators, ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));
					ReportConfig.PassedLogInfo("Gate name is edited as : " , ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));
					Print("Gate name is edited as : " + ReadFrom.Excel(EditGate, 1, ReadFrom.EditGates));

					Wait(2000);

					Click("UpdateButton", GateLocators);
					ReportConfig.PassedLogInfo("To edit gates," ,"Update button is clicked");
					Print("Update button is clicked");

					Wait<WebDriver> UpdateButton = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					UpdateButton.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Gate Updated successfully.']"));
						}
					});

					if(IsElementDisplayed("GateUpdated", GateLocators)) {
						Click("GateUpdated", GateLocators);
						Print("Gate updated is : " + ReadFrom.Excel(EditGate, 0, ReadFrom.AddGates));
						ReportConfig.PassedLogInfo("Gate updated is : " , ReadFrom.Excel(EditGate, 0, ReadFrom.AddGates));
					}
					else {

						PrintError("Gate is not updated");
						ReportConfig.FailedLogInfo("To edit gates" ,"Gate is not updated");
					}
				}
				Wait(5000);
			}
		}
	}

	public static void DeleteGate() throws Throwable {
		PrintError("Delete gate Started");
		ReadFrom.DynamicExcel(ReadFrom.DeleteGates);

		for(int DeleteGate =1; DeleteGate<=ReadFrom.rowcount; DeleteGate++)	{


			int rowcount = 	SizeOfTheList("DeleteButtonsLocator", GateLocators);
			Print("No of elements : " + rowcount);

			for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement Gate =	FindElement("GateList", GateLocators, DeleteButton);

				String GateName = 	GetTextFromTheElement(Gate);

				String DeleteIt =	ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates);


				if(IsEqual(GateName, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButtons" ,GateLocators, DeleteButton);
					Click(Delete);
					Wait(2000);

					Click("YesDelete", GateLocators);
					ReportConfig.PassedLogInfo("To delete gates" ,"Gate is selected and delete button is clicked");
					Print("Gate is selected and delete button is clicked");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Gate deleted successfully.']"));
						}
					});

					if(IsElementDisplayed("GateDeleted", GateLocators)){
						Click("GateDeleted", GateLocators);
						Print("Gate deleted is : " + ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates));
						ReportConfig.PassedLogInfo("Gate deleted is : " , ReadFrom.Excel(DeleteGate, 0, ReadFrom.DeleteGates));
						break;
					}else {
						PrintError("Gate not deleted");
						ReportConfig.FailedLogInfo("To delete gates" ,"Gate not deleted");

						Wait(3000);

						break;

					}
				}
			}
		}
	}

	public static void SearchGates() throws Throwable {

		PrintError("Search gates Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchGates);

		Click("SearchButton", GateLocators);
			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				Wait(2000);

				TypeDataInTheField("Search", GateLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchGates));
				ReportConfig.PassedLogInfo(ReadFrom.Excel(Search, 0, ReadFrom.SearchGates) ," is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchGates) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("GateListLocator", GateLocators);
				Print("No of gates displayed : " + rowcount);

				for(int SearchedGates =1; SearchedGates<=rowcount; SearchedGates++)	{

					WebElement Gate =	FindElement("GateList", GateLocators, SearchedGates);
					String Gatename =	GetTextFromTheElement(Gate);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchGates);



					if(IsEqual(Gatename, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + Gatename);
						ReportConfig.PassedLogInfo("Displayed value is : " , Gatename);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + Gatename);
						ReportConfig.FailedLogInfo("Displayed value is : " , Gatename);
					}


				}
				Wait(3000);
				Clear("Search", GateLocators);
				Wait(3000);
				Click("ClearSearch", GateLocators);
		ReportConfig.PassedLogInfo("Search gate" ,"Clear search button is clicked");
				Print("Clear search button is clicked");


			}

	}


}
