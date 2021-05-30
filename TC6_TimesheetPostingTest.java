package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12EmployeeProfilePage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12TimesheetPostingPage;
import PageClasses.R12UIConsolePage;

public class TC6_TimesheetPostingTest extends BaseClass 
{
	public static String ProgramUnderTest="Timesheet Posting";
	@Test
	public void testTimesheetPosting()
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12TimesheetPostingPage posting=new R12TimesheetPostingPage(driver);
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
		log.info("Entering Timesheet Posting in search box and opening Timesheet Posting program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSTimesheetPostingOption();
		log.info("Entering Company name");
		posting.enterCompany(Company);
		log.info("Entering Company Pay Run");
		posting.enterPayRun(CompanyPayRun);
		log.info("Entering Company Pay Year");
		posting.enterPayYear(CompanyPayYear);
		log.info("Entering Company Pay Period");
		posting.enterPayPeriod(CompanyPayPeriod);
		log.info("Check Print Reports Flag");
		posting.clickPrintReportsCheckBox();
		log.info("Click Post Button");
		posting.clickPostButton();
		log.info("Verifying whether timesheets have been posted or not");
		if(posting.getPostedBoxText().contains("successfully"))
		{	
			log.info("Timesheets Posted successfully! Testing passed");
			assertTrue(true);
		}
		else
		{	
			log.info("Timesheet Posting failed! Testing Failed");
			assertTrue(false);
		}
		
		
	}
}
