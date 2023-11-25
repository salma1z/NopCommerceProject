
    package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

    public class test {
        public static void main(String[] args) {

            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(option);

            String URL = "https://www.nopcommerce.com/en/register?returnUrl=%2Fen";

            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
        }
    }
