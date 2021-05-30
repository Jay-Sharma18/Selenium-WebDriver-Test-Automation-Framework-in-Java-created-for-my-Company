package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R12LaunchPage 
{
	WebDriver driver;
	
	@FindBy(name="runSoftware")
	WebElement LaunchSoftwareButton;
	
	@FindBy(linkText = "Enterprise Console")
	WebElement EnterpriseConsoleButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[2]/ul/li/a")
	WebElement Test12cButton;
	
	public R12LaunchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLaunchButton()
	{
		LaunchSoftwareButton.click();
	}
	
	public void clickEnterpriseConsoleButton()
	{
		EnterpriseConsoleButton.click();
	}
	
	public void clickTest12CButton()
	{
		Test12cButton.click();
	}
	
}
