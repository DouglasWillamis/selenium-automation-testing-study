package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	List<WebElement> listProducts = new ArrayList<WebElement>();
	private By products = By.cssSelector("div.row.produtos-home.mg0 div.commerce_columns_item_inner");
	private By textProductsInTheCart = By.id("pedido-qtd-itens");
	private By productsDescription = By.cssSelector("div.row.produtos-home.mg0 div.commerce_columns_item_inner a.prod-name h2 strong");
	private By productsPrice = By.cssSelector("div.row.produtos-home.mg0 div.commerce_columns_item_inner div.prod-new-price span");
	private By productsLink = By.cssSelector("div.row.produtos-home.mg0 div.commerce_columns_item_inner a.prod-name");

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
	
	public String getNameProduct(int index) {
		return driver.findElements(productsDescription).get(index).getText();
	}
	
	public String getPriceProduct (int index) {
		return driver.findElements(productsPrice).get(index).getText();
	}
	
	public ProductPage ClickOnProduct(int index) {
		driver.findElements(productsLink).get(index).sendKeys(Keys.ENTER);
		return new ProductPage(driver);
	}
}
