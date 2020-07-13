package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ProductPage;

public class HomePageTests extends BaseTests {
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
		int index = 7;
		String nameProductInHomePage = homePage.getNameProduct(index);
		String priceProductInHomePage = homePage.getPriceProduct(index);
		ProductPage productPage = homePage.ClickOnProduct(index);
		String nameProductInProductPage = productPage.getNameProduct();
		String priceProductInProductPage = productPage.getPriceProduct();

		assertThat(nameProductInHomePage.toUpperCase(), is(nameProductInProductPage.toUpperCase()));
		assertThat(priceProductInHomePage, is(priceProductInProductPage));
	}

	@Test
	public void testLoginSuccessfully() {
		LoginPage loginPage = homePage.clickButtonSingIn();
		loginPage.fillEmailField("douglaswillamis@mozej.com");
		loginPage.fillPasswordField(">6gwvTq7y'C'8PJ(");
		loginPage.clickBtnLogin();
		assertThat(homePage.isLogged("Douglas Santana"), is(true));
	}

}
