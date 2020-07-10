package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	List<WebElement> listProducts = new ArrayList<WebElement>();
	private By products = By.className("H-box");
	private By textProductsInTheCart = By.cssSelector("span#carrinho-qtda-produtos");

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
		quantityProductsInCart = quantityProductsInCart.replaceAll("\\D+","");
		int numberOfProductsInCart = quantityProductsInCart.isEmpty() ? 0 : Integer.parseInt(quantityProductsInCart);
		return numberOfProductsInCart;
	}
}
