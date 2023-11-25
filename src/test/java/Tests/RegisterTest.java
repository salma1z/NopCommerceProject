package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    public RegisterTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Test
    public void NavigateToRegisterPage() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.RegisterPageAssertion(), "Register");
    driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @Test(priority = 1)
    public void RegisterNewUser() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();

        registerPage = new RegisterPage(driver);
        registerPage.enterUserData(data.firstName, data.lastName, data.day, data.month, data.year);
        registerPage.completeUserData(data.email+currentTime+"@gmail.com", data.company, data.password);
        Assert.assertEquals(registerPage.registerAssertionMessage(),"Your registration completed");
        registerPage.clickContinueButton();

    }
}