package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AddToCartPage;
import Pages.HomePage;
import Pages.SearchPage;

public class AddToCartTest extends BaseTest{
    HomePage homePage;
    SearchPage search;
    AddToCartPage add;
    @Test
    public void SearchForMacProduct(){
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage("mac");
    }

    @Test(priority = 1)
    public void NavigateToMacProduct(){
        search = new SearchPage(driver);
        search.navigateToMacProduct();
        Assert.assertEquals(search.getMacProductAssertionMessage(),"Apple MacBook Pro 13-inch");
    }

    @Test(priority = 2)
    public void addProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAddToCartAssertionMessage(),"Apple MacBook Pro 13-inch");
    }
}