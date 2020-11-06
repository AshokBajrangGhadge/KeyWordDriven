package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class RunTestCases extends TestCaseAction{

	public static String TestCaseName;
	public static int TestCaseStapeNo;
	public static String TestCaseStapeStatus = "Pass";
	public String IsNeedToRun;
	public static String TestCasePriority;
	public static int ExecutionTestCaseNo;
	public static String TestCaseTitle;
	public static String FailedError;
	public static String parentWindowHandleq;
	WebDriver webDriver;
    String driverName="chrome";
    public String WorkbookPath;
    public File destFile;
//	STCM
	@BeforeMethod
	public void beforeMethod() throws IOException 
	{
		webDriver=webdrivers(driverName);
		String SourceFileWorkbookPath = "../KeyWordDriven/src/main/java/ActionControllerExcelSheet/HV_TestCases_Selenium.xlsx";
		WorkbookPath = "../KeyWordDriven/src/main/java/ActionControllerExcelSheet/HV_TestCases_SeleniumTemp.xlsx";
		File srcFile=new File(SourceFileWorkbookPath);
		destFile=new File(WorkbookPath);
		FileUtils.copyFile(srcFile, destFile);
	}

	@Test(enabled = true)
	public void LoginTestCase1() throws IOException
	{
//		WebDriver webDriver=webdrivers("firefox");
//		webDriver.get("https://www.google.com/");
		testCaseMethods("TC1",webDriver,WorkbookPath);

	}
	
	@Test(enabled = true )
	public void LoginTestCase2() throws IOException
	{
//		WebDriver webDriver1=webdrivers("chrome");
//		webDriver1.get("https://www.google.com/");
		testCaseMethods("TC1",webDriver,WorkbookPath);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		destFile.delete();
	}
}
