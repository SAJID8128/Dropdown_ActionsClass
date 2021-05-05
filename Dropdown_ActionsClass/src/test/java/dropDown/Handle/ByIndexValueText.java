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

public class ByIndexValueText {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void openBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://twitter.com/i/flow/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void IndexValueText() throws InterruptedException {	
	WebElement month = driver.findElement(By.xpath("//select[@id='Month']"));
	Select monthSelect = new Select(month);
	monthSelect.selectByIndex(8);
	Thread.sleep(1000);
	monthSelect.selectByValue("10");
	Thread.sleep(1000);
	monthSelect.selectByVisibleText("December");
	Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void ListOfYears() {	
	WebElement years = driver.findElement(By.xpath("//select[@id='Year']"));
	Select yearsSelect = new Select(years);
	List<WebElement>listOfYears = yearsSelect.getOptions();
	System.out.println(listOfYears.size());
	Assert.assertEquals(listOfYears.size(),"120","List of years do not match,");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
