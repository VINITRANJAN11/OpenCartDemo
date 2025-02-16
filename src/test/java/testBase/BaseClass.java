package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


     public class BaseClass {
	  public WebDriver driver;
	  public Logger logger;  
	  public Properties p;    //Log4j	
	  @BeforeClass
	  @Parameters({"OS","browser"})
	  public void setUp(String os, String brs ) throws IOException 
	  {
		//Loading config.properties file
		FileReader file =new FileReader(".//src/test/resources//config.properties");
		p= new Properties();
		p.load(file);
		  	  
		  
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
          {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) 
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(brs.toLowerCase()) 
			{
			  case "chrome" : capabilities.setBrowserName("chrome"); break;
			  case "edge" :   capabilities.setBrowserName("MicrosoftEdge"); break;
			  default : System.out.println("No matching browser");  return;
			    
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
	     }
		 if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
		 {
			 switch (brs.toLowerCase()) 
			 {
			 case "chrome" : driver= new ChromeDriver(); break;
		     case "edge" : driver = new EdgeDriver(); break;
		     case "firefox" : driver= new FirefoxDriver(); break;
		     default : System.out.println("Invalid browser name..."); return;   
			   
			 
			 
			 }
		 }
		
		 
		  
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get(p.getProperty("appURL")); // Reading URL From properties file
		 driver.manage().window().maximize();
		  	  
	  }
	  
	  @AfterClass
	  public void tearDown() 
	  {
		  driver.quit();  
	  }
	
	//User Define method to generate Auto E-mail , Password etc
	  public String randomeStringee()
	  {
		 String generatedString = RandomStringUtils.randomAlphabetic(7);
	     return generatedString;
	  }
	  
	  public String randomeDigit()
	  {
		 String generatedNumber = RandomStringUtils.randomNumeric(10);
	     return generatedNumber;
	  } 
	  
	  public String randomeAlphanumeric()
	  {
		 String generatedalphanum = RandomStringUtils.randomAlphanumeric(12);
	     return generatedalphanum+"#@";
	  } 
	
	
	
	
	
	
	
	
	
	
	
	

}
