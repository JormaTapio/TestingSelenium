package SeleniumFeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
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
//		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
//		driver.findElement(By.xpath("//class[contains(@text(),'Login')]")).click(); 
//		//driver.findElement(By.xpath("//class[contains(@text(),'ui fluid large blue submit button')]")).click(); 
//		//driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click(); // //*[@id="ui"]/div/div/form/div/div[3]

		// executeScript -- to execute Javascript code
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		// loginBtn.click();
		flash(loginBtn, driver); // highlight the element
		drawBorder(loginBtn, driver); // draw a boarder

//		// generate Alert
//		generateAlert(driver, "There is a issue with Login button.");

		// Take creenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copy //method
		FileHandler.copy(src,
				new File("C:\\Omat tiedot\\Java Tapsa\\WorkPlace\\11\\src\\main\\java\\Oma\\freecrm2.png"));
		
//		Thread.sleep(2000);
//		driver.quit();
		
		//refresh 
		//1. by using selenium:
		driver.navigate().refresh();

		//2. by using JS executor:
		refreshElementByJS(driver);
		
		//get the titrle of the page bu JS
		getTitleByJS(driver);
		
		//get the text of the page bu JS
		System.out.println(getPageInnerText(driver));
		
//		//scroll the page down
//		scrollPageDown(driver);
		
		WebElement forgotPwdLink= driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
		//scrollIntoView(forgotPwdLink, driver);
		
//		//click on any element by using JS executor
//		clickElementByJS(loginBtn, driver);
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor"); // "backgroundColor"
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroudColor = '" + color + "'", element); // backgroudColor

		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}
	
	public static void clickElementByJS(WebElement element,WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		}
	
	public static void refreshElementByJS(WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		}
	
	public static String getTitleByJS(WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		}
	
	public static String getPageInnerText(WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
		}
	
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element,WebDriver driver){
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("window.scrollIntoView(true");
		}
}
