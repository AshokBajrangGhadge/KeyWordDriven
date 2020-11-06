package TestCases;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import ExcelReaderCls.ExcelSheetReader;
import MasterClsPkg.MasterActions;
import MasterClsPkg.executionReport;
import MasterClsPkg.screnshotcls;



public class TestCaseAction extends ExcelSheetReader {

	public static String TestCaseName;
	public static int TestCaseStapeNo;
	public static String TestCaseStapeStatus = "Pass";
	public String IsNeedToRun;
	public static String TestCasePriority;
	public static int ExecutionTestCaseNo;
	public static String TestCaseTitle;
	public static String FailedError;
	public static String parentWindowHandleq;
	

	public static void testCaseMethods(String TestCaseName, WebDriver webDriver, String filePath) throws IOException {
		try {
			Logger loger=LogManager.getLogger(TestCaseAction.class);
			String WorkbookPath=filePath;
		
			// To get total number of test cases to be execute.. Set as 0
			ExecutionTestCaseNo = 0;
			TestCaseAction.TestCaseName = "TC1";
			Sheet sh = ExcelSheetReader.getSheetName(WorkbookPath, "ECGMSTC");
			Row r;
			int j = sh.getLastRowNum() - sh.getFirstRowNum();
			MasterActions obj = new MasterActions(webDriver);
			int stepno = 1;
			System.out.println("Start");
			try {
				for (int i = 1; i <= j; i++) {
					MasterActions.TestCasePriorityRep = false;
					TestCaseAction.TestCaseStapeNo = stepno;
					r = sh.getRow(i);
					TestCaseAction.TestCasePriority = r.getCell(9).toString();

					// Check same test case step is execution
					if (r.getCell(0).toString().equalsIgnoreCase(TestCaseAction.TestCaseName)) {

						if (r.getCell(10).toString().equalsIgnoreCase("N"))
							;
						{
							screnshotcls.screshotpath = "";
						}

						// Code to call MasterAction method.
						obj.myAction(r.getCell(4).toString(), r.getCell(6).toString(), r.getCell(7).toString(),
								r.getCell(8).toString(), r.getCell(10).toString());

						// Write Report
						String ReportFile = "../KeyWordDriven/src/main/java/Report/Report.xlsx";
						executionReport.executionReportDetails(ReportFile, i);

						// Code to get Test Case Title Name
						if (stepno == 1) {
							TestCaseAction.TestCaseTitle = r.getCell(1).toString();
						}

						// Code to Decide stop test case execution based on Priority of test step
						if (MasterActions.TestCasePriorityRep == true)
							break;

						stepno = stepno + 1;
					}

				}

			} catch (NoSuchElementException e) {

				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
//				System.out.println("Test Case Exception " + e.getMessage());
			}
			System.out.println("Done");

		} catch (Exception e) {
//			System.out.println(e);
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		}
	}

}
