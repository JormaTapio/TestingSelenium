package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://ui.freecrm.com/register/");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		
		// 1. isDisplayed() method:  applicanble for all elements
		boolean b1 = loginBtn.isDisplayed();	// for submit button
		System.out.println(b1);				//true

		// 2. isEnabled() method:
		boolean b2 = loginBtn.isEnabled();
		System.out.println(b2);				//true
		
		// 3. isSelected(9 method: only applicable for checkbox, dropdown, radiobutton
		// boolean b3 = driver.findElement(By.name("agreeTerms")).isSelected();

	}

}
