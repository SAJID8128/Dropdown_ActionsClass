package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.nike.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void HoverAndClick() throws InterruptedException {
		WebElement sale = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]/li[7]/a[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(sale).
		build().
		perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"DesktopMenu-0-6-0\"]/div/div[2]/a[4]")).click();
		Thread.sleep(6000);

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
