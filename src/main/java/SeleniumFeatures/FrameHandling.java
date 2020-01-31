package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();			// launch Chrome
		
		driver.manage().window().maximize(); 			// maximize window
		driver.manage().deleteAllCookies(); 			// delete all the cookies
		
		// dynamic wait
	
		//driver.get("https://www.freecrm.com/");
		driver.get("https://ui.freecrm.com/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("tapio.myllarinen@gmail.com");
		driver.findElement(By.name("password")).sendKeys("L&T#Cogm");
		//driver.findElement(By.xpath("//input[@type='submit']")).click(); ////*[@id="ui"]/div/div/form/div/div[3]
		driver.findElement(By.xpath("//*[@id='ui']/div/div/form/div/div[3]")).click();
		//driver.findElement(By.className("Login")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();

	}

}
