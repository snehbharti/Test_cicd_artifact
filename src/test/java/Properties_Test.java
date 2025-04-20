import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Properties_Test {
	// -👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌FinalSetup👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌-\\

	@BeforeSuite
	@Parameters("env")

	public void setup(@Optional("qa") String envFromXml) {
		try {
			System.out.println("Inside Before Suite");
			// Priority: system property > testng.xml param > default "qa"
			String finalEnv = System.getProperty("env") != null ? System.getProperty("env")
					: (envFromXml != null ? envFromXml : "qa");
			System.out.println("System properties is :" + System.getProperty("env"));
			System.out.println("Environment: " + finalEnv);

			ConfigLoader config = new ConfigLoader(finalEnv);

			WebDriver driver = new ChromeDriver();
			driver.get(config.get("base.url"));

			System.out.println("Username from config: " + config.get("username"));
		} catch (

		Exception e) {
			System.out.println("Setup failed: " + e.getMessage());
			// Optionally, throw SkipException to mark tests as skipped
			throw new SkipException("Skipping tests due to setup failure: " + e.getMessage());
		}
		/*
		 * This code prioritizes:
		 * 
		 * Jenkins/system environment (-Denv=xxx)
		 * 
		 * Then testng.xml <parameter name="env" value="xxx"/>
		 * 
		 * Then default "qa"
		 * 
		 * This setup is perfect for CI/CD pipelines like Jenkins 👌
		 */

	}
}
