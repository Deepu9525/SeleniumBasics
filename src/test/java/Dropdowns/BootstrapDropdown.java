package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdown {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.xpath("//div[@id='withOptGroup']")).click();

        List<WebElement> values = driver.findElements(By.cssSelector("[role='listbox']"));

        System.out.println("Select values dropdown");
        System.out.println("----------------------");

        for (WebElement value: values){
                System.out.println(value.getText());
        }

        driver.findElement(By.xpath("//div[text()='Group 2, option 2']")).click();

        driver.findElement(By.cssSelector("[id='selectOne']")).click();
        List<WebElement> titleValues = driver.findElements(By.cssSelector("[role='listbox']"));

        System.out.println();
        System.out.println("Select title dropdown");
        System.out.println("----------------------");

        for (WebElement titleValue: titleValues){
            System.out.println(titleValue.getText());
            }

        driver.findElement((By.xpath("//div[text()='Mrs.']"))).click();

        driver.quit();

        }
}

