package SeleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver();	// Launch Chrome
		driver.get("http://www.google.com");	// Enter URL

		String title = driver.getTitle();		
		
		System.out.print(title + " is opened a moment, now!\n\n");
		
		// Validation point:
		if (title .contentEquals("Google"))
			System.out.println("Google is opened in browaer.");
		else
			System.out.println("You did not opened web page of Google.");
		
		System.out.println(driver.getCurrentUrl());

		driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Drhf_custrec_newcust&prevRID=S7T7EWDQMT6PG6JHT8BF&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		// 1. xpath (not recomended): --2
		// absolute xath should not be used. -- html/body/div[1]/div[5]/div[2]/a
		//only relative xpath should be used. -- //*[@id ='email']
		//findElement(By.xpath("//*[@id ='email']")).sendKeys("Tom");
		
		// 2. id: --1
		// driver.findElement(By.id("ap_email")).sendKeys("Tom");
		
		// 3.name: --3
		driver.findElement(By.name("email")).sendKeys("Tapsa");
		
		// 4. linkText:
		driver.findElement(By.linkText("Conditions of Use")).click();
		
		// 5. partialLinkText (not useful)
		driver.findElement(By.partialLinkText("Click here to see a non-exhaustive list of applicable ")).click();
		
		// 6. CSSSelector ---2
		// if id is there --- #{id}
		//if class is there --- .{class}
		//driver.findElement(By.cssSelector("#helpsearch")).sendKeys("Select them all");
		//driver.findElement(By.name("helpsearch")).sendKeys("Tapsa&Lea");
		
		driver.quit();
		WebDriver driver1 = new ChromeDriver();
		
		// 7.class name: (not useful) --4
		driver1.get("http://www.google.com");
		driver1.get("https://www.amazon.com/gcx/Gifts-for-Everyone/gfhz/?_encoding=UTF8&ref_=nav_wishlist_gf");
		driver1.findElement(By.className("bxc-grid-overlay__link")).click();
				
		driver1.quit();
	}

}
