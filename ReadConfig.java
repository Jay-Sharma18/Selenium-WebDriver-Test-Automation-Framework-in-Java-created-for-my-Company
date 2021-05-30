package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL(String environment)
	{
		String url=pro.getProperty("url"+environment.toUpperCase());
		return url;
	}
	
	public String getUsername(String environment)
	{
		String username=pro.getProperty("username"+environment.toUpperCase());
		return username;
	}
	
	public String getPassword(String environment)
	{
		String password=pro.getProperty("password"+environment.toUpperCase());
		return password;
	}
	
	public String getPayRun(String environment)
	{
		String payRun=pro.getProperty("CompanyPayRun"+environment.toUpperCase());
		return payRun;
	}
	
	public String getEmployee1Name(String environment)
	{
		String employee1=pro.getProperty("Employee1"+environment.toUpperCase());
		return employee1;
	}
	
	public String getCompany(String environment)
	{
		String Company=pro.getProperty("Company"+environment.toUpperCase());
		return Company;
	}
	
	public String getPayrollDept(String environment)
	{
		String PayrollDept=pro.getProperty("Department"+environment.toUpperCase());
		return PayrollDept;
	}
	
	public String getPayGroup(String environment)
	{
		String PayGroup=pro.getProperty("PayGroup"+environment.toUpperCase());
		return PayGroup;
	}
	
	public String getWorkLocation(String environment)
	{
		String WorkLocation=pro.getProperty("WorkLocation"+environment.toUpperCase());
		return WorkLocation;
	}
	
	public String getTrade(String environment)
	{
		String Trade=pro.getProperty("Trade"+environment.toUpperCase());
		return Trade;
	}
	
	public String getWCCode(String environment)
	{
		String WCCode=pro.getProperty("WCCode"+environment.toUpperCase());
		return WCCode;
	}
	
	public String getPLCode(String environment)
	{
		String PLCode=pro.getProperty("PLCode"+environment.toUpperCase());
		return PLCode;
	}
	
	public String getEmpSecurityGroup(String environment)
	{
		String SecurityGroup=pro.getProperty("SecurityGroup"+environment.toUpperCase());
		return SecurityGroup;
	}
	
	public String getPayRunFrequency(String environment)
	{
		String payRunFreq=pro.getProperty("PayRunFrequency"+environment.toUpperCase());
		return payRunFreq;
	}
	
	public String getEmpHistoryProgramName(String environment)
	{
		String progName=pro.getProperty("EmpHistoryProgName"+environment.toUpperCase());
		progName=progName.replace(",", " ");
		return progName;
	}
	
	public String getDDEmployee(String environment)
	{
		String DDEmployee=pro.getProperty("EmployeeDirectDeposit"+environment.toUpperCase());
		return DDEmployee;
	}
	
	public String getDDBank(String environment)
	{
		String DDBank=pro.getProperty("BankDirectDeposit"+environment.toUpperCase());
		return DDBank;
	}
	
	public String getDDBranch(String environment)
	{
		String DDBranch=pro.getProperty("BranchDirectDeposit"+environment.toUpperCase());
		return DDBranch;
	}
	
	public String getDDCode(String environment)
	{
		String DDCode=pro.getProperty("CodeDirectDeposit"+environment.toUpperCase());
		return DDCode;
	}
	
	public String getEmployeeNumberIncrementor(String environment)
	{
		String EmployeeNumberIncrement=pro.getProperty("EmployeeNumberIncrementor"+environment.toUpperCase());
		return EmployeeNumberIncrement;
	}
	
	public String getCompanyPayYear(String environment)
	{
		String payYear=pro.getProperty("CompanyPayYear"+environment.toUpperCase());
		return payYear;
	}
	
	public String getCompanyPayPeriod(String environment)
	{
		String payPeriod=pro.getProperty("CompanyPayPeriod"+environment.toUpperCase());
		return payPeriod;
	}
	
	public String getBankCheck(String environment)
	{
		String bank=pro.getProperty("BankCheck"+environment.toUpperCase());
		return bank;
	}
	
	public String getBranchCheck(String environment)
	{
		String branch=pro.getProperty("BranchCheck"+environment.toUpperCase());
		return branch;
	}
	
	public String getAccountCheck(String environment)
	{
		String account=pro.getProperty("AccountCheck"+environment.toUpperCase());
		return account;
	}
	
	
}

