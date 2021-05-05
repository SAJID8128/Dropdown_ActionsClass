package mainMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle3 {

	public static void main(String[]args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> monthList = driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(monthList.size());

		for(int i=0; i<monthList.size(); i++) {
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals("Aug")) {
				monthList.get(i).click();
				break;
			}									
		}
		
		tearDown();
		driver.close();
	}
	
	public static void tearDown() throws InterruptedException {
		Thread.sleep(1000);
	}
}
