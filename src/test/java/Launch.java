import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launch {
	public static void main(String[] args) throws AWTException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--profile-directory=Default");
		// // Our systems have detected unusual traffic from your computer network. This
		// // page checks to see if it's really you sending the requests,
		// // and not a robot. Why did this happen?
		// options.addArguments("--disable-blink-features=AutomationControlled");
		// // Both of these options are commonly used to bypass automation detection in
		// // browsers when using Selenium WebDriver.
		// // Note- Use both
		// options.addArguments("--headless");
		// options.addArguments("--disable-gpu"); // Disable GPU usage to avoid crashes
		// options.addArguments("--window-size=1920x1080");
		// options.addArguments("--disable-notifications");
		// options.addArguments(
		// 		"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.6998.178 Safari/537.36");
		// // options.addArguments("--profile-directory=Default");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");  // Important for Chrome 109+
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920x1080");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.6998.178 Safari/537.36");

WebDriver driver = new ChromeDriver(options);

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.desidime.com/");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("toutfix"))).perform();
		List<WebElement> popularStore = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//ul)[7]/li/a")));

		for (WebElement ps : popularStore) {
			System.out.println(ps.getText());
		}

		/*
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("apple")
		 * ; Robot r = new Robot(); r.keyPress(KeyEvent.VK_ENTER);
		 * r.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * System.out.println(driver.getTitle());
		 * System.out.println(driver.getPageSource()); WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(30)); String text = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//div[text()='iPhone 16 Pro']"))) .getText();
		 * System.out.println("End---->" + text);
		 */
	}

}
