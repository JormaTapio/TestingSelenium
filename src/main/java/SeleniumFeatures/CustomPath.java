package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomPath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		driver.get("http://www.half.ebay.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// absolute xpath: not recommended
		// 1. performance issue
		// 2. not reliable
		// 3. can be changed at any time in future
		
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[starts-with(@id,'test-')]")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[ends-with(@id,'_test-t')]")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[contains(@name,'_nkw')]")).sendKeys("Java");
		
		// for link
		// all the links start with a
		driver.findElement(By.xpath("//a[contains(text(),'My account']")).click();
		


	}

}
