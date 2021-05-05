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

public class MultiLinks {
	
	public WebDriver driver = null;
	
	@BeforeTest
	public void openApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.puregrips.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void doubleClickAction() throws InterruptedException {
		
		WebElement shop = driver.findElement(By.xpath("//body/main[@id='panel']/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]"));
		WebElement grips = driver.findElement(By.xpath("//body/main[@id='panel']/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
		WebElement pro = driver.findElement(By.xpath("//body/main[@id='panel']/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]"));
		Actions action = new Actions(driver);
		//action.moveToElement(shop).build().perform();
		//action.moveToElement(grips).build().perform();
		//action.moveToElement(pro).click().build().perform();
		action.moveToElement(shop).moveToElement(grips).moveToElement(pro).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}
