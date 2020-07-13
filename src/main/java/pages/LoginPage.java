package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By email = By.name("email");
	private By password = By.name("password");
	private By btnLogin = By.id("submit-login");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillEmailField(String email) {
		driver.findElement(this.email).sendKeys(email);
	}

	public void fillPasswordField(String password) {
		driver.findElement(this.password).sendKeys(password);
	}

	public void clickBtnLogin() {
		driver.findElement(btnLogin).click();
	}
}
