package greenCart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	static WebDriver driver;

	@BeforeSuite
	public void browserInvoke() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({"siteURL"})
	@BeforeTest
	public void url(String siteURL) {
		driver.get(siteURL);
	}
	
	@AfterSuite
	public void browserExit() {
		driver.close();
		driver.quit();
	}

	public ArrayList<String> windowsID() {
		Set<String> windowsID = driver.getWindowHandles();
		ArrayList<String> winID = new ArrayList<String>(windowsID);	
		return winID;

	}
		
}
