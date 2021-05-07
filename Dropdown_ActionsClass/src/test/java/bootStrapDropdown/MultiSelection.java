package bootStrapDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelection {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// With line number 24 we are obtaining only the options without the headings.
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li[not(@class='multiselect-item multiselect-group')]/a/label"));
		
		for (WebElement option : options) {
			if(option.findElement(By.tagName("input")).isSelected()) { 
				String optionText = option.getText();
				System.out.println(optionText); 
				
			}
			Thread.sleep(2000);
			driver.close();
		}		
	}
}