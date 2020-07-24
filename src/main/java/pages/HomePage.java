package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.StringUtil;

public class HomePage {

	private WebDriver driver;
	List<WebElement> listProducts = new ArrayList<WebElement>();
	private By products = By.className("product-description");
	private By textProductsInTheCart = By.className("cart-products-count");
	private By productsDescription = By.cssSelector(".product-description a");
	private By productsPrice = By.className("price");
	private By btnSingIn = By.cssSelector("div.user-info span.hidden-sm-down");
	private By userNameAccount = By.cssSelector("div.user-info span.hidden-sm-down");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public int sumProducts() {
		loadListProducts();
		return listProducts.size();
	}

	private void loadListProducts() {
		listProducts = driver.findElements(products);
	}

	public int getQuantityOfProductsInTheCart() {
		String quantityProductsInCart = driver.findElement(textProductsInTheCart).getText();
		return Integer.parseInt(quantityProductsInCart.replaceAll("\\D+",""));
	}
	
	public String getProductName(int index) {
		return driver.findElements(productsDescription).get(index).getText();
	}
	
	public Double getProductPrice (int index) {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElements(productsPrice).get(index).getText());
	}
	
	public ProductPage ClickOnProduct(int index) {
		driver.findElements(productsDescription).get(index).click();
		return new ProductPage(driver);
	}
	
	public LoginPage clickButtonSingIn() {
		driver.findElement(btnSingIn).click();
		return new LoginPage(driver);
	}
	
	public boolean isLogged(String userName) {
		return userName.contentEquals(driver.findElement(userNameAccount).getText());
	}
}
