package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Practice {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(dropdown);
        select.selectByIndex(9);

        System.out.println(select.getFirstSelectedOption());
        System.out.println(select.isMultiple());

        List<WebElement> options = select.getOptions();
        System.out.println(options.size());


        for (WebElement option: options){
            System.out.println(option.getText());
        }

        driver.quit();
    }
}
