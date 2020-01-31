package SeleniumFeatures;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.TinyUpload.com/");
		
		//For unknown reason the button click is not working at all...
		//driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
		//driver.findElement(By.name("uploaded_file")).click();
		driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[1]/input[2]"));
		Runtime.getRuntime().exec("C:\\Omat tiedot\\AutoIT\\FileUploadScript.exe");

	}

}
