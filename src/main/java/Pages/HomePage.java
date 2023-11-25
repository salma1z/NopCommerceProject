package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {


    public HomePage(WebDriver driver){super(driver);}
    private final By searchField = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@type='submit']");
    private final By buildYourOwnComputerLink = By.linkText("Build your own computer");
    public RegisterPage NavigateToRegisterPage(){
        ClickBtn("Register");
        return new RegisterPage(driver);}

    public LoginPage NavigateToLoginPage(){
        ClickBtn("Log in");
        return new LoginPage(driver);}
    public  HomePage SearchProduct(String productName){
        driver.findElement(searchField).sendKeys(productName);
        return this;}
    public SearchPage NavigateToSearchPage(){
        driver.findElement(searchBtn).click();
        return new SearchPage(driver);}

    public BuildComputerPage NavigateToBuildComputerPage(){
        driver.findElement(buildYourOwnComputerLink).click();
        return new BuildComputerPage(driver);}

    public void navigateToSearchPage(String mac) {
    }

    public void navigateToLoginPage() {
    }
}

