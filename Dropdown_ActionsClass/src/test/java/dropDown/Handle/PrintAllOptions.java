package dropDown.Handle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllOptions {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://twitter.com/i/flow/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@Test(priority=0)
	public void AllOptions() {
		
		WebElement month = driver.findElement(By.xpath("//select[@id='Month']"));
		Select monthSelect = new Select(month);
		List<WebElement>listOfMonths = monthSelect.getOptions();		
		System.out.println(listOfMonths.size());
		for(int i = 0;i < listOfMonths.size();i++) {
		System.out.println(listOfMonths.get(i).getText());
		}
	}
	
	@SuppressWarnings("unused")
	@Test(priority=1)
	public void Assertion() {
		WebElement month = driver.findElement(By.xpath("//select[@id='Month']"));
		Select monthSelect = new Select(month);
		List<WebElement>listOfMonths = monthSelect.getOptions();
		for(int i = 0;i < listOfMonths.size();i++) {
			System.out.println(listOfMonths.get(8).getText());
			Assert.assertEquals(listOfMonths.get(8).getText(),"July","Months do not match,");	
			break;
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
