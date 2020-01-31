package SeleniumFeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.eclipse.persistence.tools.file.FileUtil;
//import org.h2.store.fs.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShotConcept {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome
		driver.get("http://www.half.ebay.com");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Take creenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile // method
		//FileUtils.copyFile(src, new File("C:\\Omat tiedot\\Java Tapsa\\WorkPlace\\11\\src\\main\\java\\Oma\\google.png"));
		FileHandler.copy(src, new File("C:\\Omat tiedot\\Java Tapsa\\WorkPlace\\11\\src\\main\\java\\Screenshots\\eBay.png"));
		// I can not find this interface
		// I can not find this interface

	}

}
