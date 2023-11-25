package Tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends BaseTest{


    HomePage homePage;
    RegisterPage registerPage;
    LoginPage log;
    String currentTime = String.valueOf(System.currentTimeMillis());
    @Test
    public void NavigateToRegisterPage(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
       driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Assert.assertEquals(registerPage.RegisterPageAssertion(),"Register");
    }

    @Test(priority = 1)
    public void RegisterNewUser() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();
        registerPage = new RegisterPage(driver);
        registerPage.enterUserData(data.firstName, data.lastName, data.day, data.month, data.year);
        registerPage.completeUserData(data.email+currentTime+"@gmail.com", data.company, data.password);
        Assert.assertEquals(registerPage.registerAssertionMessage(),"Your registration completed");

    }

    @Test(priority = 2)
    public void navigateToLoginPage(){
        homePage = new HomePage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        log = new LoginPage(driver);
        Assert.assertEquals(log.getLoginPageAssertionMessage(),"Welcome, Please Sign In!");
    }

    @Test(priority = 3)
    public void Login() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();
        log = new LoginPage(driver);
        log.EnterUserData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(log.getLoginSuccessfullyAssertionMessage(),"My account");
    }
}