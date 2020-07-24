package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import util.StringUtil;

public class ModalProductPage {
	
	private WebDriver driver;
	private By msgProductSuccessfullyAdded = By.id("myModalLabel");
	private By productName = By.cssSelector("h6.product-name");
	private By productPrice = By.cssSelector("p.product-price");
	private By listReportedVaues = By.cssSelector("div.divide-right div.col-md-6:nth-child(2) span strong");
	private By subTotalPurchaseAmount = By.cssSelector("div.cart-content p:nth-child(2) span.value");
	private By btnProceedToCheckout = By.cssSelector("div.cart-content-btn a.btn-primary");
	
	public ModalProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getMsgProductSuccessfullyAdded() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(msgProductSuccessfullyAdded));
		return driver.findElement(msgProductSuccessfullyAdded).getText();
	}
	
	public String getProductName () {
		return driver.findElement(productName).getText();
	}
	
	public Double getProductPrice () {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(productPrice).getText());
	}
	
	public String getProductSize() {
		return driver.findElements(listReportedVaues).get(0).getText();
	}
	
	public String getProductColor() {
		return driver.findElements(listReportedVaues).get(1).getText();
	}
	
	public String getProductQuantity() {
		return driver.findElements(listReportedVaues).get(2).getText();
	}

	public Double getSubTotalPurchaseAmount () {
		return StringUtil.stringForDoubleWithoutMoneySign(driver.findElement(subTotalPurchaseAmount).getText());
	}
	
	public CartPage clickBtnProceedToCheckout() {
		driver.findElement(btnProceedToCheckout).click();
		return new CartPage(driver);
	}
}
