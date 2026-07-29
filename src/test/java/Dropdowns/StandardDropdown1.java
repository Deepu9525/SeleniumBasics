package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StandardDropdown1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dropDown = driver.findElement(By.cssSelector("select[id='country']"));

        Select select = new Select(dropDown);

        select.selectByValue("india");

        select.selectByVisibleText("Australia");

        select.selectByIndex(1);

        System.out.println("Selected Country: " + select.getFirstSelectedOption().getText());

        //Capture the options
        List<WebElement> options = select.getOptions();
        System.out.println("Total options: " + options.size());

        //Printing options
        for(WebElement option : options){
            System.out.println("Printing options: " + option.getText());
        }

//        for(int i = 0 ; i < options.size(); i++){
//            System.out.println("Printing options: " + options.get(i).getText());
//        }

        driver.quit();

    }

}
