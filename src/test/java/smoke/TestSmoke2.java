package smoke;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestSmoke2 {
	
	@Test
	public void getFacebookTitle() {
		System.out.println("Test Smoke 2 start");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");  // Important for Chrome 109+
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920x1080");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.6998.178 Safari/537.36");
		options.addArguments("--remote-allow-origins=*"); // Sometimes needed to avoid startup failure
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://facebook.com");
		Reporter.log(driver.getTitle(), true);
		System.out.println(driver.getTitle());
		System.out.println("Test Smoke 2 end");
		
	}

}
