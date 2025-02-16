package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccontRegistrationPage extends BasePage {
	
	//WebDriver driver;
	
	public AccontRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']") 
	WebElement newsLetters;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement pvtPolicy;
	//@FindBy(xpath="")
	///////
	
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
	
	
	
	public void setFirstName(String fname) 
	  {
		txtFirstname.sendKeys(fname);
	  }
	
	public void setLastName(String lname) 
	  {
		txtLastname.sendKeys(lname);
	  }
	
	public void setEmail(String email) 
	  {
		txtEmail.sendKeys(email);
	  }
	
	public void setPassword(String pwd) 
	  {
		txtPassword.sendKeys(pwd);
	  }
	//
	
	public void setNewsletters() 
	  {
		newsLetters.click();
	  }
	
	
	public void setpvtPolicy() 
	  {
		pvtPolicy.click();
	  }
	
	
	
	public void setclickContinue() 
	  {
		btnContinue.click();
	  }
	
	//Stepni-Steps
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.el)

     
    	
     public String getConfirmationMsg() {
      try {
	      return (msgConfirmation.getText());
          }
      catch(Exception e) 
        {
    	   return (e.getMessage());
        }
   
      }
    }




