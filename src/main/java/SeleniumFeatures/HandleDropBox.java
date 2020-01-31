package SeleniumFeatures;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		driver.get("http://www.google.com");	// Enter URL

		driver.get("https://www.amazon.com/?gwHistory=eyJ3YXNSZWMiOmZhbHNlLCJ3YXNTcGVjaWFsU2xvdHMiOmZhbHNlLCJ3YXNQZXJjb2xhdGUiOmZhbHNlLCJ0aW1lIjoxNTc3NzUxNjc1NjA1fQ==");
		
		// Handle drop box:
		
		Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		select.selectByVisibleText("Digital Music");
		//driver.findElement(By.id("nav-input")).click();
		//driver.findElement(By.cssSelector("#nav-input")).click();
	}
}
