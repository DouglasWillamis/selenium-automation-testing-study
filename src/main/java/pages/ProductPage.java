package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	private WebDriver driver;
	private By productName = By.className("tit-prod");
	private By productPrice = By.id("valVista");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getNameProduct() {
		return driver.findElement(productName).getText();
	}
	
	public String getPriceProduct () {
		return driver.findElement(productPrice).getText();
	}
}
