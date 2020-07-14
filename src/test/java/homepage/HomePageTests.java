package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
	private LoginPage loginPage;
	private ProductPage productPage;
	
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
		String productPriceInHomePage = homePage.getProductPrice(index);
		productPage = homePage.ClickOnProduct(index);
		String productNameInProductPage = productPage.getProductName();
		String productPriceInProductPage = productPage.getProductPrice();

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
		productPage.selectProductSize(listOptions.get(1));
		productPage.selectColorForProduct(1);
		productPage.changeProductQuantity(3);
		productPage.clickButtonAddToCart();
	}


}
