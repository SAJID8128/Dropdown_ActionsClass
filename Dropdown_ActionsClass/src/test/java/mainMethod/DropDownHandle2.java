package mainMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select select2 = new Select(month);
		select2.selectByIndex(8);
		System.out.println(select2.isMultiple());
		
		Select select1 = new Select(day);		
		select1.selectByIndex(12);
		System.out.println(select1.isMultiple());
		
		Select select3 = new Select(year);
		select3.selectByIndex(14);
		System.out.println(select3.isMultiple());
		
		
		List<WebElement> listMonths = select2.getOptions();
		System.out.println(listMonths.size());
		int TotalMonths = listMonths.size()-1;
		System.out.println("Total number of months are: "+ TotalMonths);
		for(int i1=0; i1<listMonths.size(); i1++) {
			String monthValues = listMonths.get(i1).getText();
			System.out.println(monthValues);
		}
		
		List<WebElement> listDays = select1.getOptions();
		System.out.println(listDays.size());
		int TotalDays = listDays.size()-1;
		System.out.println("Total number of days are: "+ TotalDays);
		for(int i2=0; i2<listDays.size(); i2++) {
			String dayValues = listDays.get(i2).getText();
			System.out.println(dayValues);		
		}
		
		List<WebElement> listYears = select3.getOptions();
		System.out.println(listYears.size());
		int TotalYears = listYears.size()-1;
		System.out.println("Total number of years are: "+ TotalYears);
		for(int i3=0; i3<listYears.size(); i3++) {
			String yearValues = listYears.get(i3).getText();
			System.out.println(yearValues);		
		}
		
		driver.close();
			
	}

}
