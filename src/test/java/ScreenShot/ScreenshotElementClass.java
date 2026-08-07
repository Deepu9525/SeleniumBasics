package ScreenShot;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotElementClass {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //Particular element screenshot
        WebElement element = driver.findElement(By.cssSelector("[id='email']"));
        File source = element.getScreenshotAs(OutputType.FILE);

        String filePath = System.getProperty("user.dir") + "//Screenshots//Screenshot1.png";
        File destination = new File(filePath);

        Files.copy(source.toPath(), destination.toPath());
        driver.quit();

    }
}
