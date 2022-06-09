package com.follo.module.method;

import java.time.Duration;
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

public class F_12_CalendarSettings extends Baseclass {


		public static void AddEvent() throws Throwable {
	
			ReadFrom.DynamicExcel(ReadFrom.CalendarSettingsRequest);
	
				for(int CalendarAddRequest =1; CalendarAddRequest<=ReadFrom.rowcount; CalendarAddRequest++)		{	
	
					Wait(4000);
					PrintError("Calendar started");
					Click("AddButton", CalendarSettingsLocators);
					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);
	
	
					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//input[@placeholder='Description']"));
						}
					});
	
					if(IsElementDisplayed("Description", CalendarSettingsLocators)) {
						Print("Calendar request popup is opened");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Calendar request popup is opened");
					}
	
					TypeDataInTheField("Description", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarSettingsRequest));
					Print("Description is entered as : " + ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Description is entered as : " + ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarSettingsRequest));
	
	
					Wait(2000);
					String AllDay = ReadFrom.Excel(CalendarAddRequest, 1, ReadFrom.CalendarSettingsRequest);
	
					if(IsEqual(AllDay, "No")) {
	
						Wait(2000);
						Clear("FromHH", CalendarSettingsLocators);
						TypeDataInTheField("FromHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarSettingsRequest));
						Print("From hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","From hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						Clear("FromMM", CalendarSettingsLocators);
						TypeDataInTheField("FromMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarSettingsRequest));
						Print("From min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","From min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(CalendarAddRequest, 4, ReadFrom.CalendarSettingsRequest);
						Print("eXCEL" + ExcelMeridian);
						String Meridian = GetText("FromMeridian", CalendarSettingsLocators);
						Print("WEB" + Meridian);
						if(IsEqual(Meridian, ExcelMeridian)) {
	
	
						}
						else {
							Wait(2000);
							Click("FromMeridian", CalendarSettingsLocators);
							Print("selected");
						}
	
						Wait(2000);
						Clear("EndHH", CalendarSettingsLocators);
						TypeDataInTheField("EndHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarSettingsRequest));
						Print("To hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","To hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						Clear("EndMM", CalendarSettingsLocators);
						TypeDataInTheField("EndMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarSettingsRequest));
						Print("To min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","To min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(CalendarAddRequest, 7, ReadFrom.CalendarSettingsRequest);
						String Meridian1 = GetText("EndMeridian", CalendarSettingsLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {
	
	
						}
						else {
							Wait(2000);
							Click("EndMeridian", CalendarSettingsLocators);				
						}
					}
					else if (IsEqual(AllDay, "Yes")) {
						Wait(2000);
						Click("AllDay", CalendarSettingsLocators);
						Print("All day option is selected");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","All day option is selected");
					}
	
					Wait(2000);
					Click("StartDate", CalendarSettingsLocators);
					Print("Start date is clicked");
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Start date is clicked");
	
	
					Wait(2000);
	
					Clear("StartDate", CalendarSettingsLocators);
					TypeDataInTheField("StartDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarSettingsRequest));
					Print("Start date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Start date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarSettingsRequest));
	
					Wait(2000);
					Clear("ToDate", CalendarSettingsLocators);
					TypeDataInTheField("ToDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarSettingsRequest));
					Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarSettingsRequest));
	
	
					String DeliveryCalendar = ReadFrom.Excel(CalendarAddRequest, 10, ReadFrom.CalendarSettingsRequest);
	
					if(IsEqual(DeliveryCalendar, "No")) {
	
	
					}
	
					else if (IsEqual(DeliveryCalendar, "Yes")) {
						Wait(2000);
						Click("DeliveryCalendar", CalendarSettingsLocators);
						Print("Delivery calendar option is selected");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Delivery calendar option is selected");
	
	
					}
	
					String CraneCalendar = ReadFrom.Excel(CalendarAddRequest, 11, ReadFrom.CalendarSettingsRequest);
	
					if(IsEqual(CraneCalendar, "No")) {
	
	
					}
	
					else if (IsEqual(CraneCalendar, "Yes")) {
						Wait(2000);
						Click("CraneCalendar", CalendarSettingsLocators);
						Print("Crane calendar option is selected");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Crane calendar option is selected");
	
					}
	
					Wait(2000);
					SelectFromVisibleText("RecurrenceDropdown", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarSettingsRequest));
					Print("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarSettingsRequest));
	
					String RecurrenceDropdown = ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarSettingsRequest);
					switch (RecurrenceDropdown) {
	
					case "Does Not Repeat":
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					case "Daily":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
						EvenAddedPopup();
						break;
	
					case "Weekly":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
						EvenAddedPopup();
						break;
	
					case "Monthly":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarSettingsRequest));
	
						if(IsEqual(CraneCalendar, "On day")) {						
							Click("OnDay", CalendarSettingsLocators);	
							Print("OnDay option is clicked");
							ReportConfig.PassedLogInfo("User add new event in Calendar settings","OnDay option is clicked");
						}
						else if(IsEqual(CraneCalendar, "On the First")){						
							Click("OnFirstDay", CalendarSettingsLocators);
							Print("OnFirstDay option is clicked");
							ReportConfig.PassedLogInfo("User add new event in Calendar settings","OnDay option is clicked");
						}
	
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
					ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					case "Yearly":	
	
						if(IsEqual(CraneCalendar, "On day")) {						
							Click("OnDay", CalendarSettingsLocators);	
							Print("OnDay option is clicked");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","OnDay option is clicked");
						}
						else if(IsEqual(CraneCalendar, "On the First")){						
							Click("OnFirstDay", CalendarSettingsLocators);
							Click("OnFirstDay", CalendarSettingsLocators);
							Print("OnFirstDay option is clicked");
						}
	
						MoveToElement("SubmitButton", CalendarSettingsLocators);
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					default:
	
	
						Wait(2000);
					}
	
				}
		}
	
	
	public static void EvenAddedPopup() throws Throwable {

		Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait11.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Event added']"));
			}
		});

		if(IsElementDisplayed("EventAdded", CalendarSettingsLocators)) {
			Click("EventAdded", CalendarSettingsLocators);
			Print("Event added successfully");
			ReportConfig.PassedLogInfo("User add new event in Calendar settings","Submit button is clicked");
		}
		else {
			PrintError("Event add failed");
			ReportConfig.FailedLogInfo("User add new event in Calendar settings","Event add failed");

		}

	}
	
	
	public static void EventUpdatedPopup() throws Throwable {

		Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait11.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Event updated']"));
			}
		});

		if(IsElementDisplayed("EventUpdated", CalendarSettingsLocators)) {
			Click("EventUpdated", CalendarSettingsLocators);
			Print("Event updated successfully");
			ReportConfig.Givenlogpass("User edit a event request from the calendar settings","Calendar settings button is displayed");
		}
	}

	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("CalendarYear", CalendarSettingsLocators);		

			String	YearValue = CalendarYear.split(" ", 2)[1];
			String Year = ReadFrom.Excel(Row, 1, Excel);

			int i=Integer.parseInt(YearValue);  
			int k=Integer.parseInt(Year);  

			if(IsEqual(Year, YearValue) ) {
				Print("Year selected is : " + YearValue);
				ReportConfig.PassedLogInfo("Year selected is : ",  YearValue);
				Date = "True"; 
			}

			else if(i>k) {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[1]/span"));
					}
				});

				JsClick("PreviousYearCalendar", CalendarSettingsLocators);

				Print("Previous year button is Clicked");
		

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});

			}
			else {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[4]/span"));
					}
				});

				JsClick("NextYearCalendar", CalendarSettingsLocators);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});
			}
		}


	}

	public static void SearchMonth(int Row , String Excel) throws Throwable {

		Wait(6000);
		String Date = "False";
		while(Date=="False") {
			WebElement CalendarYear = getElement("CalendarYear", CalendarSettingsLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("CalendarYear", CalendarSettingsLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Month is selected");
				ReportConfig.PassedLogInfo("Month is selected : " , MonthValue);

				Date = "True"; 

			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
				JsClick("NextMonthCalendar", CalendarSettingsLocators);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
			}
		}
	} 



	public static void SearchEvent() throws Throwable {

		PrintError("Search delivery started");
		ReadFrom.DynamicExcel(ReadFrom.SearchCalendarSettingsRequest);

			JsClick("SearchIcon", CalendarSettingsLocators);
			for(int SearchCalendarSettingsRequest =1; SearchCalendarSettingsRequest<=ReadFrom.rowcount; SearchCalendarSettingsRequest++)	{

				SearchMonth(SearchCalendarSettingsRequest, ReadFrom.SearchCalendarSettingsRequest);
				SearchYear(SearchCalendarSettingsRequest, ReadFrom.SearchCalendarSettingsRequest);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//input[@placeholder='What you are looking for?']"));
					}
				});


				Wait(2000);

				try {


					TypeDataInTheField("Search", CalendarSettingsLocators, ReadFrom.Excel(SearchCalendarSettingsRequest, 2, ReadFrom.SearchCalendarSettingsRequest));
					ReportConfig.PassedLogInfo("User search and view the event from the calendar settings",ReadFrom.Excel(SearchCalendarSettingsRequest, 2, ReadFrom.SearchCalendarSettingsRequest) + " is entered in the search bar");
					Print(ReadFrom.Excel(SearchCalendarSettingsRequest, 2, ReadFrom.SearchCalendarSettingsRequest) + " is entered in the search bar");

					Wait(6000);

					String DeliveryRequestName = ReadFrom.Excel(SearchCalendarSettingsRequest, 2, ReadFrom.SearchCalendarSettingsRequest);
					String Request = "(//div[contains(text(),'" + DeliveryRequestName + "')])[1]" ;

					WebElement Req = 	FindTheElement(Request);

					if(IsElementDisplayed(Req)) {
						Print("Displayed value is : " + DeliveryRequestName);
						ReportConfig.PassedLogInfo("User search and view the event from the calendar settings","Displayed value is : " + DeliveryRequestName);
					}
					else
					{
						PrintError("Displayed value is : " + DeliveryRequestName);
						ReportConfig.FailedLogInfo("User search and view the event from the calendar settings","Displayed value is : " + DeliveryRequestName);
					}
				}
				catch (Exception e) {
					Print(e.getMessage());
				}
				Wait(5000);
				Clear("Search", CalendarSettingsLocators);
				Wait(3000);
				JsClick("CloseSearch", CalendarSettingsLocators);
			ReportConfig.PassedLogInfo("User search and view the event from the calendar settings","Clear search button is clicked");
				Print("Clear search button is clicked");


			}
	}


	public static void EditEvent() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditCalendarSettingsRequest);

			for(int CalendarEditRequest =1; CalendarEditRequest<=ReadFrom.rowcount; CalendarEditRequest++)	{

				SearchMonth(CalendarEditRequest, ReadFrom.EditCalendarSettingsRequest);
				SearchYear(CalendarEditRequest, ReadFrom.EditCalendarSettingsRequest);

				Wait(6000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div[@class='ng-star-inserted']//div//div//div[2]//img[1])"));
					}
				});
				int rowcount = SizeOfTheList("EditButton", CalendarSettingsLocators);
				Print("rowcount" + rowcount);

				for(int EditButton =1; EditButton<=rowcount; EditButton++)	{

					WebElement EquipmentList =	FindElement("RequestList" , CalendarSettingsLocators , EditButton);
					Print("EquipmentList" + EquipmentList);
					String EquipmentListList = 	GetTextFromTheElement(EquipmentList);
					Print(EquipmentListList);

					String EditIt =	ReadFrom.Excel(CalendarEditRequest, 2, ReadFrom.EditCalendarSettingsRequest);

					Print(EditIt);
					if(IsEqual(EquipmentListList, EditIt)) {

						Wait(15000);
						Print("yes");
						WebElement Edit =	FindElement("EditButtonList" ,CalendarSettingsLocators,  EditButton);
						//						
						Print("Edit " + EditButton);
						Click(Edit);


						///////////////////
						Wait<WebDriver> Description = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						Description.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//input[@placeholder='Description']"));
							}
						});

						if(IsElementDisplayed("Description", CalendarSettingsLocators)) {
							Print("Calendar request popup is opened");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Calendar request popup is opened");
						}

						Wait(2000);
						
						Clear("Description", CalendarSettingsLocators);
						TypeDataInTheField("Description", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarSettingsRequest));
						Print("Description is entered as : " + ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Description is entered as : " + ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarSettingsRequest));


						Wait(2000);
						
//						if(getElement("FromHH", CalendarSettingsLocators).isEnabled()) {
//							
//						}
//						else {
//						JsClick("AllDay", CalendarSettingsLocators);
//						}
					//	JsClick("AllDay", CalendarSettingsLocators);
						String AllDay = ReadFrom.Excel(CalendarEditRequest, 4, ReadFrom.EditCalendarSettingsRequest);

						if(IsEqual(AllDay, "No")) {

							Wait(5000);
							Clear("FromHH", CalendarSettingsLocators);
							TypeDataInTheField("FromHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarSettingsRequest));
							Print("From hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","From hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							Clear("FromMM", CalendarSettingsLocators);
							TypeDataInTheField("FromMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarSettingsRequest));
							Print("From min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","From min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							String ExcelMeridian = ReadFrom.Excel(CalendarEditRequest, 7, ReadFrom.EditCalendarSettingsRequest);
							Print("eXCEL" + ExcelMeridian);
							String Meridian = GetText("FromMeridian", CalendarSettingsLocators);
							Print("WEB" + Meridian);
							if(IsEqual(Meridian, ExcelMeridian)) {


							}
							else {
								Wait(2000);
								Click("FromMeridian", CalendarSettingsLocators);
								Print("selected");
							}

							Wait(2000);
							Clear("EndHH", CalendarSettingsLocators);
							TypeDataInTheField("EndHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarSettingsRequest));
							Print("To hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							Clear("EndMM", CalendarSettingsLocators);
							TypeDataInTheField("EndMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarSettingsRequest));
							Print("To min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							String ExcelMeridian1 = ReadFrom.Excel(CalendarEditRequest, 10, ReadFrom.EditCalendarSettingsRequest);
							String Meridian1 = GetText("EndMeridian", CalendarSettingsLocators);
							if(IsEqual(Meridian1, ExcelMeridian1)) {


							}
							else {
								Wait(2000);
								Click("EndMeridian", CalendarSettingsLocators);				
							}
						}
						else if (IsEqual(AllDay, "Yes")) {
							Wait(2000);
							Click("AllDay", CalendarSettingsLocators);
							Print("All day option is selected");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","All day option is selected");
						}

						Wait(2000);
						Click("StartDate", CalendarSettingsLocators);
						Print("Start date is clicked");
					ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Start date is clicked");


						Wait(2000);

						Clear("StartDate", CalendarSettingsLocators);
						TypeDataInTheField("StartDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarSettingsRequest));
						Print("Start date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Start date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarSettingsRequest));

						Wait(2000);
						Clear("ToDate", CalendarSettingsLocators);
						TypeDataInTheField("ToDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarSettingsRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarSettingsRequest));

						Wait(2000);
						Click("DeliveryCalendar", CalendarSettingsLocators);
						String DeliveryCalendar = ReadFrom.Excel(CalendarEditRequest, 13, ReadFrom.EditCalendarSettingsRequest);

						if(IsEqual(DeliveryCalendar, "No")) {


						}

						else if (IsEqual(DeliveryCalendar, "Yes")) {
							Wait(2000);
							Click("DeliveryCalendar", CalendarSettingsLocators);
							Print("Delivery calendar option is selected");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Delivery calendar option is selected");


						}

						Wait(2000);
						Click("CraneCalendar", CalendarSettingsLocators);
						String CraneCalendar = ReadFrom.Excel(CalendarEditRequest, 14, ReadFrom.EditCalendarSettingsRequest);

						if(IsEqual(CraneCalendar, "No")) {


						}

						else if (IsEqual(CraneCalendar, "Yes")) {
							Wait(2000);
							Click("CraneCalendar", CalendarSettingsLocators);
							Print("Crane calendar option is selected");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Crane calendar option is selected");

						}

						Wait(2000);
						SelectFromVisibleText("RecurrenceDropdown", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarSettingsRequest));
						Print("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarSettingsRequest));
						ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarSettingsRequest));

						String RecurrenceDropdown = ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarSettingsRequest);
						switch (RecurrenceDropdown) {

						case "Does Not Repeat":

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);
							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Submit button is clicked");

							EventUpdatedPopup();
							break;

						case "Daily":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Submit button is clicked");
							EventUpdatedPopup();
							break;

						case "Weekly":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Submit button is clicked");
							EventUpdatedPopup();
							break;

						case "Monthly":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarSettingsRequest));

							if(IsEqual(CraneCalendar, "On day")) {						
								Click("OnDay", CalendarSettingsLocators);	
								Print("OnDay option is clicked");
								ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","OnDay option is clicked");
							}
							else if(IsEqual(CraneCalendar, "On the First")){						
								Click("OnFirstDay", CalendarSettingsLocators);
								Print("OnFirstDay option is clicked");
								ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","OnDay option is clicked");
							}

							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Submit button is clicked");

							EventUpdatedPopup();
							break;

						case "Yearly":	

							if(IsEqual(CraneCalendar, "On day")) {						
								Click("OnDay", CalendarSettingsLocators);	
								Print("OnDay option is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","OnDay option is clicked");
							}
							else if(IsEqual(CraneCalendar, "On the First")){						
								Click("OnFirstDay", CalendarSettingsLocators);
								Click("OnFirstDay", CalendarSettingsLocators);
								Print("OnFirstDay option is clicked");
							}

							MoveToElement("SubmitButton", CalendarSettingsLocators);
							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ReportConfig.PassedLogInfo("User edit a event request from the calendar settings","Submit button is clicked");

							EventUpdatedPopup();
							break;

						default:


							Wait(2000);
						}

					///////////
						break;


					}
				} 
			}
	}
}
