package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("tapio.myllarinen@gmail.com");
		driver.findElement(By.name("password")).sendKeys("L&T#Cogm");
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		loginBtn.click();
		
	//	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]
	//	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]
		
		//driver.findElement(By.xpath("//[contains(text(), 'Contacts')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		//Method 1: Performance is very poor
		String before_xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
		String after_xpath = "]/td[2]";
		
		for (int i=1; i<=5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains("Tapio Myllarinen")) {
				 driver.findElement(By.xpath(before_xpath + i +  "]/td[1]")).click();
				 Thread.sleep(2000);
				System.out.println("Tapio Myllarinen löytyy kohdasta " + i);
				break;
			}
		}
		
		Thread.sleep(2000);
		// Method 2: Good performance
		// You can create your own xpath with ctrl+f
		//a[contains(text(),'test2 test2']/parent::td//preciding-sibling::td//input[@name='contact_id']
		
		//preceding-sibling & forwarding-sibling (before and after, old and young)
		driver.findElement(By.xpath("//td[contains(text(),'Ville Myllarinen')]/preceding-sibling::td")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
