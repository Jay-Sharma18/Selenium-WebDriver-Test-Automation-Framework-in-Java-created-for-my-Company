package TestClasses;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC1_LoginTest extends BaseClass   
{	
	
	@Test
	public void testLogin() throws IOException 
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		log.info("Clicking Enterprise Console product");
		launch.clickEnterpriseConsoleButton();
		log.info("Selecting the test environment");                
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
		
		if(driver.getTitle().contains("UIConsole - Standard Console"))      
		{	
			log.info("Successfully Signed in. Test Passed!");
			assertTrue(true);
		}
		else
		{	
			try 
			{
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			captureScreen(driver, "testLogin");
			log.info("Couldnt Sign in. Testing Failed!");
			assertTrue(false);
		}
	}
	
	
}
