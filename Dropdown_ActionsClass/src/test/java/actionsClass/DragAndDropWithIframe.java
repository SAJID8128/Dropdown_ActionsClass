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

public class DragAndDropWithIframe {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void dragDropBox1() throws InterruptedException {
		driver.switchTo().frame(2);
		WebElement source = driver.findElement(By.xpath("//body/div[1]/ul[1]/li[1]/img[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();	
		Thread.sleep(1000);
	}
	
	@Test(priority=2)
	public void dragDropBox2() throws InterruptedException {
		//driver.switchTo().frame(2);
		WebElement source = driver.findElement(By.xpath("//body/div[1]/ul[1]/li[1]/img[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();	
		Thread.sleep(1000);
	}
	
	@Test(priority=3)
	public void dragDropBox3() throws InterruptedException {
		//driver.switchTo().frame(2);
		WebElement source = driver.findElement(By.xpath("//body/div[1]/ul[1]/li[1]/img[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();	
		Thread.sleep(1000);
	}
	
	@Test(priority=4)
	public void dragDropBox4() throws InterruptedException {
		//driver.switchTo().frame(2);
		WebElement source = driver.findElement(By.xpath("//body/div[1]/ul[1]/li[1]/img[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
