package ScreenShot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenShotCompleteClass {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //Complete webpage screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        //Create screenshot folder
        String folderPath = System.getProperty("user.dir") + "//Screenshots";
        File screenShotFolder = new File(folderPath);

        if (!screenShotFolder.exists()){
            screenShotFolder.mkdirs();
        }

        //Relative project path
        //String screenshotPath = System.getProperty("user.dir") + "//Screenshots//Screenshot.png";
        String screenshotFilePath = folderPath + "//Screenshot.png";
        File destination = new File(screenshotFilePath);

        //Copy screenshot
        Files.copy(source.toPath(), destination.toPath());
        driver.quit();

    }
}
