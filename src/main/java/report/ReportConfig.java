package report;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.follo.baseclass.Baseclass;

public class ReportConfig extends Baseclass{
	public static ExtentTest feature;
	public static ExtentTest scenario;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentTest node;
	public String TestDetail;

	public static String Author, DeviceName, DeviceVersion;

	public static ExtentReports Reports() {
		File OutputFolder = new File("./Report-output");
		if (!OutputFolder.exists()) {
			if (OutputFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create Directory");
			}
		} else {
			System.out.println("Directory already exists");
		}


		extent = new ExtentReports();
		ExtentHtmlReporter spark = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Report-output//FolloWebAutomation_StagingServer.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Follo Automation Report");
		spark.config().setReportName("Regression, SP 1-6");
		extent.attachReporter(spark);

		return extent;
	}

	public static void ReportCooldown() {
		extent.flush();
	}

	public static void ReportCreateFeatureTest(String Title) throws ClassNotFoundException {
		feature = extent.createTest(new GherkinKeyword("Feature"), Title);
	}

	public static void ReportCreateScenarioTest(String Title) throws ClassNotFoundException {
		scenario = feature.createNode(new GherkinKeyword("Scenario"), Title);
	}

	public static void Givenlogpass(String givendetails, String passdetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Given"), givendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}
	
	public static void PassedLogInfo(String givendetails, String passdetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Given"), givendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}
	
	public static void FailedLogInfo(String givendetails, String faildetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Given"), givendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

	public static void Whenlogpass(String whendetails, String passdetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("When"), whendetails).pass(passdetails)
		.addScreenCaptureFromPath(ScreenShot);

	}

	public static void Thenlogpass(String thendetails, String passdetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Then"), thendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

	public static void Andlogpass(String anddetails, String passdetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("And"), anddetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());
	}

	public static void Givenlogfail(String givendetails, String faildetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Given"), givendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());
	}

	public static void Whenlogfail(String whendetails, String faildetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("When"), whendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

	public static void Thenlogfail(String thendetails, String faildetails)
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("Then"), thendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

	public static void Andlogfail(String anddetails, String faildetails )
			throws ClassNotFoundException, IOException {
		String ScreenShot=captureScreenshot();
		scenario.createNode(new GherkinKeyword("And"), anddetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());
	}



}
