package MasterClsPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestCases.TestCaseAction;


public class executionReport extends TestCaseAction
{

	public static void executionReportDetails(String ReportFilePath, int TestCaseStepNo) {

		try {
			File dest = new File(ReportFilePath);
			FileInputStream fin = new FileInputStream(dest);
			XSSFWorkbook mywb = new XSSFWorkbook(fin);
			XSSFSheet mysh = mywb.getSheetAt(0);

			mysh.getRow(TestCaseStepNo).getCell(0).setCellValue(TestCaseAction.TestCaseName);
			mysh.getRow(TestCaseStepNo).getCell(1).setCellValue(TestCaseAction.TestCaseStapeNo);
			mysh.getRow(TestCaseStepNo).getCell(2).setCellValue(TestCaseAction.TestCaseStapeStatus);
			mysh.getRow(TestCaseStepNo).getCell(4).setCellValue(TestCaseAction.FailedError);
			// mysh.getRow(i).getCell(3).setCellValue(screnshotcls.screshotpath);

			CreationHelper createHelper = mywb.getCreationHelper();
			CellStyle hlink_style = mywb.createCellStyle();
			Font hlink_font = mywb.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			// XSSFCell cell = mysh.createRow(1).createCell((short)0);
			mysh.getRow(TestCaseStepNo).getCell(3).setCellValue("OpenSceenShot");
			Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
			link.setAddress(screnshotcls.screshotpath);
			mysh.getRow(TestCaseStepNo).getCell(3).setHyperlink(link);
			mysh.getRow(TestCaseStepNo).getCell(3).setCellStyle(hlink_style);

			FileOutputStream fout = new FileOutputStream(dest);

			mywb.write(fout);
		} catch (NullPointerException e) {
			System.out.println("1 : while wrting to file : " + e);
		} catch (Exception e) {
			System.out.println("2 : while wrting to file : " + e);
		}

	}

}
