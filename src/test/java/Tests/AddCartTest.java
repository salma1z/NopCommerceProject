package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ShoppingCartPage;
import Tests.BaseTest;

public class AddCartTest extends BaseTest {

    @Test
    public void addCartTest() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.setDriver(driver);

        shoppingCartPage
                .UserClickOnJewelry()
                .UserSelectProduct()
                .UserAddProductToCart();

        Assert.assertFalse(shoppingCartPage.CheckConfirmationMessage());
    }
}