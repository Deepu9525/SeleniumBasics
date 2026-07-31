package JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //zoom out
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        Thread.sleep(500);

        String zoom = (String)js.executeScript("return document.body.style.zoom;");
        System.out.println("Zoom size: " + zoom);

        //zoom in
        js.executeScript("document.body.style.zoom='120%'");
        Thread.sleep(500);

        //Reset
        js.executeScript("document.body.style.zoom='100%'");
        Thread.sleep(500);
        driver.quit();
    }
}
