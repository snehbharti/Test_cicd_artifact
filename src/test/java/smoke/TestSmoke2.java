package smoke;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestSmoke2 {
	
	@Test
	public void getFacebookTitle() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
		Reporter.log(driver.getTitle());
		
	}

}
