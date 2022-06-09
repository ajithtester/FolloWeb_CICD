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


public class F_01_Registeration extends Baseclass {

	public static void SelectPlan(String Plan) throws Throwable {

		switch (Plan) {
		case "Trial Plan":

			Click("TrailPlan", RegisterPageLocators);
		
		ReportConfig.Givenlogpass("User selects the subscription plan", "Trail Plan is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


		 fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
				}
			});

			if(IsElementDisplayed("CloseButton", RegisterPageLocators)) {
				Print("Trial plan is selected");

				ReportConfig.PassedLogInfo("User selects the subscription plan", "Plan selection popup is displayed : Trial plan is selected");

				Click("CloseButton", RegisterPageLocators);
				ReportConfig.PassedLogInfo("User selects the subscription plan", "Close button is clicked");

			}
			else {
				PrintError("Trial plan is not selected successfully");
				ReportConfig.FailedLogInfo("User selects the subscription plan", "Trial plan is not selected successfully");
			}
			break;

		case "Project Plan":

			Click("ProjectPlan", RegisterPageLocators);
			//WebElement ProjectPlan =  WaitForTheElement("ProjectPlan", RegisterPageLocators);

			//	ProjectPlan.click();
			ReportConfig.PassedLogInfo("User selects the subscription plan","Project Plan is clicked");

			if(IsElementDisplayed("PaymentPage", RegisterPageLocators)) {
				ReportConfig.PassedLogInfo("User selects the subscription plan","Payment page is displayed");
				Print("Payment page is displayed");

				SelectFromDropdown("MonthorYear", RegisterPageLocators, ReadFrom.Excel(22, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("User takes subscription for : " , ReadFrom.Excel(22, 1, ReadFrom.Register));

				if(IsEqual(ReadFrom.Excel(22, 1, ReadFrom.Register),("year"))){
					Wait(2000);
					ScrollDown();
					Wait(2000);
					//Click("ProjectPlan", RegisterPageLocators);

				}
				TypeDataInTheField("NameOnTheCard", RegisterPageLocators, ReadFrom.Excel(23, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Name on the card is entered as : " , ReadFrom.Excel(23, 1, ReadFrom.Register));

				TypeDataInTheField("CardNumber", RegisterPageLocators, ReadFrom.Excel(24, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Card number is entered as : " , ReadFrom.Excel(24, 1, ReadFrom.Register));


				SelectFromDropdown("ExpiryMonth", RegisterPageLocators, ReadFrom.Excel(25, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Expiry month is entered as : " , ReadFrom.Excel(25, 1, ReadFrom.Register));

				SelectFromDropdown("ExpiryYear", RegisterPageLocators, ReadFrom.Excel(26, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Expiry year is entered as : " , ReadFrom.Excel(26, 1, ReadFrom.Register));


				TypeDataInTheField("Cvc", RegisterPageLocators, ReadFrom.Excel(27, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("CVC is entered as : " , ReadFrom.Excel(27, 1, ReadFrom.Register));

				Wait(2000);
				SelectFromDropdown("PaymentCountry", RegisterPageLocators, ReadFrom.Excel(28, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("Payment country is selected as : " , ReadFrom.Excel(28, 1, ReadFrom.Register));


				TypeDataInTheField("PaymentzipCode", RegisterPageLocators, ReadFrom.Excel(29, 1, ReadFrom.Register));
				ReportConfig.PassedLogInfo("ZipCode is entered as : " , ReadFrom.Excel(29, 1, ReadFrom.Register));

				Click("Pay", RegisterPageLocators);
				ReportConfig.PassedLogInfo("User selects the subscription plan", "Pay button is clicked");

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				  fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
					}
				});


				if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
					Print("Project plan is selected");
					ReportConfig.PassedLogInfo("User selects the subscription plan","Plan selection popup is displayed : Project plan is selected");

					Click("CloseButton", RegisterPageLocators);
					ReportConfig.PassedLogInfo("User selects the subscription plan","Close button is clicked");
				}
				else {
					PrintError("Project plan is not selected successfully");
					ReportConfig.FailedLogInfo("User selects the subscription plan","Project plan is not selected successfully");
				}


			}
			break;

		case "Enterprise Plan":
			Click("EnterprisePlan", RegisterPageLocators);
			//WebElement EnterprisePlan =  WaitForTheElement("EnterprisePlan", RegisterPageLocators);


			//EnterprisePlan.click();
			ReportConfig.PassedLogInfo("User selects the subscription plan","Enterprise Plan is clicked");

			if(IsElementDisplayed("EnterprisePlanMessage", RegisterPageLocators)) {
				Print("Enterprise plan is selected");
				ReportConfig.PassedLogInfo("User selects the subscription plan","Plan selection popup is displayed : Enterprise plan is selected");
			}
			else {
				PrintError("Enterprise plan is not selected successfully");
				ReportConfig.FailedLogInfo("User selects the subscription plan","Enterprise plan is not selected successfully");
			}

			break;
		default:
			PrintError("Please select the correct plan");
			ReportConfig.PassedLogInfo("User selects the subscription plan","Please select the correct plan");

		}
	}



}
