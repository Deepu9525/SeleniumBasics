package Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Alerts {
    private static final Logger log = LoggerFactory.getLogger(Alerts.class);

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        //Normal Alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[id='alertButton']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Click button to see an alert message: " + alert.getText());
        alert.accept();

        //Timer Alert
        driver.findElement(By.cssSelector("[id='timerAlertButton']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        System.out.println("Alert will appear after 5 seconds: " + alert.getText());
        alert.accept();

        //Confirmation
        driver.findElement(By.id("confirmButton")).click();
        alert = driver.switchTo().alert();
        System.out.println("Confirmation alert message: " + alert.getText());
        alert.dismiss();

        String confirmationActual = driver.findElement(By.id("confirmResult")).getText();
        System.out.println(confirmationActual);
        if (confirmationActual.contains("Cancel")){
            System.out.println("Clicked on Cancel");
        }else{
            System.out.println("Clicked on Ok");
        }

        //Prompt
        driver.findElement(By.id("promtButton")).click();
        alert = driver.switchTo().alert();
        System.out.println("Prompt message: " + alert.getText());
        alert.sendKeys("Welcome");
        alert.accept();

        String promptActual = driver.findElement(By.id("promptResult")).getText();
        System.out.println("Prompt message: " + promptActual);
        if (promptActual.contains("You entered")){
            System.out.println("Clicked on Ok");
        }else{
            System.out.println("Clicked on Cancel");
        }

        driver.quit();

    }
}
