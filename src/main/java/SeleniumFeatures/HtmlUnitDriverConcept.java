package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		
		// htmlunitdriver -- to use this concept, we must download htmlunitdriver JAR file.
		// 1. testing is happening behind the scene -- no browser is launched
		// 2. Very fast -- execution of test cases -- very fast -- performance of the script
		// 3. not suitable for Actions class -- user actions -- mousemovement, doubleClick, drag and drop
		// 4. Ghost Driver -- HeadLess Browser.
			// --HtmlUnit Driver --Java
			// --PhantomJS -- JavaScript
		
		//WebDriver driver = new HtmlUnitDriver(); // entering values is not working at all
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://ui.freecrm.com/");
		
		System.out.println("Before login, title is: "+driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("email")).sendKeys("tapio.myllarinen@gmail.com");
		driver.findElement(By.name("password")).sendKeys("L&T#Cogm");
		
		//driver.findElement(By.xpath("//*[@id='ui']/div/div/form/div/div[4]")).click();  //ui fluid large blue submit button
		//driver.findElement(By.className("ui fluid large blue submit button")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[4]")).click(); //Not working for some reason?
		System.out.println("After login, title is: "+driver.getTitle());
		driver.quit();
	}

}
