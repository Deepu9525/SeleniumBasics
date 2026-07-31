package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("[id='apple']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll bottom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Scroll up
        js.executeScript("window.scrollTo(0,0)");

        //Scroll to element
        WebElement element = driver.findElement(By.cssSelector("[id='comboBox']"));
        //element.click();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);

        List<WebElement> options = driver.findElements(By.xpath("//div[@id='dropdown']//div"));
        System.out.println(options.size());
        for (WebElement option: options){
            System.out.println(option.getText());
            if (option.getText().equals("Item 1")){
                js.executeScript("arguments[0].click();", option);
                break;
            }
        }
        driver.quit();

    }
}
