package selenium;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Spicejet {

	public static void main(String[] args) throws InterruptedException {
		
		//Launching Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//WebDriverWait wait =new WebDriverWait(driver,60);
		
		//Maximize window
		driver.manage().window().maximize();
		//Launching url
		driver.get("https://www.spicejet.com/");
		//Clicking on round trip radio button
		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		
		//Sending keys to Departure city
		WebElement eleFrom = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		eleFrom.sendKeys("ch");
		
		//To wait
		Thread.sleep(5000);
		//clicking on Chennai
		WebElement eleLoc = driver.findElement(By.xpath("//a[@value='MAA']"));
		eleLoc.click();
		//wait.until(ExpectedConditions.elementToBeClickable(eleLoc));
		
		Thread.sleep(3000);
		//Sending keys to To city
	    WebElement eleTo=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
	    eleTo.sendKeys("BLR");
	    
	   //Clicking dates from calendar
	    driver.findElement(By.xpath("((//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td[4])[2]")).click();
	    
	    Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
	    driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[6]")).click();

	    Thread.sleep(3000);
	    //Selecting 2 adults from Passengers
	    driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
  
	    //Selecting USD from the dropdown
	    WebElement currency = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
	    Select se=new Select(currency);
	    se.selectByVisibleText("USD");
	    
	    //Clicking on search button
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}
