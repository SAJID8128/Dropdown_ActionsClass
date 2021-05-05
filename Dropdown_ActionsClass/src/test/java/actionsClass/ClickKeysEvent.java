package actionsClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickKeysEvent {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void openApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void clickKeys() {
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CLEAR).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ADD).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ALT).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ARROW_LEFT).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ARROW_RIGHT).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.ARROW_UP).pause(Duration.ofSeconds(1)).build().perform();
		action.sendKeys(Keys.END).pause(Duration.ofSeconds(1)).build().perform();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
