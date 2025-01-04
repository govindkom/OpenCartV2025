package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;  //log4j

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;   //Log4j
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup( String br) throws Exception {
	//public void setup() throws Exception {
		
		//Loading config.properties file
		FileReader file= new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		// LOgging 
		logger=LogManager.getLogger(this.getClass());  //log4j code
		
		
		//Grid code
		
		
	
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");return;
		}

		//driver=new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		//driver.get("https://tutorialsninja.com/demo/");
		//Reading url from properties file
		driver.get(p.getProperty("appURL"));   // reading url from properties file  
		
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	// Generate random data
		public String randomString() {
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomNumbers() {
			String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
		}
		
		public String randomAlphaNumeric() {
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			String generatedNumber=RandomStringUtils.randomNumeric(10);
			return generatedString+"@"+generatedNumber;
		}

}

