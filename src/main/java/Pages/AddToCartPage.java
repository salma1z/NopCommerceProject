package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private By addToCartButton = By.id("add-to-cart-button-4");
    private By viewShoppingCart = By.linkText("shopping cart");
    private By addToCartAssertion = By.linkText("Apple MacBook Pro 13-inch");

    public void addProductToCart(){
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.findElement(viewShoppingCart).click();
    }

    public String getAddToCartAssertionMessage(){
        return driver.findElement(addToCartAssertion).getText();
    }
}