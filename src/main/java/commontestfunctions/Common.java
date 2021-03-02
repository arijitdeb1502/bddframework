package commontestfunctions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.xml.DOMConfigurator;

public class Common {
	
	public static WebDriver driver=null;
	
	public static WebDriver initializeDriver() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		Log.info("Loading automation configuration from AutomationConfiguration.properties");
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("src//main//resources//AutomationConfiguration.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		String chromeDriverLocation=prop.getProperty("chromeDriverLocation");
		
		if(browserName.equals("Chrome")) {
			
			Log.info("Initializing the chrome driver");
			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
			driver=new ChromeDriver();
			
			Log.info("Maximizing the browser");

			driver.manage().window().maximize();
			
		}else if(browserName.equals("Firefox")) {
			
			System.out.println("Write code for loading firefox driver");
			
		}else if(browserName.equals("IE")) {
			
			System.out.println("Write code for loading IE driver");
		
		}
		
		String timeOutForEachTestInSec=prop.getProperty("timeOutForEachTestInSec");
		Long timeOutForEachTest=Long.parseLong(timeOutForEachTestInSec);
		driver.manage().timeouts().implicitlyWait(timeOutForEachTest, TimeUnit.SECONDS);

		return driver;
	}
	
	public static void unInitializeDriver() {
		
		Log.info("Uninitializing the driver");
		
		driver.close();
		driver.quit();
		
	}

}
