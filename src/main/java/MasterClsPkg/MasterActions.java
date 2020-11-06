package MasterClsPkg;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ExcelReaderCls.ExcelSheetReader;
import TestCases.TestCaseAction;



public class MasterActions extends ExcelSheetReader
{

	WebDriver driver;
	static String PropertiesFile = "../KeyWordDriven/src/main/java/ObjectRepository/Project.properties";
	public static boolean TestCasePriorityRep = false;
	public static String ExceptionMessage = "Working as per exp. res.";

	public MasterActions(WebDriver driver) {
		this.driver = (WebDriver) driver;

	}

	public void myAction(String SwitchCaseActionName, String LocatorType, String LocatorValue, String TestData,
			String Screenshot) throws Exception {
		// System.out.println("I m in switch : "+SwitchSaseActionName);

		Properties prop = new Properties();
		FileInputStream finp = new FileInputStream(PropertiesFile);
		prop.load(finp);
		MasterActions.ExceptionMessage = "Working as per exp. res.";

		switch (SwitchCaseActionName) {

		case "clickButton": {
			// System.out.println("I m in CLICKBUTTON"+LocatorValue+" "+LocatorType);
			try {
				if (TestData.equalsIgnoreCase("zoomout")) {
					WebElement webelement = driver.findElement(this.getObject(LocatorValue, LocatorType));
					Actions action = new Actions(driver);
					action.contextClick(webelement).build().perform();
				} else {
					driver.findElement(this.getObject(LocatorValue, LocatorType)).click();
				}
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
					
				}

			} catch (ElementNotVisibleException e) {
				try {
					if (TestData.equalsIgnoreCase("zoomout")) {
						try {
							WebElement webelement = driver.findElement(this.getObject(LocatorValue, LocatorType));
							Actions action = new Actions(driver);
							action.contextClick(webelement).build().perform();
						} catch (Exception e1) {
							TestCaseAction.TestCaseStapeStatus = "Fail";
							System.out.println("Exception in clickButton-rightclick Action : " + e1);
							MasterActions.ExceptionMessage = "Exception in clickButton Action-rightclick : "
									+ e1.getMessage().toString();
							TestCaseAction.FailedError = MasterActions.ExceptionMessage;
							if (Screenshot.equalsIgnoreCase("Y")) {
								screnshotcls obj = new screnshotcls(driver);
							}
							if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
								MasterActions.TestCasePriorityRep = true;
								driver.close();
							}
						}
					} else {
						WebElement element = driver.findElement(this.getObject(LocatorValue, LocatorType));
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", element);
					}
					TestCaseAction.TestCaseStapeStatus = "Pass";

					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
				} catch (Exception e1) {
					TestCaseAction.TestCaseStapeStatus = "Fail";
					System.out.println("Exception in clickButton Action : " + e1);
					MasterActions.ExceptionMessage = "Exception in clickButton Action : " + e1.getMessage().toString();
					TestCaseAction.FailedError = MasterActions.ExceptionMessage;
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
					if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
						MasterActions.TestCasePriorityRep = true;
						driver.close();
					}
				}
			} catch (Exception e) {
				System.out.println("Exception in clickButton Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in clickButton Action :   " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}

		}
			break;

		case "setText":

