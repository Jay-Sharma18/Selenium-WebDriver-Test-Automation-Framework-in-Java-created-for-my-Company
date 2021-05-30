package TestClasses;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12TimesheetEntryPage;
import PageClasses.R12UIConsolePage;

public class TC2_TimesheetEntryTest extends BaseClass
{	
	public static String NormalHoursForEmployee1="10";
	public static String ProgramUnderTest="Timesheet Entry";
	
	@Test
	public void TimesheetEntryTest() throws IOException
	{	
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12TimesheetEntryPage timesheets=new R12TimesheetEntryPage(driver);
		log.info("Clicking Enterprise Console product");
		launch.clickEnterpriseConsoleButton();
		log.info("Clicking test12c environment");
		launch.clickTest12CButton();
		log.info("Clicking Launch Software");
		launch.clickLaunchButton();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
		    {
				driver.switchTo().window(windowHandle);
				break;
		    }
		}
		log.info("Entering User ID");
		signIn.enterUserId(username);
		log.info("Entering password");
		signIn.enterPassword(password);
		log.info("Clicking Sign In");
		signIn.clickSignInButton();
		log.info("clicking Go");
		console.clickOkButton();
		log.info("Entering Timesheet Entry in search box and opening Timesheet Entry");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSTimesheetEntryOption();
		log.info("Entering PayRun and confirming its description is updated.");
		timesheets.enterPayRun(CompanyPayRun);
		log.info("Entering Document Code");
		timesheets.enterDocument(documentCode);
		log.info("Clicking Insert Multiple button to insert timesheet rows and waiting for rows to show up");
		timesheets.clickInsertButton();
		log.info("Entering employee in first row");
		timesheets.enterEmployee1(Employee1);
		log.info("Entering Normal Hours for the Employee");
		timesheets.enterNormalHours(NormalHoursForEmployee1);
		log.info("Clicking Save");
		timesheets.clickSaveButton();
		log.info("Timesheet is saved. Testing if hours match or not");
		if(timesheets.returnNHTotalValue().equalsIgnoreCase(NormalHoursForEmployee1))
		{	
			log.info("Hours entered is: "+NormalHoursForEmployee1+" (Hours entered manually)");
			log.info("Hours saved is: "+timesheets.returnNHTotalValue()+" (Hours saved and displayed by system)");
			log.info("Hours match: Testing Passed");
			assertTrue(true);
		}
		else
		{	
			log.info("Hours entered is: "+NormalHoursForEmployee1+" (Hours entered manually)");
			log.info("Hours saved is: "+timesheets.returnNHTotalValue()+" (Hours saved and displayed by system)");
			log.info("Hours do not match: Testing Failed");
			assertTrue(false);
		}
	}
	
}
