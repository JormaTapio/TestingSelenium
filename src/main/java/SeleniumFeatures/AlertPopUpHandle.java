package SeleniumFeatures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	
		
		
		try {
			driver.findElement(By.name("proceed")).click();
			Thread.sleep(5000);
			Alert alert =driver.switchTo().alert();
			
			String text = alert.getText();
			System.out.println(text);
			
			if (text.equals("Please enter a valid user name"))
				System.out.println("You got a correct message.");
			else
				System.out.println("You got an in-correect message. Sorry about that!");
			
			alert.accept(); //click on OK btn (dismiss() clicking cancel btn)
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}

	}

}
