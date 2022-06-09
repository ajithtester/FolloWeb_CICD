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

public class F_16_Dashboard extends Baseclass {

	public static void AddRequest() throws Throwable {

		PrintError("Add deliver request Started");
		ReadFrom.DynamicExcel(ReadFrom.AddRequestDashBoard);
		for(int AddRequestDashBoard =1; AddRequestDashBoard<=ReadFrom.rowcount; AddRequestDashBoard++)		{	

			Wait(4000);
			PrintError("Add delivery started");
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(ElementClickInterceptedException.class);


			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Create New']"));
				}
			});

			if(IsElementDisplayed("CreateNew", DashboardLocators)){
				JsClick("CreateNew", DashboardLocators);
				Print("Create new button is clicked");
				ReportConfig.PassedLogInfo("User add new delivery request", "Create new button is clicked");

			}
			else
			{
				PrintError("Create new button is not clicked");
				ReportConfig.FailedLogInfo("User add new delivery request","Create new button is not clicked");
			}


			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait1.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
				}
			});

			if(IsElementDisplayed("Description", DashboardLocators)) {
				Print("Delivery popup is opened");
				ReportConfig.PassedLogInfo("User add new delivery request","Delivery popup is opened");
			}

			TypeDataInTheField("Description", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 0, ReadFrom.AddRequestDashBoard));
			Print("Description is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 0, ReadFrom.AddRequestDashBoard));
			ReportConfig.PassedLogInfo("User add new delivery request","Description is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 0, ReadFrom.AddRequestDashBoard));

			SelectFromVisibleText("GateDropdown", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 1, ReadFrom.AddRequestDashBoard));
			Print("Gate dropdown is selected as : " + ReadFrom.Excel(AddRequestDashBoard, 1, ReadFrom.AddRequestDashBoard));
			ReportConfig.PassedLogInfo("User add new delivery request","Gate dropdown is selected as : " + ReadFrom.Excel(AddRequestDashBoard, 1, ReadFrom.AddRequestDashBoard));

			SelectFromVisibleText("EquipmentDropdown", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 2, ReadFrom.AddRequestDashBoard));
			Print("Equipment dropdown is selected as : " + ReadFrom.Excel(AddRequestDashBoard, 2, ReadFrom.AddRequestDashBoard));
			ReportConfig.PassedLogInfo("User add new delivery request","Equipment dropdown is selected as : " + ReadFrom.Excel(AddRequestDashBoard, 2, ReadFrom.AddRequestDashBoard));

			Wait(2000);
			try {
				if(IsElementDisplayed("PickingFrom", DashboardLocators)) {

					TypeDataInTheField("PickingFrom", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 5, ReadFrom.AddRequestDashBoard));
					Print("Picking from is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 5, ReadFrom.AddRequestDashBoard));
					ReportConfig.PassedLogInfo("User add new delivery request","Picking from is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 5, ReadFrom.AddRequestDashBoard));

					Wait(2000);
					TypeDataInTheField("PickingTo", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 6, ReadFrom.AddRequestDashBoard));
					Print("Picking to is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 6, ReadFrom.AddRequestDashBoard));
					ReportConfig.PassedLogInfo("User add new delivery request","Picking to is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 6, ReadFrom.AddRequestDashBoard));

				}

			} catch (Exception e) {
				{
					Print("Delivery request equipment is selected");
				}
			}

			Wait(2000);
			TypeDataInTheField("VehicleDetails", DashboardLocators, ReadFrom.Excel(AddRequestDashBoard, 3, ReadFrom.AddRequestDashBoard));
			Print("Vehicle details is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 3, ReadFrom.AddRequestDashBoard));
			ReportConfig.PassedLogInfo("User add new delivery request","Vehicle details is entered as : " + ReadFrom.Excel(AddRequestDashBoard, 3, ReadFrom.AddRequestDashBoard));

			Click("Dfow", DashboardLocators);
			ReportConfig.PassedLogInfo("User add new delivery request","Dfow dropdown is clicked");

			String DfowInExcel = ReadFrom.Excel(AddRequestDashBoard, 4,ReadFrom.AddRequestDashBoard);

			int rowcountofthelist = 	SizeOfTheList("DfowList", DashboardLocators);

			for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
				WebElement Dfow = 	FindElement("DfowInDropdown", DashboardLocators, DropdownValues);
				String DfowInDropdown = 	GetTextFromTheElement(Dfow);

				if(IsEqual(DfowInDropdown, DfowInExcel)){
					Click(Dfow);

					ReportConfig.PassedLogInfo("User add new delivery request","Dfow is selected as : " + DfowInDropdown );
					Print("Dfow is selected as : " + DfowInDropdown );
					break;
				}
			}	

			MoveToElement("SubmitButton", DashboardLocators);

			Click("SubmitButton", DashboardLocators);

			Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			fluentWait11.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Created Successfully.']"));
				}
			});

			if(IsElementDisplayed("DeliveryAdded", DashboardLocators)) {
				Click("DeliveryAdded", DashboardLocators);
				Print("Delivery request added");
			}
			else {
				PrintError("Delivery request add failed");
				ReportConfig.FailedLogInfo("User add new delivery request","Delivery request add failed" );
			}
			Wait(3000);
		}
	}

	public static void AddCompany() throws Throwable {
		
		PrintError("Add Company Started");
		ReadFrom.DynamicExcel(ReadFrom.AddCompanyDashBoard);

			for(int AddCompanyDashBoard =1; AddCompanyDashBoard<=ReadFrom.rowcount; AddCompanyDashBoard++)		{	
				Wait(2000);
				Click("NewCompany", DashboardLocators);
				ReportConfig.PassedLogInfo("To add new companies" ,"New company button is clicked");
				Print("New company button is clicked");

				Wait(5000);
				if(IsElementDisplayed("Dfow", DashboardLocators)) {
					
					Wait(2000);
					TypeDataInTheField("CompanyName", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 0, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("Company name is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 0, ReadFrom.AddCompanyDashBoard));
					Print("Company name is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 0, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
					TypeDataInTheField("AddressLine1", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 2, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("Address line1 is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 2, ReadFrom.AddCompanyDashBoard));
					Print("Address line1 is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 2, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
					ClickEnter();

					Wait(2000);
					TypeDataInTheField("City", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 3, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("City is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 3, ReadFrom.AddCompanyDashBoard));
					Print("City is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 3, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
					TypeDataInTheField("State", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 4, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("State is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 4, ReadFrom.AddCompanyDashBoard));
					Print("State is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 4, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
					TypeDataInTheField("Zipcode", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 5, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("Zipcode is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 5, ReadFrom.AddCompanyDashBoard));
					Print("Zipcode is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 5, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
					TypeDataInTheField("Country", DashboardLocators, ReadFrom.Excel(AddCompanyDashBoard, 6, ReadFrom.AddCompanyDashBoard));
					ReportConfig.PassedLogInfo("Country is entered as : " , ReadFrom.Excel(AddCompanyDashBoard, 6, ReadFrom.AddCompanyDashBoard));
					Print("Country is entered as : " +ReadFrom.Excel(AddCompanyDashBoard, 6, ReadFrom.AddCompanyDashBoard));

					Wait(2000);
						Click("Dfow", DashboardLocators);
						ReportConfig.PassedLogInfo("To add new companies" ,"Dfow dropdown is clicked");

						String DfowInExcel = ReadFrom.Excel(AddCompanyDashBoard, 1,ReadFrom.AddCompanyDashBoard);

						int rowcountofthelist = 	SizeOfTheList("DfowListCompany", DashboardLocators);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowInCompany", DashboardLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);

							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ReportConfig.PassedLogInfo("Dfow is selected as : " , DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
						}
				

					Wait(2000);

					Click("SubmitButton", DashboardLocators);
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

					if(IsElementDisplayed("CompanyAdded", DashboardLocators)){
						Print("Company added is : " + ReadFrom.Excel(AddCompanyDashBoard, 0, ReadFrom.AddCompanyDashBoard));
						ReportConfig.PassedLogInfo("Company added is : " , ReadFrom.Excel(AddCompanyDashBoard, 0, ReadFrom.AddCompanyDashBoard));

					}else {
						PrintError("Company not added");
						ReportConfig.FailedLogInfo("To add new companies" ,"Company not added");
					}
				}
			}
	}
	
	public static void AddMembers() throws Throwable {

		Wait(3000);
		PrintError("Invite members Started");
		ReadFrom.DynamicExcel(ReadFrom.AddMemberDashBoard);
		for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
			
			Wait(3000);
			TypeDataInTheField("EnterMailId", DashboardLocators, ReadFrom.Excel(invite, 0, ReadFrom.AddMemberDashBoard));

			Wait(2000);
			ClickEnter();

			Wait(2000);
			WebElement Email =	FindElement("EnteredMailList" , DashboardLocators, invite) ;

			String EnteredEmail = Email.getText();


			if(IsEqual(EnteredEmail, ReadFrom.Excel(invite, 0, ReadFrom.AddMemberDashBoard))) {
				Print("Entered mail id is : " + ReadFrom.Excel(invite, 0, ReadFrom.AddMemberDashBoard) );
				ReportConfig.PassedLogInfo("Entered mail id is : " , ReadFrom.Excel(invite, 0, ReadFrom.AddMemberDashBoard));
			}
			else {

				PrintError("Email id not entered");
				ReportConfig.FailedLogInfo("User enters members mailid", "Email id not entered");
			}
		}
	}
	
	

	public static void SelectCompany() throws Throwable {
		
	Wait(3000);
	PrintError("Select company Started");
	ReadFrom.DynamicExcel(ReadFrom.AddMemberDashBoard);

	for(int invite =1; invite<=ReadFrom.rowcount; invite++)		{	
		String CompanyInExcel = ReadFrom.Excel(invite, 1,ReadFrom.AddMemberDashBoard);


		WebElement Email =	FindElement("EnteredMailList" , DashboardLocators, invite) ;

		String EnteredEmail = GetTextFromTheElement(Email);

		WebElement	SelectCompany =	FindElement("SelectComanyDropdown" , DashboardLocators, invite);
		Click(SelectCompany);
		ReportConfig.PassedLogInfo("User assign company and role to the member","Select company dropdown is clicked");
		Print("Select company dropdown is clicked");
		Wait(3000);

		List<WebElement> CompanyList = getElements("CompanyListInDropdown", DashboardLocators);
		for(WebElement Value:CompanyList) {
			String	CompanyName = GetTextFromTheElement(Value);

			if(IsEqual(CompanyName, CompanyInExcel)){
				Wait(2000);
				Click(Value);

				Print("Company selected for the member : " + EnteredEmail + " : " + CompanyInExcel);
				ReportConfig.PassedLogInfo("Company selected for the member : " , EnteredEmail + " is : " + CompanyInExcel);
				Wait(3000);
				break;
			}
		}


		String RoleInExcel = ReadFrom.Excel(invite, 2,ReadFrom.AddMemberDashBoard);


		WebElement	SelectRole =	FindElement("SelectRoleDropdown" , DashboardLocators, invite);
		Click(SelectRole);
		ReportConfig.PassedLogInfo("User assign company and role to the member","Select role dropdown is clicked");
		Print("Select role dropdown is clicked");
		Wait(3000);

		List<WebElement> RoleList = getElements("RoleListInDropdown", DashboardLocators);
		for(WebElement Value :RoleList) {
			String	RoleName = GetTextFromTheElement(Value);

			if(IsEqual(RoleName, RoleInExcel)){
				Wait(2000);
				Click(Value);

				Print("Role selected for the member : " + EnteredEmail + " : " + RoleInExcel);
				ReportConfig.PassedLogInfo("Role selected for the member : " , EnteredEmail + " : " + RoleInExcel);
				Wait(3000);
				break;
			}
		}
	}
}
	public static void AddEquipment() throws Throwable {
		


		Wait(3000);
		PrintError("Add equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.AddEquipDashBoard);

		for(int AddEquipDashBoard =1; AddEquipDashBoard<=ReadFrom.rowcount; AddEquipDashBoard++)		{	

			Click("AddNewEquipment", DashboardLocators);
			ReportConfig.PassedLogInfo("To add equipments" ,"Add new equipment button is clicked");
			Print("Add new equipment button is clicked");
			Wait(4000);
			WaitForTheElement("EquipmentName", DashboardLocators);
			if(IsElementDisplayed("EquipmentName", DashboardLocators)) {

				TypeDataInTheField("EquipmentName", DashboardLocators, ReadFrom.Excel(AddEquipDashBoard, 0, ReadFrom.AddEquipDashBoard));
				ReportConfig.PassedLogInfo("Equipment name is entered as : " , ReadFrom.Excel(AddEquipDashBoard, 0, ReadFrom.AddEquipDashBoard));
				Print("Equipment name is entered as : " + ReadFrom.Excel(AddEquipDashBoard, 0, ReadFrom.AddEquipDashBoard));

				Wait(2000);

				SelectFromVisibleText("EquipmentType" , DashboardLocators, ReadFrom.Excel(AddEquipDashBoard, 1, ReadFrom.AddEquipDashBoard));
				ReportConfig.PassedLogInfo("Equipment type is entered as : " , ReadFrom.Excel(AddEquipDashBoard, 1, ReadFrom.AddEquipDashBoard));
				Print("Equipment type is entered as : " + ReadFrom.Excel(AddEquipDashBoard, 1, ReadFrom.AddEquipDashBoard));

				Wait(2000);

				SelectFromVisibleText("ContactPerson" , DashboardLocators, ReadFrom.Excel(AddEquipDashBoard, 2, ReadFrom.AddEquipDashBoard));
				ReportConfig.PassedLogInfo("Contact person is entered as : " , ReadFrom.Excel(AddEquipDashBoard, 2, ReadFrom.AddEquipDashBoard));
				Print("Contact person is entered as : " + ReadFrom.Excel(AddEquipDashBoard, 2, ReadFrom.AddEquipDashBoard));

				Click("SubmitButton", DashboardLocators);
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

			if(IsElementDisplayed("EquipmentAdded", DashboardLocators)) {
				Click("EquipmentAdded", DashboardLocators);
				Print("Equipment added is : " + ReadFrom.Excel(AddEquipDashBoard, 0, ReadFrom.AddEquipDashBoard));
				ReportConfig.PassedLogInfo("Equipment added is : " ,  ReadFrom.Excel(AddEquipDashBoard, 0, ReadFrom.AddEquipDashBoard));
			}
			else {

				PrintError("Equipment is not added");
				ReportConfig.FailedLogInfo("To add equipments" ,"Equipment is not added");
			}
		}
	
		
		
	}
	
	public static void DeleteCompany() throws Throwable {

		PrintError("Delete company Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteDashBoard);

		for(int DeleteDashBoard =1; DeleteDashBoard<=ReadFrom.rowcount; DeleteDashBoard++)	{


			int rowcount = SizeOfTheList("CompanyList", DashboardLocators);

			for(int DeleteButton =2; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement CompanyNames =	FindElement("CompanyLists" ,DashboardLocators, DeleteButton);

				String CompanyNamesList = 	GetTextFromTheElement(CompanyNames);

				String DeleteIt =	ReadFrom.Excel(DeleteDashBoard, 0 , ReadFrom.DeleteDashBoard);
				if(IsEqual(CompanyNamesList, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteCompany" , DashboardLocators, DeleteButton-1);
					Click(Delete);

					Wait(2000);

					Click("YesDelete", DashboardLocators);
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

					if(IsElementDisplayed("CompanyDeleted", DashboardLocators)){
						Print("Company deleted is : " + ReadFrom.Excel(DeleteDashBoard, 0, ReadFrom.DeleteDashBoard));
						ReportConfig.PassedLogInfo("Company deleted is : " , ReadFrom.Excel(DeleteDashBoard, 0, ReadFrom.DeleteDashBoard));
						break;
					}

					else {

						PrintError("Company not deleted");
						ReportConfig.FailedLogInfo("Delete Company" ,"Company not deleted");

						Wait(3000);
					}
				}

			}
		}

	}

	public static void DeleteMembers() throws Throwable {

		PrintError("Delete members Started");

		ReadFrom.DynamicExcel(ReadFrom.DeleteDashBoard);

		for(int DeleteDashBoard =1; DeleteDashBoard<=ReadFrom.rowcount; DeleteDashBoard++)	{
			int rowcount = 	SizeOfTheList("MemberList", DashboardLocators);

			for(int TotalMembers =1; TotalMembers<=rowcount; TotalMembers++)	{

				WebElement MemberList =	FindElement("EmailIdLists" ,DashboardLocators, TotalMembers);

				String MemberLists = 	GetTextFromTheElement(MemberList);

				String DeleteIt =	ReadFrom.Excel(DeleteDashBoard, 1, ReadFrom.DeleteDashBoard);

				if(IsEqual(MemberLists, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteButton" , DashboardLocators ,TotalMembers);
					Click(Delete);

					ReportConfig.PassedLogInfo("User deletes a member from the list", "Delete button is clicked");
					Print("Delete button is clicked");
					Wait(2000);

					Click("DeleteMembers", DashboardLocators);
					ReportConfig.PassedLogInfo("User deletes a member from the list", "Yes delete button is clicked");
					Print("Yes delete button is clicked");

					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);

					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Member Deleted Successfully.']"));
						}
					});

					if(IsElementDisplayed("DeleteMessageSuccessfully", DashboardLocators)){

						Print("Member deleted is : " + ReadFrom.Excel(DeleteDashBoard, 1, ReadFrom.DeleteDashBoard));
						ReportConfig.PassedLogInfo("User deletes a member from the list", "Member deleted is : " + ReadFrom.Excel(DeleteDashBoard, 1, ReadFrom.DeleteDashBoard));
						break;
					}else {
						PrintError("Member not deleted");
						ReportConfig.FailedLogInfo("User deletes a member from the list","Member not deleted");
						Wait(5000);
						break;

					}
				}
			}
		}

	}

	public static void DeleteEquipment() throws Throwable {



		PrintError("Delete equipment Started");
		ReadFrom.DynamicExcel(ReadFrom.DeleteDashBoard);

		for(int DeleteDashBoard =1; DeleteDashBoard<=ReadFrom.rowcount; DeleteDashBoard++)	{


			int rowcount = 	SizeOfTheList("EquipmentList", DashboardLocators);

			for(int DeleteButton =1; DeleteButton<=rowcount; DeleteButton++)	{

				WebElement Equipment =	FindElement("EquipmentLists", DashboardLocators, DeleteButton);

				String EquipmentName = 	GetTextFromTheElement(Equipment);

				String DeleteIt =	ReadFrom.Excel(DeleteDashBoard, 2, ReadFrom.DeleteDashBoard);


				if(IsEqual(EquipmentName, DeleteIt)) {

					Wait(2000);

					WebElement Delete =	FindElement("DeleteEquipButton" ,DashboardLocators, DeleteButton);
					Click(Delete);
					Wait(2000);

					Click("DeleteEquip", DashboardLocators);
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

					if(IsElementDisplayed("EquipmentDeleted", DashboardLocators)){
						Click("EquipmentDeleted", DashboardLocators);
						Print("Equipment deleted is : " + ReadFrom.Excel(DeleteDashBoard, 2, ReadFrom.DeleteDashBoard));
						ReportConfig.PassedLogInfo("Equipment deleted is : " , ReadFrom.Excel(DeleteDashBoard, 0, ReadFrom.DeleteDashBoard));
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

}
