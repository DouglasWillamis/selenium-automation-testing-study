package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import base.BaseTests;

public class HomePageTests extends BaseTests {
	@Test
	public void testSumProducts() {
		loadHomePage();
		assertThat(homePage.sumProducts(), is(33)); 
	}
	
	@Test
	public void testValidateCartEmpty() {
		int productsInCart = homePage.getQuantityOfProductsInTheCart();
		assertThat(productsInCart, is(0));
	}
}
