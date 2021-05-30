package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12DirectDepositPage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC5_DirectDepositTest extends BaseClass
{
	public static String ProgramUnderTest="Direct Deposit";
	public static String priority="1";
	public static String percent1="65";
	public static String accountForDD="54556";
	public static String priority2="2";
	public static String percent2="35";
	
	@Test
	public void testDDProgram() 
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12DirectDepositPage dd=new R12DirectDepositPage(driver);
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
		log.info("Entering Direct Deposit in search box and opening Direct Deposit program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSDirectDepositOption();
		log.info("Entering employee to be setup with Direct Deposit");
		dd.enterEmployee(DDEmployee);
		log.info("clicking Insert button");
		dd.clickInsertButton1();
		log.info("Entering Priority in row 1");
		dd.enterPriority(priority);
		log.info("Entering Percent figure in row 1");
		dd.enterPercentFigure1(percent1);
		log.info("selecting Direct Deposit split type in row 1");
		dd.selectDirectDepositSplitType();
		log.info("Entering Bank in Row 1");
		dd.enterBank(DDBank);
		log.info("Entering Branch in row 1");
		dd.enterBranch(DDBranch);
		log.info("Entering Code in row 1");
		dd.enterCode(DDcode);
		log.info("Entering account number in row 1");
		dd.enterAccountNumber(accountForDD);
		log.info("clicking Save with just 65% figure to ensure system generates proper error message");
		dd.clickSave1();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("clicking Insert for row 2");
		dd.clickInsertButton2();
		log.info("Entering priority in row 2");
		dd.enterPriority2(priority2);
		log.info("Enter percentage figure 2");
		dd.enterPercentFigure2(percent2);
		log.info("clicking Save to save direct deposit setup for the employee");
		dd.clickSave2();
		log.info("Verifiying that saved entries add up to 100%");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dd.returnSavedTotalPercentage().contains("100"))
		{
			assertTrue(true);
			log.info("Testing passed!");
		}
		else
		{
			assertTrue(false);
			log.info("Testing failed!");
		}
		log.info("deleting the saved entries and validating that upon deletion, entries are removed");
		dd.clickDeleteToDeleteAllRows();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("clicking Save after deleting entries and validating that total percent figure after deletion is 0.");
		dd.clickSaveAfterDeletion();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
