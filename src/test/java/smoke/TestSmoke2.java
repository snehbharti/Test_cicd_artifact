package smoke;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestSmoke2 {
	
	@Test
	public void getFacebookTitle() {
		System.out.println("Test Smoke 2 start");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
		Reporter.log(driver.getTitle(), true);
		System.out.println(driver.getTitle());
		System.out.println("Test Smoke 2 end");
		
	}

}
