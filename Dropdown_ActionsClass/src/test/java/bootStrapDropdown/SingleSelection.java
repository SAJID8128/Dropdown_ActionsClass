package bootStrapDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelection {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@id='btnDropdownDemo']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu')]/a"));
				
		for (WebElement option : options) {
			String optionText = option.getText();
//			if(optionText.equals("jQuery")) {
//				option.click();
//				break;
//		}	
				
		System.out.println(optionText);
		
		}
		driver.close();
	}
}