			try {
				driver.findElement(this.getObject(LocatorValue, LocatorType)).sendKeys(TestData);
				TestCaseAction.TestCaseStapeStatus = "Pass";

				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}

			} catch (Exception e) {
				System.out.println("Exception in setText Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				System.out.println("Ashok :: Status is ::" + TestCaseAction.TestCaseStapeStatus);
				MasterActions.ExceptionMessage = "Exception in setText Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();

				}
			}
			break;

		case "getText":

			try {
				String ActualValue = driver.findElement(this.getObject(LocatorValue, LocatorType)).getText();
				System.out.println(ActualValue);
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in getText Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in getText Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
			break;

		case "verifyResult":

			String ActualValue1 = driver.findElement(this.getObject(LocatorValue, LocatorType)).getText();
			try {
				Assert.assertEquals(ActualValue1, TestData);
				System.out.println("Pass");
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (AssertionError e) {
				System.out.println("Fail");
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in verifyResult Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				System.out.println(e.getMessage());
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}

			catch (Exception e) {
				System.out.println("Fail");
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in verifyResult Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				System.out.println("Exception in verifyResult Action : " + e);
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
			break;

		case "launchBrowser":

			try {

				driver.get(prop.getProperty(TestData));
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				// driver.manage().deleteAllCookies();
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				TestCaseAction.TestCaseStapeStatus = "Pass";
			} catch (Exception e) {
				System.out.println("Exception in LaunchBrowser Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in LaunchBrowser Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
			break;

		case "closeBrowser":

			try {

				driver.close();
				driver.quit();
				Thread.sleep(1000);
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}

			}

			catch (Exception e) {
				System.out.println("Exception in closeBrowser Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in closeBrowser Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
			break;

		case "logout": {
			try {
				
				
				((JavascriptExecutor) driver).executeScript("LogOut('../Login.aspx?State=Logout')");
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in logout Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in logout Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "SLEEP": {
			try {
				long sleeptime = Long.parseLong(TestData);
				Thread.sleep(sleeptime);
				System.out.println("In sleep mode");
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: in SLEEP Action " + nfe.getMessage());
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "NumberFormatException: in SLEEP Action "
						+ nfe.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			}

			catch (org.apache.xmlbeans.impl.values.XmlValueDisconnectedException e1) {
				System.out.println("Exception in SLEEP Action : " + e1);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in SLEEP Action : " + e1.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			} catch (Exception e) {
				System.out.println("Exception in SLEEP Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in SLEEP Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "TAB": {
			try {
				driver.findElement(this.getObject(LocatorValue, LocatorType)).sendKeys(Keys.TAB);
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in TAB Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in TAB Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "ClrText": {
			try {
				driver.findElement(this.getObject(LocatorValue, LocatorType)).clear();
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in ClrText Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ClrText Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "SwitchToFrame": {
			if (TestData.equalsIgnoreCase("Parent")) {
				// After you done with child window
				try {
					System.out.println("Current value is " + TestCaseAction.parentWindowHandleq);
					driver.switchTo().window(TestCaseAction.parentWindowHandleq);
					TestCaseAction.TestCaseStapeStatus = "Pass";
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
				}

				catch (Exception e) {
					System.out.println("Exception in SwitchFrame Action : " + e);
					TestCaseAction.TestCaseStapeStatus = "Fail";
					MasterActions.ExceptionMessage = "Exception in SwitchFrame Action : " + e.getMessage().toString();
					TestCaseAction.FailedError = MasterActions.ExceptionMessage;
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
					if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
						MasterActions.TestCasePriorityRep = true;
						driver.close();
					}
				}
			} else if (TestData.equalsIgnoreCase("Child")) {

				try {

					screnshotcls screnshotcls = new screnshotcls(driver);
					screnshotcls.NewWindowScreenShot();
					TestCaseAction.TestCaseStapeStatus = "Pass";
//		        	if(Screenshot.equalsIgnoreCase("Y"))
//					{
//						screnshotcls obj=new screnshotcls(driver);
//					}
				}

				catch (Exception e) {
					System.out.println("Exception in SwitchFrame Action : " + e);
					TestCaseAction.TestCaseStapeStatus = "Fail";
					MasterActions.ExceptionMessage = "Exception in SwitchFrame Action : " + e.getMessage().toString();
					TestCaseAction.FailedError = MasterActions.ExceptionMessage;
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
					if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
						MasterActions.TestCasePriorityRep = true;
						driver.close();
					}
				}
			}

			else {
				try {
					String parentWindowHandle1 = driver.getWindowHandle();
					TestCaseAction.parentWindowHandleq = parentWindowHandle1;
					System.out.println("while first time captured value is " + TestCaseAction.parentWindowHandleq);
					driver.switchTo().frame(prop.getProperty(LocatorValue));
					TestCaseAction.TestCaseStapeStatus = "Pass";
					if (Screenshot.equalsIgnoreCase("Y")) 
					{
						screnshotcls obj = new screnshotcls(driver);
					}
				}

				catch (Exception e) {
					System.out.println("Exception in SwitchFrame Action : " + e);
					TestCaseAction.TestCaseStapeStatus = "Fail";
					MasterActions.ExceptionMessage = "Exception in SwitchFrame Action : " + e.getMessage().toString();
					TestCaseAction.FailedError = MasterActions.ExceptionMessage;
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
					if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
						MasterActions.TestCasePriorityRep = true;
						driver.close();
					}
				}
			}

		}
			break;

		case "AlertHandler": {
			try {

				if (TestData.equalsIgnoreCase("Y")) {
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					// update is executed
					alert.accept();
					TestCaseAction.TestCaseStapeStatus = "Pass";
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
				} else if (TestData.equalsIgnoreCase("N")) {
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					// update is executed
					alert.dismiss();
					TestCaseAction.TestCaseStapeStatus = "Pass";
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}
				}
			} catch (Exception e) {
				System.out.println("Exception in AlertAccept Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in AlertAccept Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "ActionClick": {
			try {
				Actions actions = new Actions(driver);
				WebElement subMenu = driver.findElement(this.getObject(LocatorValue, LocatorType));
				actions.moveToElement(subMenu);
				actions.click().build().perform();
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in ActionClick Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ActionClick Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "ParentFrame": {
			try {
				driver.switchTo().parentFrame();
				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in ParentFrame Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ParentFrame Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}

		}
			break;

		case "JavascriptExecutor": {
			try {
				

				WebElement webelement = driver.findElement(By.xpath("//*[@id='loginUserMenu']"));
				WebDriverWait wait = new WebDriverWait(driver, 10);
//				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(webelement))
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(webelement)));
				

				
				System.out.println("JavascriptExecutor i am " + TestData.equalsIgnoreCase("NA") + "           "
						+ TestData.length());
				if (TestData.equalsIgnoreCase("NA")) {
					System.out.println("I am in If section");
					System.out.println("=================================");
					((JavascriptExecutor) driver).executeScript(prop.getProperty(LocatorValue));
					TestCaseAction.TestCaseStapeStatus = "Pass";
					if (Screenshot.equalsIgnoreCase("Y")) {
						screnshotcls obj = new screnshotcls(driver);
					}

				} else {
					System.out.println("I am in Else section");
					System.out.println("=================================");
					String[] ss = TestData.split("#");
					System.out.println("1st data  " + ss[0] + "                  exe path:" + ss[1]);
					if (ss[0].equalsIgnoreCase("AutoIt")) {

						// ((JavascriptExecutor)driver).executeScript(prop.getProperty(LocatorValue));
						Runtime.getRuntime().exec(ss[1]);
						TestCaseAction.TestCaseStapeStatus = "Pass";
						if (Screenshot.equalsIgnoreCase("Y")) {
							screnshotcls obj = new screnshotcls(driver);
						}
					}

				}
			} catch (Exception e) {
				System.out.println("Exception in JavascriptExecutor Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in JavascriptExecutor Action : "
						+ e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "ElementExist": {
			String actres = "false";
			try {
				if (driver.findElement(this.getObject(LocatorValue, LocatorType)).isDisplayed()) {
					actres = "true";
				}
				Assert.assertEquals(actres, TestData);

				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (AssertionError e) {
				System.out.println("Fail");
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ElementExist Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				System.out.println(e.getMessage());
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			} catch (Exception e) {
				System.out.println("Exception in ElementExist Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ElementExist Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "IsCheckBox": {
			String actres = "false";
			try {
				if (driver.findElement(this.getObject(LocatorValue, LocatorType)).isSelected()) {
					actres = "true";
				}
				Assert.assertEquals(actres, TestData);

				TestCaseAction.TestCaseStapeStatus = "Pass";
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (AssertionError e) {
				System.out.println("Fail");
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in IsCheckBox Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				System.out.println(e.getMessage());
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			} catch (Exception e) {
				System.out.println("Exception in ElementExist Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in ElementExist Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "GVRSelect": {
			try {
				// Grab the table
				Thread.sleep(5000);
				System.out.println("Start");
				WebElement table = driver.findElement(By.id(prop.getProperty(LocatorValue)));

				// Now get all the TR elements from the table
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
				ArrayList al = new ArrayList<>();

				// And iterate over them, getting the cells
				for (WebElement row : allRows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					for (WebElement cell : cells) {

						if (cell.getText().length() > 1) {
							// System.out.println("Value is : "+cell.getText() +"
							// "+cell.getText().length());
							al.add(cell.getText());
						}

					}

					String[] ss = TestData.split("#");
					String date2 = ss[1].replace("/", "-");
					System.out
							.println("1  :" + date2 + "               2: " + ss[1] + "                  MRN:" + ss[0]);

					System.out.println(al + "    ::Size of row arrary :: " + al.size());

					if (al.contains(ss[0]) && (al.contains(ss[1]) || al.contains(date2))) {
						if (Screenshot.equalsIgnoreCase("Y")) {
							screnshotcls obj = new screnshotcls(driver);
						}
						System.out.println("Matching   ::   " + al);
						al.clear();
						// System.out.println("After clear :: "+al);
						driver.findElement(By.id(row.getAttribute("id"))).click();
						break;
					}
					al.clear();
					ss = null;
					// System.out.println("==============================================================================");

				}

			} catch (Exception e) {
				System.out.println("Exception in GVRSelect (i.e. GridViewSelect) Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in GVRSelect (i.e. GridViewSelect) Action : "
						+ e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "CompareTxt": {
			try {
				String[] ss = LocatorValue.split("#");

				driver.findElement(By.id(ss[0])).click();
				String omdcomment = driver.findElement(By.id(ss[0])).getText();
				// System.out.println("Header interp details :: "+omdcomment);
				// Thread.sleep(5000);

				// check whether exist or not so test will not fail with any user(for FMD this
				// tab is not visible)
				if (driver.findElement(By.id("tabmemoInterprepations_T1T")).isDisplayed()) {
					driver.findElement(By.id("tabmemoInterprepations_T1T")).click();
				}

				Thread.sleep(5000);
				driver.findElement(By.id(ss[1])).click();
				String fmdcomment = driver.findElement(By.id(ss[1])).getText();
				// System.out.println("FMD details :: "+fmdcomment);
				Thread.sleep(4000);
				// System.out.println("Result is :: "+omdcomment.contains(fmdcomment));
				if (!(omdcomment.contains(fmdcomment))) {
					TestCaseAction.TestCaseStapeStatus = "Pass";
				} else {
					TestCaseAction.TestCaseStapeStatus = "Fail";
				}

				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
			} catch (Exception e) {
				System.out.println("Exception in CompareTxt Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				MasterActions.ExceptionMessage = "Exception in CompareTxt Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();
				}
			}
		}
			break;

		case "RtClkOp":

			try {
				String[] intp = LocatorValue.split("#");
				System.out.println(intp[0] + "..............................." + intp[1]);
				WebElement webele = driver.findElement(this.getObject(intp[0], LocatorType));
				Actions oAction = new Actions(driver);
				oAction.moveToElement(webele);
				// To perform right click
				oAction.contextClick(webele).build().perform();
				// To select menu after right click
				WebElement elementOpen = driver.findElement(this.getObject(intp[1], LocatorType));
				elementOpen.click();

				TestCaseAction.TestCaseStapeStatus = "Pass";

				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}

			} catch (Exception e) {
				System.out.println("Exception in RtClkOp Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				System.out.println("Ashok :: Status is ::" + TestCaseAction.TestCaseStapeStatus);
				MasterActions.ExceptionMessage = "Exception in RtClkOp Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();

				}
			}
			break;
		// below case not working for now. throwing error as
		// org.apache.xmlbeans.impl.values.XmlValueDisconnectedException
		case "SelectDroDwn":

			try {
				WebElement w1 = driver.findElement((this.getObject(LocatorValue, LocatorType)));
				Select s = new Select(w1);
				// int Index_Of_TestData=Integer.parseInt(TestData);
				// s.selectByIndex(Index_Of_TestData);

				try {
					s.selectByValue(TestData);
					System.out.println("done in first attempt :: selectByValue");
				} // org.openqa.selenium.NoSuchElementException
				catch (org.openqa.selenium.NoSuchElementException e) {
					System.out.println("Not done in first attempt :: selectByValue  " + e);
					try {
						s.selectByVisibleText(TestData);
						System.out.println("done in second attempt :: selectByVisibleText");
					}

					catch (org.openqa.selenium.NoSuchElementException e1) {
						System.out.println("Not done in Second attempt :: selectByVisibleText  " + e1);
						int TestData_converInToInt = Integer.parseInt(TestData);
						s.selectByIndex(TestData_converInToInt);
						System.out.println("done in third attempt :: selectByIndex");
					} catch (Exception e1) {
						System.out.println("Second Inner Try Other than NoSuchElementException  :: " + e1);
					}
				} catch (Exception e) {
					System.out.println("First Outer Try Other than NoSuchElementException  :: " + e);
				}

				TestCaseAction.TestCaseStapeStatus = "Pass";

				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}

			} catch (Exception e) {
				System.out.println("Exception in SelectDroDwn Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				System.out.println("Ashok :: Status is ::" + TestCaseAction.TestCaseStapeStatus);
				MasterActions.ExceptionMessage = "Exception in SelectDroDwn Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();

				}
			}
			break;

		case "Img":

			try {
				File filebb = new File(TestData);
				float ffg = screnshotcls.compareImage(driver, filebb);
				System.out.println("Ashok From Main, Value is " + ffg);
				if (ffg > 95) {
					// driver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(TestData);
					TestCaseAction.TestCaseStapeStatus = "Pass";
				} else {
					TestCaseAction.TestCaseStapeStatus = "Fail";
				}

				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}

			} catch (Exception e) {
				System.out.println("Exception in setText Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				System.out.println("Ashok :: Status is ::" + TestCaseAction.TestCaseStapeStatus);
				MasterActions.ExceptionMessage = "Exception in setText Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();

				}
			}
			break;
			
		case "WaitUntilElement":

			try {
				WebElement webelement = driver.findElement(this.getObject(LocatorValue, LocatorType));
				WebDriverWait wait = new WebDriverWait(driver, 10);
//				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(webelement))
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(webelement)));

			} catch (Exception e) {
				System.out.println("Exception in setText Action : " + e);
				TestCaseAction.TestCaseStapeStatus = "Fail";
				System.out.println("Ashok :: Status is ::" + TestCaseAction.TestCaseStapeStatus);
				MasterActions.ExceptionMessage = "Exception in WaitUntilElement Action : " + e.getMessage().toString();
				TestCaseAction.FailedError = MasterActions.ExceptionMessage;
				if (Screenshot.equalsIgnoreCase("Y")) {
					screnshotcls obj = new screnshotcls(driver);
				}
				if (TestCaseAction.TestCasePriority.equalsIgnoreCase("P1")) {
					MasterActions.TestCasePriorityRep = true;
					driver.close();

				}
			}
			break;

		default:
			break;

		}

	}

	private By getObject(String LocatorValue, String LocatorType) throws Exception {
		Properties prop = new Properties();
		FileInputStream finp = new FileInputStream(PropertiesFile);
		prop.load(finp);

		// Find by xpath
		if (LocatorType.equalsIgnoreCase("XPATH")) {

			// return By.xpath(LocatorValue);
			return By.xpath(prop.getProperty(LocatorValue));
		}
		// find by class
		else if (LocatorType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(LocatorValue);

		}
		// find by name
		else if (LocatorType.equalsIgnoreCase("NAME")) {

			return By.name(LocatorValue);

		}
		// Find by css
		else if (LocatorType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(LocatorValue);

		}
		// find by link
		else if (LocatorType.equalsIgnoreCase("LINK")) {

			return By.linkText(LocatorValue);

		}
		// find by ID
		else if (LocatorType.equalsIgnoreCase("ID")) {

			// return By.id(LocatorValue);
			return By.id(prop.getProperty(LocatorValue));

		}
		// find by partial link
		else if (LocatorType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(LocatorValue);

		} else

		{
			throw new Exception("Wrong object type");
		}

	}



}
