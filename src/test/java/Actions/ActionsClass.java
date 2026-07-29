package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Mouse Hover
        Actions action = new Actions(driver);
        WebElement mouseHover = driver.findElement(By.cssSelector("[class='dropbtn']"));
        action.moveToElement(mouseHover).perform();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        WebElement mobiles = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobiles']")));
        mobiles.click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //DoubleClick
        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        action.doubleClick(doubleClick).perform();

        WebElement field2 = driver.findElement(By.cssSelector("[id='field2']"));
        String value = field2.getAttribute("value");
        System.out.println(value);

        //Drag and Drop
        WebElement source = driver.findElement(By.cssSelector("[id='draggable']"));
        WebElement target = driver.findElement(By.cssSelector("[id='droppable']"));
        action.dragAndDrop(source, target).perform();

        if (target.getText().contains("Dropped")){
            System.out.println("Successfully dropped");
        }else{
            System.out.println("Not dropped");
        }

        driver.quit();
    }
}
