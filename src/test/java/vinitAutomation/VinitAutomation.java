package vinitAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VinitAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/en-gb?route=account/register");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("vinnnv");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("rjommr8");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("vinnnnlp88q@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("vr789bv");


        WebElement element = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        
        WebElement element1 = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
         
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        actions.moveToElement(button).click().perform();
        
       
	}

}
