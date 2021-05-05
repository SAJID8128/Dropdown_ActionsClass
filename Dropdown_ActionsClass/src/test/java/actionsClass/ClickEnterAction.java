package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickEnterAction {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void openApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void clickEnter() throws InterruptedException {
		
		driver.findElement(By.name("username")).sendKeys("Batman");
		driver.findElement(By.name("password")).sendKeys("Password");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
