package ExcelReaderCls;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import web.Driver.webdrivers;

public class ExcelSheetReader extends webdrivers {

	public static XSSFWorkbook f;

	public static Sheet getSheetName(String filePath, String sheetName) throws IOException {
		FileInputStream fs = new FileInputStream(filePath);
//		this.f=new XSSFWorkbook(fs);
		f = new XSSFWorkbook(fs);
//		XSSFSheet sh = this.f.getSheet(sheetName);
		XSSFSheet sh = f.getSheet(sheetName);
		FileOutputStream fout = new FileOutputStream(filePath);
//		this.f.write(fout);	
		f.write(fout);
		return sh;
	}

}