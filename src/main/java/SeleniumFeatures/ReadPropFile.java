package SeleniumFeatures;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropFile {

	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Omat tiedot\\Java Tapsa\\WorkPlace\\11\\src\\main\\java\\Oma\\config.properties");

		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("wname"));
		
		

		String url = prop.getProperty("URL");
		System.out.println(url);

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
			 driver = new ChromeDriver();	// Launch Chrome
			}
		else if (browserName.equals("FF"))
			{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\geckodriver.exe"); // in windows
			//driver = new FirefoxDriver();	// Launch Chrome
			System.out.println("Firefox is needed");
			}
		else if (browserName.equals("IE"))
			{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\internetexplorerdriver.exe"); // in windows
			//driver = new InternetExplorerDriver();	// Launch Chrome
			System.out.println("Internet Explorer is needed");
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		driver.findElement(By.xpath(prop.getProperty("firstName_xpath"))).sendKeys(prop.getProperty("firstName"));
//		driver.findElement(By.xpath(prop.getProperty("lastName_xpath"))).sendKeys(prop.getProperty("lastName"));
//		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
		
		driver.findElement(By.xpath(prop.getProperty("firstName_name"))).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath(prop.getProperty("lastName_name"))).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath(prop.getProperty("phone_name"))).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.xpath(prop.getProperty("password_name"))).sendKeys(prop.getProperty("password"));
		
		driver.close();

	}

}
