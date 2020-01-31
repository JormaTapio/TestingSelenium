package SeleniumFeatures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("tapio.myllarinen@gmail.com");
		driver.findElement(By.name("password")).sendKeys("L&T#Cogm");

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		loginBtn.click();

		driver.findElement(By.linkText("Calendar")).click();

		String date = "33-February-2019";
		String dateArr[] = date.split("-"); // {26,June,1965}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		boolean flag1 = true;
		while (flag1) {
			if (driver.findElement(By.xpath("//span[@class='rbc-toolbar-label']")).getText()
					.equals(month + " " + year)) {
				try {
					driver.findElement(By.xpath("//a[contains(text(),'" + day + "')]")).click();
					System.out.println("The date should be find out:" + date);
				} catch (NoSuchElementException e) {
					System.out.println("Please, enter a correct date! This is wrong date ===> "+day+"-"+month + "-" + year);
				}
				flag1 = false;
			} else {
				System.out.println("You still have to find out right year and mount!" + month + " " + year);
				System.out.println(driver.findElement(By.xpath("//span[@class='rbc-toolbar-label']")).getText());
				driver.findElement(By.xpath("//i[@class='chevron left icon']")).click();
			}
		}

		Thread.sleep(2000);
		//driver.close();

//		Select select = new Select(driver.findElement(By.name("slcMonth")));
//		select.selectByVisibleText(month);
//
//		Select select1 = new Select(driver.findElement(By.name("slcYear")));
//		select.selectByVisibleText(year);
		// rivi/viikko päivä
		// *[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[3]
		// //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[4]
		// *[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[3]
		// //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[4]
		// ...
		// *[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[6]/div[1]/div[3]
		// //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[6]/div[1]/div[4]

//		String beforeXpath = "//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[";
//		String afterXpath = "]/div[1]/div[";
//		final int totalWeekDays = 7;

		// 2-1 2-2 2-3 2-4 2-5 2-6 2-7
		// 3-1 3-2 3-3 3-4 3-5 3-6 3-7
//		boolean flag = false;
//		String dayVal = null;
//		for (int rowNum = 2; rowNum <= 7; rowNum++) {
//			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
//				
//				try {
//				String dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + "]")).getText();
//				}catch (NoSuchElementException e){
//					System.out.println("Please enter a correct date value");
//					flag = false;
//					break;
//				}
//				System.out.println(dayVal);
//				if (dayVal.equals(day)) {
//					driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum)).click();
//					flag = true;
//					break;
//				}
//			}
//			if (flag) {
//				break;
//			}
//		}
	}

}
