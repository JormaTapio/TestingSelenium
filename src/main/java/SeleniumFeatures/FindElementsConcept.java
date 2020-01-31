package SeleniumFeatures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome
		driver.get("http://www.half.ebay.com");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 1. get the total count of links on the page
		// 2. get the text of each link on the page

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		// size of linkList:
		System.out.println(linkList.size());

		for (int i = 0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}

		driver.close();

	}

}
