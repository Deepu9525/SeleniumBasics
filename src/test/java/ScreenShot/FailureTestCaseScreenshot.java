package ScreenShot;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FailureTestCaseScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("[id='email']"));

        String actualValue = element.getAttribute("value");
        if (actualValue.equals("Expected Value")){
            System.out.println("Test Passed");
        }else {
            File source = element.getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir") + "//Screenshots//FailedTestCase.png";
            Files.copy(source.toPath(), Path.of(filePath));
            System.out.println("Failed testcase screenshot captured");
        }
        driver.quit();
    }
}
