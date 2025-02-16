package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccontRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	  
	  @Test
	  public void verify_account_registration() throws InterruptedException 
	    {
		   logger.info("***Starting TC001_AccountRegistrationTest  ****");
		  try
		  {
		   HomePage hp= new HomePage(driver);
		   hp.clickMyAccount();
		   
		   logger.info("Clck on My Accont Link");
		   hp.clickRegister();
		   
		   AccontRegistrationPage acountregpage = new AccontRegistrationPage(driver); 
		   
		   logger.info("Proving customer details...");
		   acountregpage.setFirstName(randomeStringee().toUpperCase());
		   acountregpage.setLastName(randomeStringee().toLowerCase());
		   acountregpage.setEmail(randomeStringee()+"@gmail.com");
		   acountregpage.setPassword(randomeAlphanumeric());
		   
		   //acountregpage.setNewsletters();
		   
		   WebElement element = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	        
	        WebElement element1 = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
	         
	        Thread.sleep(5000);
	        Actions actions = new Actions(driver);
	        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
	        actions.moveToElement(button).click().perform();
	        
		   
		   //acountregpage.setpvtPolicy();
		   
		   //acountregpage.setclickContinue();
		   
	       logger.info("Validating expected messages...");
		   String confmsg = acountregpage.getConfirmationMsg();
		   
		   Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		  }
		  catch(Exception e) 
		    {
			   logger.error("Test Failed....");
			   logger.debug("Debug logs....");
			   Assert.fail();
		    }
		  logger.info("***Finished TC001_AccountRegistrationTest  ****"); 
	    }
	   
	  
	  
	 
	
	
	
	
	
	
	
	
	
	
	
	

}
