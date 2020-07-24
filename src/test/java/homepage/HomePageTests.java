package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CartPage;
import pages.LoginPage;
import pages.ModalProductPage;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
	private LoginPage loginPage;
	private ProductPage productPage;
	private ModalProductPage modalProductPage;
	
	@Test
	public void testSumProducts() {
		loadHomePage();
		assertThat(homePage.sumProducts(), is(8));
	}

	@Test
	public void testValidateCartEmpty() {
		int productsInCart = homePage.getQuantityOfProductsInTheCart();
		assertThat(productsInCart, is(0));
	}

	@Test
	public void testValidateProductDetail() {
		int index = 0;
		String productNameInHomePage = homePage.getProductName(index);
		Double productPriceInHomePage = homePage.getProductPrice(index);
		productPage = homePage.ClickOnProduct(index);
		String productNameInProductPage = productPage.getProductName();
		Double productPriceInProductPage = productPage.getProductPrice();
		assertThat(productNameInHomePage.toUpperCase(), is(productNameInProductPage.toUpperCase()));
		assertThat(productPriceInHomePage, is(productPriceInProductPage));
	}

	@Test
	public void testLoginSuccessfully() {
		loginPage = homePage.clickButtonSingIn();
		loginPage.fillEmailField("douglaswillamis@mozej.com");
		loginPage.fillPasswordField(">6gwvTq7y'C'8PJ(");
		loginPage.clickBtnLogin();
		loadHomePage();
		assertThat(homePage.isLogged("Douglas Santana"), is(true));
	}
	
	@Test
	public void addProductToCart() {
		if(!homePage.isLogged("Douglas Santana")) {
			testLoginSuccessfully();
		}
		testValidateProductDetail();
		List<String> listOptions = productPage.getSelectedOptions();
		String productSize = productPage.selectProductSize(listOptions.get(1));
		String productColor = productPage.selectColorForProduct(1);
		String productName = productPage.getProductName();
		Double productPrice = productPage.getProductPrice();
		int productQuantity = 3;
		Double subTotalPurchaseAmountCalcule = productPrice * productQuantity;
		productPage.changeProductQuantity(productQuantity);
		modalProductPage = productPage.clickButtonAddToCart();
		assertThat(modalProductPage.getMsgProductSuccessfullyAdded().endsWith("Product successfully added to your shopping cart"), is(true));
		assertThat(modalProductPage.getProductName().toUpperCase(), is(productName.toUpperCase()));
		assertThat(modalProductPage.getProductColor().toUpperCase(), is(productColor.toUpperCase()));
		assertThat(modalProductPage.getProductSize().toUpperCase(), is(productSize.toUpperCase()));
		assertThat(modalProductPage.getProductPrice(), is(productPrice));
		assertThat(modalProductPage.getProductQuantity(), is(Integer.toString(productQuantity)));
		assertThat(modalProductPage.getSubTotalPurchaseAmount(), is(subTotalPurchaseAmountCalcule));
	}

	@Test
	public void goToCart() {
		addProductToCart();
		CartPage cartPage = modalProductPage.clickBtnProceedToCheckout();
		System.out.println(cartPage.getCartSubtotalValue());
		System.out.println(cartPage.getCartTaxvalue());
		System.out.println(cartPage.getCartTotalValueWithoutTax());
		System.out.println(cartPage.getCartTotalValueWithTax());
		System.out.println(cartPage.getProductColor());
		System.out.println(cartPage.getProductPrice());
		System.out.println(cartPage.getProductName());
		System.out.println(cartPage.getProductQuantity());
		System.out.println(cartPage.getProductSize());
		System.out.println(cartPage.getProductSubtotalValue());
		System.out.println(cartPage.getShippingValue());
		System.out.println(cartPage.getSubtotalNumberOfItems());
	}
}
