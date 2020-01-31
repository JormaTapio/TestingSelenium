package SeleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		driver.get("https://html.com/input-type-file/");
		
		// 1. alerts -- JavaScript Pop Up -- Alert API (accept, dismiss)
		// 2. File Upload pop up -- Browse Button (type = file, sendKeys(path) )
		// 3. Browser Window Popup -- Advetisement pop up (windowHandler APi -getWindowHandles() )
		
		try {
		Thread.sleep(5000);
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Temp\\Screenshots.java"); // To select files out of system pop up
		//driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Temp\\Screenshots.java");
		Thread.sleep(20000);
		driver.close();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
