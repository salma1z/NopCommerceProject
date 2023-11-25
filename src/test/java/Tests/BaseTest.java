package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;

    public BaseTest(WebDriver driver) {
    }

    public BaseTest() {
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setDriver(@Optional("firefox") String BrowserName){
        if (BrowserName.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.nopcommerce.com/");
        }
        else if (BrowserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.nopcommerce.com/");
        }
    }
    @AfterClass
    public void closeDriver(){
        driver.close();
    }

}