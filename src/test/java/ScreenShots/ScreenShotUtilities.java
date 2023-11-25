package ScreenShots;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtilities {
        public static void capture(WebDriver driver) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            StringBuffer failedPicPath = new StringBuffer();
            failedPicPath.append("D:\\");
            String fn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
            failedPicPath.append(fn);
            failedPicPath.append(".jpg");
        }
    }

