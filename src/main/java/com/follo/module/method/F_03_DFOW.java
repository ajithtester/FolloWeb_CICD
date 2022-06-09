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

public class F_03_DFOW extends Baseclass  {


	public static void AddDFOW() throws Throwable {

		Wait(3000);
		PrintError("Add Dfow Started");

		ReadFrom.DynamicExcel(ReadFrom.AddDFOW);
			for(int Rows =1; Rows<=ReadFrom.rowcount; Rows++)		{	
			
				WebElement SpecSec = 	FindElement("SpecificationSectionRow", DFOWLocators, Rows);

				Clear(SpecSec);
				EnterValueInTheElement(SpecSec, ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Print("Specification is entered as : " + ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));
				ReportConfig.PassedLogInfo("Specification is entered as : " , ReadFrom.Excel(Rows, 0, ReadFrom.AddDFOW));

				Wait(3000);

				WebElement dfow =	FindElement("DfowRow", DFOWLocators, Rows);

				Clear(dfow);
				EnterValueInTheElement(dfow, ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Print("Dfow is entered as : " + ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));
				ReportConfig.PassedLogInfo("Dfow is entered as : " , ReadFrom.Excel(Rows, 1, ReadFrom.AddDFOW));

				Click("AddRow", DFOWLocators);
				Print("Add row is clicked");
				ReportConfig.PassedLogInfo("User adds DFOW list" ,"Add row is clicked");

			}
	}

	public static void SearchDFOW() throws Throwable {

		PrintError("Search Dfow Started");

		ReadFrom.DynamicExcel(ReadFrom.SearchDFOW);

			for(int SearchDfow =1; SearchDfow<=ReadFrom.rowcount; SearchDfow++)	{

				TypeDataInTheField("SearchDfow", DFOWLocators, ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW));
				ReportConfig.PassedLogInfo("Dfow entered in the search bar is : " , ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW)  );
				ClickEnter();
				Wait(6000);


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of dfow displayed : " + rowcount);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, i);

					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(SearchDfow, 0, ReadFrom.SearchDFOW);

					if(IsEqual(DFOWname, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + DFOWname);
						ReportConfig.PassedLogInfo("Displayed value is : " , DFOWname);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + DFOWname);
						ReportConfig.FailedLogInfo("Displayed value is : " , DFOWname);
					}


				}
				Clear("SearchDfow", DFOWLocators);
				Wait(3000);
				Click("ClearSearch", DFOWLocators);
				ReportConfig.PassedLogInfo("User search the dfow","Clear search button is clicked");
				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
	}


	public static void EditDFOW() throws Throwable {
		PrintError("Edit Dfow Started");

		ReadFrom.DynamicExcel(ReadFrom.EditDFOW);

			for(int EditDfow =1; EditDfow<=ReadFrom.rowcount; EditDfow++)	{


				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of elements : " + rowcount);

				for(int DfowList =1; DfowList<=rowcount; DfowList++)		{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);


					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, DfowList);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToEdit = Specificaiton + DFOWname;


					String EditIt =	ReadFrom.Excel(EditDfow, 0, ReadFrom.EditDFOW)+ReadFrom.Excel(EditDfow, 1, ReadFrom.EditDFOW);


					if(IsEqual(ToEdit, EditIt)) {

						WebElement EditSpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, DfowList);
						Clear(EditSpecSec);
						EnterValueInTheElement(EditSpecSec, ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						Print("Spec is edited as : " + ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));
						ReportConfig.PassedLogInfo("Specification is edited as : " , ReadFrom.Excel(EditDfow, 2, ReadFrom.EditDFOW));

						WebElement EditDfowlist =	FindElement("DfowRow", DFOWLocators, DfowList);
						Clear(EditDfowlist);
						EnterValueInTheElement(EditDfowlist, ReadFrom.Excel(EditDfow,3, ReadFrom.EditDFOW));


						Print("Dfow is edited as : " + ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));
						ReportConfig.PassedLogInfo("Dfow is edited as : " , ReadFrom.Excel(EditDfow, 3, ReadFrom.EditDFOW));

						Wait(5000);
						break;

					}

				}
			}
	}


	public static void DeleteDFOW() throws Throwable {
		PrintError("Delete Dfow Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteDFOW);

			for(int DeleteDfow =1; DeleteDfow<=ReadFrom.rowcount; DeleteDfow++)	{

				int rowcount = 	SizeOfTheList("DFOWlist", DFOWLocators);
				Print("No of elements : " + rowcount);

				for(int List =1; List<=rowcount; List++)	{

					WebElement SpecSec =	FindElement("SpecificationSectionRow", DFOWLocators, List);

					String Specificaiton = 	GetAttributeFromTheElement(SpecSec);

					WebElement Dfow =	FindElement("DfowRow", DFOWLocators, List);
					String DFOWname =	GetAttributeFromTheElement(Dfow);

					Wait(2000);

					String ToDelete = Specificaiton + DFOWname;


					String DeleteIt =	ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW)+ReadFrom.Excel(DeleteDfow, 1, ReadFrom.DeleteDFOW);



					if(IsEqual(ToDelete, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteDfow" ,DFOWLocators, List);
						Click(Delete);

					

						Wait(2000);

						Click("YesDelete", DFOWLocators);
						ReportConfig.PassedLogInfo("User deletes a DFOW from the list","Yes delete button is clicked");
						Print("Yes delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeleteDfowMessage", DFOWLocators)){
							Print("DFOW deleted is : " + ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							ReportConfig.PassedLogInfo("DFOW deleted is : " , ReadFrom.Excel(DeleteDfow, 0, ReadFrom.DeleteDFOW));
							break;
						}
					}
				}
			}
	}




	public static void DfowBulkUpload() throws Throwable {
		PrintError("BulkUpload Started");

		Wait(2000);
		String upload = ReadFrom.UploadDfowFile;
		String filePath = System.getProperty("user.dir")+ upload;
		
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		Wait(3000);
		file.sendKeys(filePath);
		}



	public static void AddSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Updated Successfully.']"));
			}
		});
	}

	public static void DeleteSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Listed Successfully.']"));
			}
		});
	}

	public static void BulkSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Definable Feature of Work Created Successfully.']"));
			}
		});
	}

	public static void BrowseFiles() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
			}
		});
	}
}
