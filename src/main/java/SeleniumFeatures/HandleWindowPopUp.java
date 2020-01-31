package SeleniumFeatures;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("http://popuptest.com//goodpopups.html");
		
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		Thread.sleep(2000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		// https://youtu.be/PUanHXTSlR8?list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&t=667 Iterator picture

		String parentWindowId = it.next();
		System.out.println("parent window id:" + parentWindowId);

		String childWindowId = it.next();
		System.out.println("child window id:" + childWindowId);

		driver.switchTo().window(childWindowId);
		System.out.println("child window pop up title "+ driver.getTitle());

		// close vs quit: closes current browser vs quits all browsers
		Thread.sleep(2000);
		driver.close();

		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title"+ driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();

	}

}
