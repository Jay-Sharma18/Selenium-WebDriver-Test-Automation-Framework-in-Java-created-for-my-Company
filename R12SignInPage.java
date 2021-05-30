package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R12SignInPage 
{
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement UserIdBox;
	
	@FindBy(id="password")
	WebElement PasswordBox;
	
	@FindBy(css = "button[type='submit'][class='btn btn-default col-xs-12']")
	WebElement SignInButton;
	
	public R12SignInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String username)
	{
		UserIdBox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		PasswordBox.sendKeys(password);
	}
	
	public void clickSignInButton()
	{
		SignInButton.click();
	}
	
	
}
