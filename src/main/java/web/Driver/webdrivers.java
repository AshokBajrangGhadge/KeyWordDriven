package web.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class webdrivers  
{
	static WebDriver webDriver;
	
	public static WebDriver webdrivers(String browserName)
	{
		switch(browserName.toLowerCase())
		{
		case "ie":
		{
			System.setProperty("webdriver.ie.driver", "../KeyWordDriven/src/main/java/ObjectRepository/IEDirver/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			webDriver = new InternetExplorerDriver(caps); 
		}
		break;
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "../KeyWordDriven/src/main/java/ObjectRepository/IEDirver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			webDriver = new ChromeDriver(cap);
		}
		break;
		
		case "firefox":
		{
			System.setProperty("webdriver.gecko.driver", "../KeyWordDriven/src/main/java/ObjectRepository/IEDirver/geckodriver64.exe");
			webDriver=new FirefoxDriver();
		}
		break;
		
		
	    default:
	    	System.out.println("Enter Correct Browser name as : ie or chrome or firefox");
        break;
		}
		
		webDriver.manage().window().maximize();
		return webDriver;
		
		}
	}
	
