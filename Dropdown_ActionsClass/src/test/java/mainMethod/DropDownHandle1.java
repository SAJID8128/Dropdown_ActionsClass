package mainMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		/*Select select1 = new Select(month);
		select1.selectByVisibleText("Aug");
		
		Select select2 = new Select(day);
		select2.selectByVisibleText("12");
		
		Select select3 = new Select(year);
		select3.selectByVisibleText("2008");
		Thread.sleep(2000);*/
		
		String dob = "Aug-12-2008";
		String dobArray[] = dob.split("-");
		
		selectValueFromDropDown(month, dobArray[0]);
		selectValueFromDropDown(day, dobArray[1]);
		selectValueFromDropDown(year, dobArray[2]);
		Thread.sleep(2000);
		
		driver.close();
	}
	
	public static void selectValueFromDropDown(WebElement element, String value) {
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}
