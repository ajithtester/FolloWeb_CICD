
package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

import report.ReportConfig;

public class F_11_QueuedRequest extends Baseclass {



	public static void EditQueuedRequest() throws Throwable {
		PrintError("Edit queued request started");
		ReadFrom.DynamicExcel(ReadFrom.EditQueuedRequest);

			for(int EditQueuedRequest =1; EditQueuedRequest<=ReadFrom.rowcount; EditQueuedRequest++)	{

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					Wait(3000);
					Print("came in" + DeliveryLists);
					WebElement Delivery =	FindElement("DeliveryRequestList", QueuedRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditQueuedRequest, 0, ReadFrom.EditQueuedRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						WebElement EditButton =	FindElement("EditQueuedRequest", QueuedRequestLocators, DeliveryLists);
						Print("edit button " + EditButton);
						JsClick(EditButton);
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Edit button is clicked");
						Print("Edit button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);
						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});

						if(IsElementDisplayed("Description", QueuedRequestLocators)) {
							Print("Delivery popup is opened");
							ReportConfig.PassedLogInfo("User edit a queued request from the list","Delivery popup is opened");
						}

						Clear("Description", QueuedRequestLocators);
						TypeDataInTheField("Description", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 1, ReadFrom.EditQueuedRequest));
						Print("Description is entered as : " + ReadFrom.Excel(EditQueuedRequest, 1, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Description is entered as : " + ReadFrom.Excel(EditQueuedRequest, 1, ReadFrom.EditQueuedRequest));

						SelectFromVisibleText("GateDropdown", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 2, ReadFrom.EditQueuedRequest));
						Print("Gate dropdown is selected as : " + ReadFrom.Excel(EditQueuedRequest, 2, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Gate dropdown is selected as : " + ReadFrom.Excel(EditQueuedRequest, 2, ReadFrom.EditQueuedRequest));

						SelectFromVisibleText("EquipmentDropdown", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 3, ReadFrom.EditQueuedRequest));
						Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditQueuedRequest, 3, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Equipment dropdown is selected as : " + ReadFrom.Excel(EditQueuedRequest, 3, ReadFrom.EditQueuedRequest));

						Wait(2000);

						try {
							if(IsElementDisplayed("PickingFrom", QueuedRequestLocators)) {

								Clear("PickingFrom", QueuedRequestLocators);
								TypeDataInTheField("PickingFrom", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 17, ReadFrom.EditQueuedRequest));
								Print("Picking from is entered as : " + ReadFrom.Excel(EditQueuedRequest, 17, ReadFrom.EditQueuedRequest));
								ReportConfig.PassedLogInfo("User edit a queued request from the list","Picking from is entered as : " + ReadFrom.Excel(EditQueuedRequest, 17, ReadFrom.EditQueuedRequest));

								Wait(2000);
								Clear("PickingTo", QueuedRequestLocators);
								TypeDataInTheField("PickingTo", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 18, ReadFrom.EditQueuedRequest));
								Print("Picking to is entered as : " + ReadFrom.Excel(EditQueuedRequest, 18, ReadFrom.EditQueuedRequest));
								ReportConfig.PassedLogInfo("User edit a queued request from the list","Picking to is entered as : " + ReadFrom.Excel(EditQueuedRequest, 18, ReadFrom.EditQueuedRequest));

							}

						} catch (Exception e) {
							{
								PrintError("Delivery request equipment is  selected");
								ReportConfig.FailedLogInfo("User edit a queued request from the list","Delivery request equipment is  selected");

							}
						}

						Wait(2000);
						MoveToElement("AdditionalText", QueuedRequestLocators);
						Clear("AdditionalText", QueuedRequestLocators);
						TypeDataInTheField("AdditionalText", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 4, ReadFrom.EditQueuedRequest));
						Print("Additional text is entered as : " + ReadFrom.Excel(EditQueuedRequest, 4, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Additional text is entered as : " + ReadFrom.Excel(EditQueuedRequest, 4, ReadFrom.EditQueuedRequest));

						Clear("VehicleDetails", QueuedRequestLocators);
						TypeDataInTheField("VehicleDetails", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 5, ReadFrom.EditQueuedRequest));
						Print("Vehicle details is entered as : " + ReadFrom.Excel(EditQueuedRequest, 5, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Vehicle details is entered as : " + ReadFrom.Excel(EditQueuedRequest, 5, ReadFrom.EditQueuedRequest));


						Click("DeliveryDate", QueuedRequestLocators);

						Wait(2000);
						Click("Currentyear", QueuedRequestLocators);
						Wait(3000);

						String Year = "False";
						while(Year=="False") {
							Wait(2000);
							if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditQueuedRequest, 6, ReadFrom.EditQueuedRequest) +"']")).size()>0){
								driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditQueuedRequest, 6, ReadFrom.EditQueuedRequest) +"']")).click();

								ReportConfig.PassedLogInfo("User edit a queued request from the list","Year is selected as : " + ReadFrom.Excel(EditQueuedRequest, 6, ReadFrom.EditQueuedRequest));
								Print("Year is selected as : " + ReadFrom.Excel(EditQueuedRequest, 6, ReadFrom.EditQueuedRequest));

								Year = "True";

							}
							else {

								Click("Nextyear", QueuedRequestLocators);
							}
						}

						String Month = "False";
						while(Month=="False") {
							Wait(2000);
							if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditQueuedRequest, 7, ReadFrom.EditQueuedRequest) +"']")).size()>0){
								driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditQueuedRequest, 7, ReadFrom.EditQueuedRequest) +"']")).click();

								Print("Month is selected as : " + ReadFrom.Excel(EditQueuedRequest, 7, ReadFrom.EditQueuedRequest));
								ReportConfig.PassedLogInfo("User edit a queued request from the list","Month is selected as : " + ReadFrom.Excel(EditQueuedRequest, 7, ReadFrom.EditQueuedRequest));
								Month = "True";
							}
							else {
								PrintError("Month is not available");
							}
						}

						String Date = "False";
						while(Date=="False") {
							Wait(5000);


							Print("(//span[contains(text(),'"+ ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest) +"')])");

							String c = ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest);
							if(driver.findElements(By.xpath("(//span[contains(text(),'"+ ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest) +"')])")).size()>0){
								Print("date");
								List<WebElement> s = driver.findElements(By.xpath("(//span[contains(text(),'"+ ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest) +"')])"));
								//if(s.isEnabled()) {
								for (WebElement webElement : s) {

									String Retrieve = 	webElement.getText();
									if(IsEqual(c, Retrieve)) {
										if(webElement.isEnabled()) {
											Wait(5000);
											Print("is enabled" + Retrieve);
											Print("is web" + webElement);
											webElement.click();

											Print("Date is selected as : " + ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest));
											ReportConfig.PassedLogInfo("User edit a queued request from the list","Date is selected as : " + ReadFrom.Excel(EditQueuedRequest, 8, ReadFrom.EditQueuedRequest));
											Date = "True";
											//break;
										}
										else {
											Print("samplpe");
										}
									}
									else {
										Print("not available");
									}
								}
							}
							else {

								PrintError("Date is not available");
							}
						}


						///////////////////////
						Wait(3000);
						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(ElementClickInterceptedException.class);


						WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//*[@id='company-select7']/ng-multiselect-dropdown/div/div[1]/span/span[1]"));
							}
						});

						JsClick("DfowEdit", QueuedRequestLocators);


						ReportConfig.PassedLogInfo("User edit a queued request from the list","Dfow dropdown is clicked");

						Click("SelectAll", QueuedRequestLocators);
						Wait(2000);
						Click("SelectAll", QueuedRequestLocators);
						Wait(2000);
						Click("Dfow", QueuedRequestLocators);

						String DfowInExcel = ReadFrom.Excel(EditQueuedRequest, 9, ReadFrom.EditQueuedRequest);


						int rowcountofthelist = 	SizeOfTheList("DfowListEdit", QueuedRequestLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowListEdits", QueuedRequestLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);



							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ReportConfig.PassedLogInfo("User edit a queued request from the list","Dfow is selected as : " + DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						/////////////////////////////////////
						JsClick("CompanyEdit", QueuedRequestLocators);
						//Click("Company", QueuedRequestLocators);

						ReportConfig.PassedLogInfo("User edit a queued request from the list","Company dropdown is clicked");
						Print("Company dropdown is clicked");

						Click("UnselectAll", QueuedRequestLocators);
						Wait(2000);
						Click("UnselectAll", QueuedRequestLocators);
						Wait(2000);
						Click("ResCompany", QueuedRequestLocators);

						String CompanyInExcel = ReadFrom.Excel(EditQueuedRequest, 10, ReadFrom.EditQueuedRequest);


						int countofthelist = 	SizeOfTheList("CompanyListEdit", QueuedRequestLocators);
						Print("No of elements : " + countofthelist);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
							WebElement Company = 	FindElement("CompanyListEdits", QueuedRequestLocators, DropdownValues);
							String CompanyInDropdown = 	GetTextFromTheElement(Company);

							if(IsEqual(CompanyInDropdown, CompanyInExcel)){
								Click(Company);

								ReportConfig.PassedLogInfo("User edit a queued request from the list","Dfow is selected as : " + CompanyInDropdown );
								Print("Dfow is selected as : " + CompanyInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						Wait(2000);
						Clear("FromHrs", QueuedRequestLocators);
						TypeDataInTheField("FromHrs", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 11, ReadFrom.EditQueuedRequest));
						Print("From hrs is entered as : " + ReadFrom.Excel(EditQueuedRequest, 11, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","From hrs is entered as : " + ReadFrom.Excel(EditQueuedRequest, 11, ReadFrom.EditQueuedRequest));

						Wait(2000);
						Clear("FromMin", QueuedRequestLocators);
						TypeDataInTheField("FromMin", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 12, ReadFrom.EditQueuedRequest));
						Print("From min is entered as : " + ReadFrom.Excel(EditQueuedRequest, 12, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","From min is entered as : " + ReadFrom.Excel(EditQueuedRequest, 12, ReadFrom.EditQueuedRequest));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditQueuedRequest, 13, ReadFrom.EditQueuedRequest);

						String Meridian = GetText("FromMeridian", QueuedRequestLocators);

						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", QueuedRequestLocators);
							Print("selected");
						}

						Wait(2000);
						Clear("ToHrs", QueuedRequestLocators);
						TypeDataInTheField("ToHrs", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 14, ReadFrom.EditQueuedRequest));
						Print("To hrs is entered as : " + ReadFrom.Excel(EditQueuedRequest, 14, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","To hrs is entered as : " + ReadFrom.Excel(EditQueuedRequest, 14, ReadFrom.EditQueuedRequest));

						Wait(2000);
						Clear("ToMin", QueuedRequestLocators);
						TypeDataInTheField("ToMin", QueuedRequestLocators, ReadFrom.Excel(EditQueuedRequest, 15, ReadFrom.EditQueuedRequest));
						Print("To min is entered as : " + ReadFrom.Excel(EditQueuedRequest, 15, ReadFrom.EditQueuedRequest));
						ReportConfig.PassedLogInfo("User edit a queued request from the list","To min is entered as : " + ReadFrom.Excel(EditQueuedRequest, 15, ReadFrom.EditQueuedRequest));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditQueuedRequest, 16, ReadFrom.EditQueuedRequest);
						String Meridian1 = GetText("ToMeridian", QueuedRequestLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", QueuedRequestLocators);

						}

						MoveToElement("SubmitButton", QueuedRequestLocators);

						Click("SubmitButton", QueuedRequestLocators);
						ReportConfig.PassedLogInfo("User edit a queued request from the list","Submit button is clicked");
						Print("Submit button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeliveryUpdated", QueuedRequestLocators)) {
							Click("DeliveryUpdated", QueuedRequestLocators);
							Print("Delivery request updated");
							ReportConfig.PassedLogInfo("User edit a queued request from the list","Delivery request updated");

						}
						else {
							PrintError("Delivery request failed");
						ReportConfig.FailedLogInfo("User edit a queued request from the list","Delivery request failed");
						}	

						Wait(5000);
						break;

					}
				}
			}
	}

	public static void DeleteRequest() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.DeleteQueuedRequest);

			for(int DeleteQueuedRequest =1; DeleteQueuedRequest<=ReadFrom.rowcount; DeleteQueuedRequest++)	{

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
				Print("No of elements : " + rowcount);

				for(int List =1; List<=rowcount; List++)	{

					WebElement QueuedRequest =	FindElement("DeliveryRequestList", QueuedRequestLocators, List);

					String QueuedRequestName = 	GetTextFromTheElement(QueuedRequest);


					String DeleteIt =	ReadFrom.Excel(DeleteQueuedRequest, 0, ReadFrom.DeleteQueuedRequest);



					if(IsEqual(QueuedRequestName, DeleteIt)) {

						Wait(2000);

						WebElement Delete =	FindElement("DeleteRequestList" ,QueuedRequestLocators, List);
						Click(Delete);

						ReportConfig.PassedLogInfo("User deletes a queued request from the list","Delete button is clicked");
						Print("Delete button is clicked");

						Wait(2000);

						Click("YesDelete", QueuedRequestLocators);
						ReportConfig.PassedLogInfo("User deletes a queued request from the list","Yes delete button is clicked");
						Print("Yes delete button is clicked");

						Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);

						fluentWait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Queued Delivery Request Deleted Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeleteSuccessfull", QueuedRequestLocators)){
							Print("Queued request deleted is : " + ReadFrom.Excel(DeleteQueuedRequest, 0, ReadFrom.DeleteQueuedRequest));
							ReportConfig.PassedLogInfo("User deletes a queued request from the list","Queued request deleted is : " + ReadFrom.Excel(DeleteQueuedRequest, 0, ReadFrom.DeleteQueuedRequest));
							break;
						}
						else {
							PrintError("Queued request not deleted");
							ReportConfig.FailedLogInfo("User deletes a queued request from the list","Queued request not deleted");
							Wait(5000);
							break;
						}
					}
				}
			}

	}


	public static void SearchQueuedRequest() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchQueuedRequest);

		Click("SearchIcon", QueuedRequestLocators);
			for(int SearchQueuedRequest =1; SearchQueuedRequest<=ReadFrom.rowcount; SearchQueuedRequest++)	{

				TypeDataInTheField("Search", QueuedRequestLocators, ReadFrom.Excel(SearchQueuedRequest, 0, ReadFrom.SearchQueuedRequest));
				ReportConfig.PassedLogInfo("User search and view the queued request from the list",ReadFrom.Excel(SearchQueuedRequest, 0, ReadFrom.SearchQueuedRequest) + " is entered in the search bar");
				ClickEnter();
				Wait(6000);


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
				Print("No of Queued request displayed : " + rowcount);

				for(int QueuedRequest =1; QueuedRequest<=rowcount; QueuedRequest++)	{

					WebElement Queued =	FindElement("DeliveryRequestList", QueuedRequestLocators, QueuedRequest);

					String QueuedRequestname =	GetTextFromTheElement(Queued);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(SearchQueuedRequest, 0, ReadFrom.SearchQueuedRequest);

					if(IsEqual(QueuedRequestname, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + QueuedRequestname);
						ReportConfig.PassedLogInfo("User search and view the queued request from the list","Displayed value is : " + QueuedRequestname);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + QueuedRequestname);
						ReportConfig.FailedLogInfo("User search and view the queued request from the list","Displayed value is : " + QueuedRequestname);
					}


				}
				Clear("Search", QueuedRequestLocators);
				Wait(3000);
				Click("CloseSearch", QueuedRequestLocators);
				ReportConfig.PassedLogInfo("User search and view the queued request from the list","Clear search button is clicked");
				Wait(3000);
				//	Clear("SearchQueuedRequest", QueuedRequestLocators);

			}
	
	}

	public static void FilterQueuedRequest() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.FilterQueuedRequest);
		Print(	"q deliver" + ReadFrom.rowcount );

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{
				Click("FilterIcon", QueuedRequestLocators);
				ReportConfig.PassedLogInfo("User filter the queued request from the list","Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(3000);
				Print(	ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest));
				Print("Value selected from the dropdown is : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest));

				SelectFromVisibleText("EquipmentInFilter", QueuedRequestLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest));
				ReportConfig.PassedLogInfo("User filter the queued request from the list","Value selected from the dropdown is : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest));
				Print("Value selected from the dropdown is : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest));

				Click("FilterApply", CompaniesLocators);
				ReportConfig.PassedLogInfo("User filter the queued request from the list","Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
				Print("No of request displayed : " + rowcount);


				for(int QueuedRequest =1; QueuedRequest<=rowcount; QueuedRequest++)	{

					WebElement Queued =	FindElement("EquipmentList" , QueuedRequestLocators, QueuedRequest );
					String QueuedName =	GetTextFromTheElement(Queued);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterQueuedRequest);


					if(	IsEqual(QueuedName, FilteredValue)) {

						Wait(2000);
						Print("Filtered value is : " + FilteredValue + " : Displayed value is : " + QueuedName);
					ReportConfig.PassedLogInfo("User filter the queued request from the list","Filtered value is : " + FilteredValue + " : Displayed value is : " + QueuedName);
						Wait(3000);

					}
					else {
						PrintError("Filtered value is : " + FilteredValue + " : Displayed value is : " + QueuedName);
						ReportConfig.FailedLogInfo("User filter the queued request from the list","Filtered value is : " + FilteredValue + " : Displayed value is : " + QueuedName);
					}


				}
				Click("FilterIcon", QueuedRequestLocators);
				ReportConfig.PassedLogInfo("User filter the queued request from the list","Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				JsClick("FilterReset", QueuedRequestLocators);
				ReportConfig.PassedLogInfo("User filter the queued request from the list","Filter reset button is clicked");
				Print("Filter reset button is clicked");

				Wait(3000);

			}
	}

	public static void SaveQueuedRequest() throws Throwable {
		PrintError("Save queued request started");
		
		ReadFrom.DynamicExcel(ReadFrom.SaveQueuedRequest);

			for(int SaveQueuedRequest =1; SaveQueuedRequest<=ReadFrom.rowcount; SaveQueuedRequest++)	{

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					Wait(3000);
					Print("came in" + DeliveryLists);
					WebElement Delivery =	FindElement("DeliveryRequestList", QueuedRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(SaveQueuedRequest, 0, ReadFrom.SaveQueuedRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						WebElement EditButton =	FindElement("EditQueuedRequest", QueuedRequestLocators, DeliveryLists);
						Print("edit button " + EditButton);
						JsClick(EditButton);
						ReportConfig.PassedLogInfo("User save a queued request from the list","Edit button is clicked");
						Print("Edit button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);
						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});

						if(IsElementDisplayed("Description", QueuedRequestLocators)) {
							Print("Delivery popup is opened");
							ReportConfig.PassedLogInfo("User save a queued request from the list","Delivery popup is opened");
						}

						Clear("Description", QueuedRequestLocators);
						TypeDataInTheField("Description", QueuedRequestLocators, ReadFrom.Excel(SaveQueuedRequest, 1, ReadFrom.SaveQueuedRequest));
						Print("Description is entered as : " + ReadFrom.Excel(SaveQueuedRequest, 1, ReadFrom.SaveQueuedRequest));
						ReportConfig.PassedLogInfo("User save a queued request from the list","Description is entered as : " + ReadFrom.Excel(SaveQueuedRequest, 1, ReadFrom.SaveQueuedRequest));

						/////////////////////////////////////

						MoveToElement("SaveButton", QueuedRequestLocators);

						Click("SaveButton", QueuedRequestLocators);
						ReportConfig.PassedLogInfo("User save a queued request from the list","Save button is clicked");
						Print("Save button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeliveryUpdated", QueuedRequestLocators)) {
							int Rowcount = 	SizeOfTheList("DeliveryRequestLists", QueuedRequestLocators);
							Print("No of elements : " + Rowcount);
							if(Rowcount>=Rowcount)
								Click("DeliveryUpdated", QueuedRequestLocators);
							Print("Delivery request saved");
							ReportConfig.PassedLogInfo("User save a queued request from the list","Delivery request saved");

						}
						else {
							PrintError("Save delivery request failed");
							ReportConfig.FailedLogInfo("User save a queued request from the list","Save delivery request failed");
						}	

						Wait(5000);
						break;

					}

				}
			}

	}


}
