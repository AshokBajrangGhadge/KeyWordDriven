package MasterClsPkg;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestCases.TestCaseAction;

public class screnshotcls {
	public static String screshotpath;
	public static WebDriver driver;

	public screnshotcls(WebDriver mydriver)

	{
		driver = mydriver;
		try {

			File scrshot = ((TakesScreenshot) mydriver).getScreenshotAs(OutputType.FILE);
			String myscreshotpath = "C:/Users/c-ashok.ghadge/eclipse-workspace/KeyWordDriven/src/main/java/Report/"
					+ TestCaseAction.TestCaseName.toString() + "/" + TestCaseAction.TestCaseName.toString() + "_" + "Step#"
					+ (TestCaseAction.TestCaseStapeNo) + ".png";
			FileUtils.copyFile(scrshot, new File(myscreshotpath));
			screnshotcls.screshotpath = myscreshotpath;
			// TestCaseAction.TestCaseStapeStatus="Pass";
		} catch (Exception e) {
			System.out.println("Exception in screenshot Action : " + e);
			// TestCaseAction.TestCaseStapeStatus="Fail";
			MasterActions.ExceptionMessage = "Exception in screenshot Action : " + e.getMessage().toString();
			if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
				MasterActions.TestCasePriorityRep = true;
				mydriver.close();
			}
		}
	}

	public static float compareImage(WebDriver driver, File fileB) {
		screnshotcls screnshotcls = new screnshotcls(driver);

		File fileA = new File(screnshotcls.screshotpath);

		System.out.println("File 1 ::  " + fileA);
		System.out.println("File 2 ::  " + fileB);

		float percentage = 0;
		try {
			// take buffer data from both image files //
			BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			int count = 0;
			// compare data-buffer objects //
			if (sizeA == sizeB) {

				for (int i = 0; i < sizeA; i++) {

					if (dbA.getElem(i) == dbB.getElem(i)) {
						count = count + 1;
					}

				}
				percentage = (count * 100) / sizeA;
				if (percentage <= 95) {
					System.out.println("Ashok Image Test Case is Pass");
				}
			} else {
				System.out.println("Both the images are not of same size");
			}

		} catch (Exception e) {
			System.out.println("Failed to compare image files ...");
		}
		return percentage;
	}

	public static void NewWindowScreenShot() throws IOException {

		// all window
		List<String> myallWindows = new ArrayList<String>(driver.getWindowHandles());
		// switch to child window

		driver.switchTo().window(myallWindows.get(1));

		screnshotcls screnshotcls = new screnshotcls(driver);

		driver.close();
		driver.switchTo().window(myallWindows.get(0));

		// System.out.println(browserWindows.get(0));
	}
}
