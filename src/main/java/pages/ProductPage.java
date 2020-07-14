package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	private WebDriver driver;
	private By productName = By.className("h1");
	private By productPrice = By.cssSelector("div.current-price span:nth-child(1)");
	private By productSize = By.id("group_1");
	private By productColors = By.cssSelector("ul#group_2 li");
	private By productQuantity = By.id("quantity_wanted");
	private By btnAddToCart = By.className("add-to-cart");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public String getProductPrice() {
		return driver.findElement(productPrice).getText();
	}
	
	private Select findProductSize() {
		return new Select(driver.findElement(productSize))	;
	}
	
	public List<String> getSelectedOptions() {
		List<WebElement> elementsOptions = findProductSize().getOptions();
		List<String> listSelectedOptions = new ArrayList<String>();
		for (WebElement webElement : elementsOptions) {
			listSelectedOptions.add(webElement.getText());
		}
		return listSelectedOptions;
	}
	
	public void selectProductSize(String option) {
		findProductSize().selectByVisibleText(option);
	}
	
	public void selectColorForProduct(int index) {
		driver.findElements(productColors).get(index).click();
	}
	
	public void changeProductQuantity(int quantity) {
		driver.findElement(productQuantity).clear();
		driver.findElement(productQuantity).sendKeys(Integer.toString(quantity));
	}
	
	public void clickButtonAddToCart() {
		driver.findElement(btnAddToCart).click();
	}
}
