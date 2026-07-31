package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightingElement {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement highlighting = driver.findElement(By.xpath("//h2[@class='title' and text()='Labels And Links']"));
        js.executeScript("arguments[0].scrollIntoView();", highlighting);
        js.executeScript("arguments[0].style.border='4px solid blue';" +
                "arguments[0].style.background='orange';", highlighting);

        driver.quit();
    }
}
