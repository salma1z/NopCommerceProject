package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    // Method to take Screenshot when test case failed
    public static void captureScreenshot(WebDriver driver,String Screenshotname)
    {
        Path dest = Paths.get("./ScreenShots",Screenshotname+".png");

        try {

            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        }catch (IOException e){
            System.out.println("Exception while taking Screenshot"+e.getMessage());
        }

    }
}