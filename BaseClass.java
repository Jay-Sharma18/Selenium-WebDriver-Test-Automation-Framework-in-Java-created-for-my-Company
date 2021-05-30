package TestClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;   

public class BaseClass 
{	
	public static WebDriver driver;
	public static Logger log; 
	public static ReadConfig config= new ReadConfig();
	public static String url;
	public static String username;
	public static String password;
	public static String Company;
	public static String CompanyPayRun;
	public static String timeStamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	public static String documentCode="TestDoc"+timeStamp;
	public static String Employee1;
	public static String PayrollDepartment;
	public static String PayGroup;
	public static String WorkLocation;
	public static String Trade;
	public static String WCCode;
	public static String PLCode;
	public static String EmployeeZipCode;
	public static String EmployeeSecurityGroup;
	public static String PayRunFrequency;
	public static String EmpHistoryProgName;
	public static String DDEmployee;
	public static String DDBank;
	public static String DDBranch;
	public static String DDcode;
	public static String employeeIdentifier;
	public static String CompanyPayYear;
	public static String CompanyPayPeriod;
	public static String BankProcessing;
	public static String BranchProcessing;
	public static String AccountProcessing;
	
	@Parameters({"browser","environment"})
	@BeforeClass
	public void setup(String br,String environ)
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		url=config.getApplicationURL(environ);
		username=config.getUsername(environ);
		password=config.getPassword(environ);
		CompanyPayRun=config.getPayRun(environ);
		Employee1=config.getEmployee1Name(environ);
		Company=config.getCompany(environ);
		PayGroup = config.getPayGroup(environ);
		PayrollDepartment=config.getPayrollDept(environ);
		WorkLocation=config.getWorkLocation(environ);
		Trade=config.getTrade(environ);
		WCCode=config.getWCCode(environ);
		PLCode=config.getPLCode(environ);
		EmployeeZipCode="60603";
		EmployeeSecurityGroup=config.getEmpSecurityGroup(environ);
		PayRunFrequency=config.getPayRunFrequency(environ);
		EmpHistoryProgName=config.getEmpHistoryProgramName(environ);
		DDEmployee=config.getDDEmployee(environ);
		DDBank=config.getDDBank(environ);
		DDBranch=config.getDDBranch(environ);
		DDcode=config.getDDCode(environ);
		employeeIdentifier=config.getEmployeeNumberIncrementor(environ);
		CompanyPayYear=config.getCompanyPayYear(environ);
		CompanyPayPeriod=config.getCompanyPayPeriod(environ);
		BankProcessing=config.getBankCheck(environ);
		BranchProcessing=config.getBranchCheck(environ);
		AccountProcessing=config.getAccountCheck(environ);
		driver.get(url);   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		log= Logger.getLogger("Payroll/HCM");
		PropertyConfigurator.configure("Log4j.properties");
		log.info("Browser is launched and TestR12 Launch Page is accessed");
		
	}
	
	@AfterClass
	public void tearDown()
	{	
		log.info("Closing Browser");
		driver.quit();
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	

	
}
