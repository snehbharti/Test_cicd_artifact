import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Properties_Test {

	@BeforeSuite
	@Parameters("env")
	public void o(String s) {
		WebDriver driver = new ChromeDriver();
		String env = System.getProperty("env", "qa"); // default to QA
		System.out.println("Environment: " + env);
		ConfigLoader config = new ConfigLoader(env);
		driver.get(config.get("base.url"));
		System.out.println(config.get("username"));

	}

}
