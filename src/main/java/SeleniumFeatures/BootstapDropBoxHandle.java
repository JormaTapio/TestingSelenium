package SeleniumFeatures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstapDropBoxHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));

		System.out.println(list.size());

		// selecting all the checkboxes/options
		String elemName = "";
		int rivi = 0;

		while (rivi < list.size()) {
			try {
				for (int i = rivi; i < list.size(); i++) {
					elemName = list.get(i).getText();
					rivi = i;
					System.out.println(list.get(i).getText());
					if (driver
							.findElement(
									By.xpath("//input[@type='checkbox' and @value='" + list.get(i).getText() + "']"))
							.isSelected())
						list.get(i).click();
				}
			} catch (NoSuchElementException e) {
				System.out.println(elemName + "-WebElement does not have checkbox next to it.");
				rivi++;
			}
		}

		// selecting Angular option
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			if (list.get(i).getText().contains("Angular")) {
//				list.get(i).click();
//				break;
//			}
//		}

	}

}
