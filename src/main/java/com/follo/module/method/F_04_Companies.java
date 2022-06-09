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

public class F_04_Companies extends Baseclass {




	public static void AddDCompany() throws Throwable {
		PrintError("Add Company Started");
		ReadFrom.DynamicExcel(ReadFrom.AddCompany);


			for(int AddCompany =1; AddCompany<=ReadFrom.rowcount; AddCompany++)		{	
				Wait(2000);
				Click("NewCompany", CompaniesLocators);
				ReportConfig.PassedLogInfo("To add new companies" ,"New company button is clicked");
				Print("New company button is clicked");

				Wait(5000);
				if(IsElementDisplayed("Dfow", CompaniesLocators)) {
					
					String upload = ReadFrom.UploadCompanyLogo;
					String imagePath = System.getProperty("user.dir")+ upload;
					
					WebElement logo = driver.findElement(By.xpath("//label[@for='file-input']//following::input[@id='file-input']"));
					
					Wait(3000);
					logo.sendKeys(imagePath);

					Wait(2000);
					TypeDataInTheField("CompanyName", CompaniesLocators, ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Company name is entered as : " , ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
					Print("Company name is entered as : " +ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));


					Wait(2000);
					TypeDataInTheField("AddressLine1", CompaniesLocators, ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Address line1 is entered as : " , ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));
					Print("Address line1 is entered as : " +ReadFrom.Excel(AddCompany, 2, ReadFrom.AddCompany));

					Wait(2000);
					ClickEnter();

					Wait(2000);
					TypeDataInTheField("AddressLine2", CompaniesLocators, ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Address line2 is entered as : " , ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));
					Print("Address line2 is entered as : " +ReadFrom.Excel(AddCompany, 3, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("City", CompaniesLocators, ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("City is entered as : " , ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));
					Print("City is entered as : " +ReadFrom.Excel(AddCompany, 4, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("State", CompaniesLocators, ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("State is entered as : " , ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));
					Print("State is entered as : " +ReadFrom.Excel(AddCompany, 5, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Zipcode", CompaniesLocators, ReadFrom.Excel(AddCompany, 6, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Zipcode is entered as : " , ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));
					Print("Zipcode is entered as : " +ReadFrom.Excel(AddCompany,6, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Country", CompaniesLocators, ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Country is entered as : " , ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));
					Print("Country is entered as : " +ReadFrom.Excel(AddCompany, 7, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("Website", CompaniesLocators, ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Website is entered as : " , ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));
					Print("Website is entered as : " +ReadFrom.Excel(AddCompany, 8, ReadFrom.AddCompany));

					Wait(2000);
					TypeDataInTheField("AdditionalNotes", CompaniesLocators, ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
					ReportConfig.PassedLogInfo("Additional notes is entered as : " , ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));
					Print("Additional notes is entered as : " +ReadFrom.Excel(AddCompany, 9, ReadFrom.AddCompany));

					Wait(2000);
						Click("Dfow", CompaniesLocators);
						ReportConfig.PassedLogInfo("To add new companies" ,"Dfow dropdown is clicked");

						//	ReadFrom.DynamicExcel(ReadFrom.AddCompanyDfow);

						//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
						String DfowInExcel = ReadFrom.Excel(AddCompany, 1,ReadFrom.AddCompany);
						Print(DfowInExcel);

						int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);
							Print(DfowInDropdown);


							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ReportConfig.PassedLogInfo("Dfow is selected as : " , DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
							else {
								PrintError("Not matched");
							}
						}
				

					Wait(2000);

					Click("SubmitButton", CompaniesLocators);
					ReportConfig.PassedLogInfo("To add new companies" , "Submit button is clicked");
					Wait(5000);

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);


					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Company Created Successfully.']"));
						}
					});

					if(IsElementDisplayed("CompanyAdded", CompaniesLocators)){
						Print("Company added is : " + ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));
						ReportConfig.PassedLogInfo("Company added is : " , ReadFrom.Excel(AddCompany, 0, ReadFrom.AddCompany));

					}else {
						PrintError("Company not added");
						ReportConfig.FailedLogInfo("To add new companies" ,"Company not added");
					}
				}
			}

	}


	public static void SearchCompany() throws Throwable {
		PrintError("Search company Started");

		ReadFrom.DynamicExcel(ReadFrom.SearchCompany);
	
			Click("Search", CompaniesLocators);
			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				ReportConfig.PassedLogInfo("Search Company" ,"Search button is clicked");

				TypeDataInTheField("SearchCompany", CompaniesLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany));
				ReportConfig.PassedLogInfo(ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany) , " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany) + " is entered in the search bar");

				ClickEnter();
				Wait(6000);

				int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
					String CompanyName =	GetTextFromTheElement(Company);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchCompany);


					if(IsEqual(CompanyName, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + CompanyName);
						ReportConfig.PassedLogInfo("Displayed value is : " , CompanyName);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + CompanyName);
					}


				}
				Wait(3000);
				Clear("SearchDfow", DFOWLocators);
				Wait(3000);
				Click("ClearSearch", CompaniesLocators);
				ReportConfig.PassedLogInfo("Search Company" ,"Clear search button is clicked");
				Print("Clear search button is clicked");
				Wait(3000);
				

			}
			Clear("SearchDfow", DFOWLocators);
	}


	public static void FilterCompany() throws Throwable {
		PrintError("Filter company Started");

		ReadFrom.DynamicExcel(ReadFrom.FilterCompany);


			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{
				Click("FilterIcon", CompaniesLocators);
				ReportConfig.PassedLogInfo("Filter Company","Filter icon button is clicked");
				Print("Filter icon button is clicked");

				TypeDataInTheField("FilterCompanyName", CompaniesLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany));
			ReportConfig.PassedLogInfo(ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany) , " is entered in the search bar");
				Print(ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany) + " is entered in the search bar");


				Wait(2000);
				Click("FilterApply", CompaniesLocators);
				ReportConfig.PassedLogInfo("Filter Company","Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(6000);

				int rowcount = 	SizeOfTheList("CompanyList", CompaniesLocators);

				for(int i =1; i<=rowcount; i++)	{

					WebElement Company =	FindElement("CompanyListed" ,CompaniesLocators, i);
					String CompanyName =	GetTextFromTheElement(Company);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterCompany);


					if(	IsEqual(CompanyName, FilteredValue)) {

						Wait(2000);
						Print("Displayed value is : " + CompanyName);
						ReportConfig.PassedLogInfo("Displayed value is : " , CompanyName);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + CompanyName);
					}


				}
				Click("FilterIcon", CompaniesLocators);
				ReportConfig.PassedLogInfo("Filter Company","Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Click("FilterReset", CompaniesLocators);
				ReportConfig.PassedLogInfo("Filter Company","Filter Reset button is clicked");
				Print("Filter Reset button is clicked");
				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

				
				
			}
	}

	public static void DeleteCompany() throws Throwable {
		
		PrintError("Delete company Started");
		
		ReadFrom.DynamicExcel(ReadFrom.DeleteCompany);

			for(int DeleteCompany =1; DeleteCompany<=ReadFrom.rowcount; DeleteCompany++)	{


				int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of elements : " + rowcount);

				for(int DeleteButton =2; DeleteButton<=rowcount; DeleteButton++)	{

					WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, DeleteButton);

					String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);
					Print(CompanyNamesList);

					String DeleteIt =	ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany);



					if(IsEqual(CompanyNamesList, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteCompany" , CompaniesLocators, DeleteButton-1);
						Click(Delete);


						Wait(2000);

						Click("YesDelete", CompaniesLocators);
						ReportConfig.PassedLogInfo("Delete Company" ,"Company is selected and delete button is clicked");
						Print("Company is selected and delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Company Deleted Successfully.']"));
							}
						});

						if(IsElementDisplayed("CompanyDeleted", CompaniesLocators)){
							Print("Company deleted is : " + ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
							ReportConfig.PassedLogInfo("Company deleted is : " , ReadFrom.Excel(DeleteCompany, 0, ReadFrom.DeleteCompany));
							break;
						}else {
							PrintError("Company not deleted");
							ReportConfig.FailedLogInfo("Delete Company" ,"Company not deleted");

							Wait(3000);
						}
					}

				}
			}
		}
	

	public static void EditCompany() throws Throwable {
		
		PrintError("Edit company Started");
		ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);

		for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)	{


				int rowcount = SizeOfTheList("CompanyList", CompaniesLocators);
				Print("No of elements : " + rowcount);

				for(int CompanyList =1; CompanyList<=rowcount; CompanyList++)	{

					WebElement CompanyNames =	FindElement("CompanyListed" ,CompaniesLocators, CompanyList);

					String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);


					String EditIt =	ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails);


					if(IsEqual(CompanyNamesList, EditIt)) {

						Wait(2000);

						WebElement EditButton =	FindElement("EditCompany" ,CompaniesLocators,  CompanyList);
						Click(EditButton);
					ReportConfig.PassedLogInfo("Edit Company", "Edit button is clicked");
						Print("Edit button is clicked");
						/////////////////////////////////////////////////////////////////////////////////

						//						ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);
						//						Print("eXCEL EditCompanyDetails : " + ReadFrom.rowcount);
						//for(int EditCompanyDetails =1; EditCompanyDetails<=ReadFrom.rowcount; EditCompanyDetails++)		{	


						Wait(3000);
						if(IsElementDisplayed("DropdownList", CompaniesLocators)) {

							Wait(2000);
							Clear("CompanyName", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"Company name is cleared");
							Print("Company name is cleared");

							TypeDataInTheField("CompanyName", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("Company name is edited as : " , ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));
							Print("Company name is edited as : " + ReadFrom.Excel(EditCompanyDetails, 1, ReadFrom.EditCompanyDetails));


							Wait(2000);
							Clear("AddressLine1", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"AddressLine1 is cleared");
							Print("AddressLine1 is cleared");

							TypeDataInTheField("AddressLine1", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("AddressLine1 is edited as : " , ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));
							Print("AddressLine1 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 3, ReadFrom.EditCompanyDetails));

							Wait(2000);
							ClickEnter();

							Wait(2000);
							Clear("AddressLine2", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"AddressLine2 is cleared");
							Print("AddressLine2 is cleared");

							TypeDataInTheField("AddressLine2", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("AddressLine2 is edited as : " , ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));
							Print("AddressLine2 is edited as : " + ReadFrom.Excel(EditCompanyDetails, 4, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("City", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"City is cleared");
							Print("City is cleared");

							TypeDataInTheField("City", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("City is edited as : " , ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));
							Print("City is edited as : " + ReadFrom.Excel(EditCompanyDetails, 5, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("State", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"State is cleared");
							Print("State is cleared");

							TypeDataInTheField("State", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("State is edited as : " , ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));
							Print("State is edited as : " + ReadFrom.Excel(EditCompanyDetails, 6, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Zipcode", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"Zipcode is cleared");
							Print("Zipcode is cleared");

							TypeDataInTheField("Zipcode", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("Zipcode is edited as : " , ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));
							Print("Zipcode is edited as : " + ReadFrom.Excel(EditCompanyDetails, 7, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Country", CompaniesLocators);
						ReportConfig.PassedLogInfo("Edit Company" ,"Country is cleared");
							Print("Country is cleared");

							TypeDataInTheField("Country", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("Country is edited as : " , ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));
							Print("Country is edited as : " + ReadFrom.Excel(EditCompanyDetails, 8, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("Website", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"Website is cleared");
							Print("Website is cleared");

							TypeDataInTheField("Website", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
							ReportConfig.PassedLogInfo("Website is edited as : " , ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));
							Print("Website is edited as : " + ReadFrom.Excel(EditCompanyDetails, 9, ReadFrom.EditCompanyDetails));

							Wait(2000);
							Clear("AdditionalNotes", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"AdditionalNotes is cleared");
							Print("AdditionalNotes is cleared");

							TypeDataInTheField("AdditionalNotes", CompaniesLocators, ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
						ReportConfig.PassedLogInfo("AdditionalNotes is edited as : " , ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));
							Print("AdditionalNotes is edited as : " + ReadFrom.Excel(EditCompanyDetails, 10, ReadFrom.EditCompanyDetails));


							Wait(2000);
					
								Click("DropdownList", CompaniesLocators);
								ReportConfig.PassedLogInfo("Edit Company" ,"Dropdown is clicked");
								Print("Dropdown is clicked");

								Click("SelectAllInDropdown", CompaniesLocators);

								Click("UnSelectAllInDropdown", CompaniesLocators);
								//ReadFrom.DynamicExcel(ReadFrom.EditCompanyDetails);

								//	for(int AddCompanyDfow =1; AddCompanyDfow<=ReadFrom.rowcount; AddCompanyDfow++)		{	
								String DfowInExcel = ReadFrom.Excel(EditCompanyDetails, 2,ReadFrom.EditCompanyDetails);
								Print(DfowInExcel);
								
			
								int rowcountofthelist = 	SizeOfTheList("DfowList", CompaniesLocators);
								Print("No of elements : " + rowcountofthelist);

								for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	

									WebElement Dfow = 	FindElement("DfowInDropdown", CompaniesLocators, DropdownValues);
									String DfowInDropdown = 	GetTextFromTheElement(Dfow);
									Print(DfowInDropdown);

									if(DfowInDropdown.equalsIgnoreCase(DfowInExcel)){
										Click(Dfow);
										ReportConfig.PassedLogInfo(DfowInDropdown , " is selected from the dropdown");
										Print(DfowInDropdown + " is selected from the dropdown");
										break;
									}
									else {
										PrintError("Not matched");
									}
									//}
									//} 
								}
						
							Wait(2000);
							Click("SubmitButton", CompaniesLocators);
							ReportConfig.PassedLogInfo("Edit Company" ,"Submit button is clicked");
							Print("Submit button is clicked");
							
							Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							fluentWait.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Company Updated Successfully.']"));
								}
							});

							if(IsElementDisplayed("CompanyEdited", CompaniesLocators)){
								Print("Company edited is : " + ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
								ReportConfig.PassedLogInfo("Company edited is : " , ReadFrom.Excel(EditCompanyDetails, 0, ReadFrom.EditCompanyDetails));
								break;
							}else {
								PrintError("Company not edited");
								ReportConfig.FailedLogInfo("Edit Company","Company not edited");

							}

						}

						//	}
						break;
					}
				}
			}
	
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
	
	public static void CompanyBulkUpload() throws Throwable {
//		Wait(2000);
//		
//		WebElement file_input = driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
//		Wait(4000);
//		file_input.sendKeys(ReadFrom.UploadCompanyFile);
//		Print(ReadFrom.UploadCompanyFile);
	//	Robot FileUpload = new Robot();

//		StringSelection str = new StringSelection(ReadFrom.UploadCompanyFile);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//		Print(ReadFrom.UploadCompanyFile);

		//Wait(2000);

//		FileUpload.keyPress(KeyEvent.VK_CONTROL);
//		FileUpload.keyPress(KeyEvent.VK_V);
//
//		FileUpload.keyRelease(KeyEvent.VK_CONTROL);
//		FileUpload.keyRelease(KeyEvent.VK_V);
//
//		FileUpload.keyPress(KeyEvent.VK_ENTER);
//		FileUpload.keyRelease(KeyEvent.VK_ENTER);


	}
	
	public static void BulkSuccessfullMessage() throws Throwable {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Company File uploaded.!']"));
			}
		});
	}

}
