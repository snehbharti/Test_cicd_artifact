import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Properties_Test {

//	@BeforeSuite
//	@Parameters("env")
//	public void o(@Optional("qa")  String s) {
//		WebDriver driver = new ChromeDriver();
//		String env = System.getProperty("env", "qa"); // default to QA
//		System.out.println("Environment: " + env);
//		ConfigLoader config = new ConfigLoader(env);
//		driver.get(config.get("base.url"));
//		System.out.println(config.get("username"));
//
//	}
	/*
	 * @BeforeSuite
	 * 
	 * @Parameters("env") public void setup(@Optional("qa") String envFromXml) { //
	 * Priority: System property > TestNG XML > default "qa" String finalEnv =
	 * System.getProperty("env") != null ? System.getProperty("env") : (envFromXml
	 * != null ? envFromXml : "qa");
	 * 
	 * System.out.println("Environment: " + finalEnv);
	 * 
	 * ConfigLoader config = new ConfigLoader(finalEnv);
	 * 
	 * WebDriver driver = new ChromeDriver(); driver.get(config.get("base.url"));
	 * 
	 * System.out.println("Username from config: " + config.get("username")); }
	 */
	@BeforeSuite
	@Parameters("env")
	public void setup(@Optional("qa") String envFromXml) {
		System.out.println("Inside Before Suite");
		// Priority: system property > testng.xml param > default "qa"
		String finalEnv = System.getProperty("env") != null ? System.getProperty("env")
				: (envFromXml != null ? envFromXml : "qa");
		System.out.println("System properties is :"+System.getProperty("env"));
		System.out.println("Environment: " + finalEnv);

		ConfigLoader config = new ConfigLoader(finalEnv);

		WebDriver driver = new ChromeDriver();
		driver.get(config.get("base.url"));

		System.out.println("Username from config: " + config.get("username"));
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
