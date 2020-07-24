package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.StringUtil;

public class CartPage {
	private WebDriver driver;
	private By productName = By.cssSelector("div.product-line-info a.label");
	private By productSize = By.cssSelector("div.product-line-info:nth-child(4) span.value");
	private By productPrice = By.cssSelector("span.price");
	private By productColor = By.cssSelector("div.product-line-info:nth-child(5) span.value");
	private By productQuantity = By.className("js-cart-line-product-quantity");
	private By productSubtotalValue = By.cssSelector("span.product-price strong");
	private By subtotalNumberOfItems = By.className("js-subtotal");
	private By cartSubtotalValue = By.cssSelector("div#cart-subtotal-products span.value");
	private By shippingValue = By.cssSelector("div#cart-subtotal-shipping span.value");
	private By cartTotalValueWithoutTax = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(1) span.value");
	private By cartTotalValueWithTax = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(2) span.value");
	private By cartTaxvalue = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(3) span.value");
	
	public CartPage (WebDriver driver) {
		this.driver = driver;
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public String getProductSize() {
		return driver.findElement(productSize).getText();
	}

	public Double getProductPrice() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(productPrice).getText());
	}

	public String getProductColor() {
		return driver.findElement(productColor).getText();
	}

	public int getProductQuantity() {
		return Integer.parseInt(driver.findElement(productQuantity).getAttribute("value"));
	}

	public Double getProductSubtotalValue() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(productSubtotalValue).getText());
	}

	public String getSubtotalNumberOfItems() {
		return driver.findElement(subtotalNumberOfItems).getText();
	}

	public Double getCartSubtotalValue() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(cartSubtotalValue).getText());
	}

	public Double getShippingValue() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(shippingValue).getText());
	}

	public Double getCartTotalValueWithoutTax() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(cartTotalValueWithoutTax).getText());
	}

	public Double getCartTotalValueWithTax() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(cartTotalValueWithTax).getText());
	}

	public Double getCartTaxvalue() {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(cartTaxvalue).getText());
	}
	
	
	
}
