package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12CheckPrintingPage;
import PageClasses.R12CheckProcessingPage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC9_CheckPrinting extends BaseClass
{	
	public static String ProgramUnderTest="Check Printing";
	boolean differentYear=false;

	@Test
	public void TestCheckPrinting()
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12CheckPrintingPage checkprint= new R12CheckPrintingPage(driver);
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
		log.info("Entering Check Printing in search box and opening Check Printing program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSPayrollCheckPrintingOption();
		log.info("Entering Company");
		checkprint.enterCompany(Company);
		log.info("Entering Pay Run");
		checkprint.enterPayRun(CompanyPayRun);
		if(!checkprint.getPayYear().equals(CompanyPayYear))
		{
			checkprint.enterPayYear(CompanyPayYear);
			differentYear=true;
		}
		if(differentYear || !checkprint.getPayPeriod().equals(CompanyPayPeriod))
		{
			checkprint.enterPayPeriod(CompanyPayPeriod);
		}
		log.info("Entering Bank");
		checkprint.enterBank(BankProcessing);
		log.info("Entering Branch");
		checkprint.enterBranch(BranchProcessing);
		log.info("Entering Account Number");
		checkprint.enterAccountNum(AccountProcessing);
		log.info("clicking Print and checking if Reprint Checks Alert is present or not");
		String CheckPrintHandle=driver.getWindowHandle();
		checkprint.clickPrint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newHandle=driver.getWindowHandle();
		if(CheckPrintHandle.equalsIgnoreCase(newHandle))
		{
			driver.switchTo().window(newHandle);
		}
		if(checkprint.ReprintChecksAlertExists())
		{	
			log.info("Reprint Checks Alert detected! Clicking No");
			checkprint.clickNoForReprintChecksAlert();
		}
		else
		{
			log.info("Reprint Checks Alert not detected! This is the first Check Print cycle for this period");
		}
		if(checkprint.returnPrintResultBoxMessage().contains("has been sent to print server"))
		{
			assertTrue(true);
			log.info("Check Printing Completed successfully. Testing Passed!");
		}
		else
		{
			assertTrue(false);
			log.info("Check Printing did not complete successfully. Testing Failed!");
		}
		
		
	
	}
}
