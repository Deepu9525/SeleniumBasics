package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdown2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        WebElement colors = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        Select dropDown = new Select(colors);
        dropDown.selectByIndex(2);
        Thread.sleep(500);
        dropDown.selectByValue("red");
        Thread.sleep(500);
        dropDown.selectByVisibleText("Purple");

        System.out.println("Selected option: " + dropDown.getFirstSelectedOption().getText());
        System.out.println("Multiple options: " + dropDown.isMultiple());

        List<WebElement> options = dropDown.getOptions();
        System.out.println("Total size: " + options.size());

        for (WebElement option : options){
            System.out.println("Total options: " + option.getText());
        }

        driver.quit();

    }

}
