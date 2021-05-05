package actionsClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverList {
	
public WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.victoriassecret.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void mouseHoverList() {
		
		List<WebElement> menu = driver.findElements(By.xpath("//header/nav[2]/ul/li"));
		System.out.println(menu.size());
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i).getText());
			WebElement list = menu.get(i);
			System.out.println(list.getAttribute("innerHTML"));
			boolean status1 = list.isEnabled();
			System.out.println(status1);
			boolean status2 = list.isDisplayed();
			System.out.println(status2);
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
