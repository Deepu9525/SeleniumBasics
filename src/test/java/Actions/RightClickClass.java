package Actions;

import Alerts.Alerts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement rightClick = driver.findElement(By.id("hot-spot"));
        action.contextClick(rightClick).perform();

        Alert alert = driver.switchTo().alert();
        System.out.println("RightClick message: " + alert.getText());
        alert.accept();
        driver.quit();
    }
}
