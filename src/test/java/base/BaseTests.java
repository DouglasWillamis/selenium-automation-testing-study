package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BaseTests {

	private static WebDriver driver;
	protected HomePage homePage;

	@BeforeAll
	public static void initialize() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void loadHomePage() {
		driver.manage().window().maximize();
		driver.get("https://marcelodebittencourt.com/demoprestashop/");
		homePage = new HomePage(driver);
	}

	@AfterAll
	public static void finish() {
		driver.quit();
	}
}
