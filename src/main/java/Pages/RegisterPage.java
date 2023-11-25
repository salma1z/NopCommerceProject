package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class RegisterPage {
    private final WebDriver driver;
    Select select;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("test-type");
        option.addArguments("--disable-extensions");
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        String URL = "https://demo.nopcommerce.com/";
        driver.get(URL);
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        //driver = new RemoteWebDriver(hubAddress.toURL(), capabilities);

    }

    private final By assertionMessage = By.xpath("//h1[text()='Register']");
    private final By genderButton = By.id("gender-male");
    private final By firstNameTxt = By.id("FirstName");
    private final By lastNameTxt = By.id("LastName");
    private final By dayOfBirth = By.name("DateOfBirthDay");
    private final By monthOfBirth = By.name("DateOfBirthMonth");
    private final By yearOfBirth = By.name("DateOfBirthYear");
    private final By emailTxt = By.id("Email");
    private final By companyTxt = By.id("Company");
    private final By passwordTxt = By.id("Password");
    private final By confirmPasswordTxt = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By registerAssertion = By.xpath("//div[@class='result']");
    private final By continueButton = By.xpath("//a[@class='button-1 register-continue-button']");

    public String RegisterPageAssertion(){
        return driver.findElement(assertionMessage).getText();
    }


    public void enterUserData(String firstName, String lastName, String day, String month, String year){
        driver.findElement(genderButton).click();
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        select = new Select(driver.findElement(dayOfBirth));
        select.selectByVisibleText(day);
        select = new Select(driver.findElement(monthOfBirth));
        select.selectByVisibleText(month);
        select = new Select(driver.findElement(yearOfBirth));
        select.selectByVisibleText(year);
    }

    public void completeUserData(String email, String company, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(companyTxt).sendKeys(company);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPasswordTxt).sendKeys(password);
        driver.findElement(registerButton).click();
        driver.quit();
    }


    public String registerAssertionMessage() {
        return null;
    }

    public String clickContinueButton() {
        return null;
    }
}