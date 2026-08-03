package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicWebTableClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement dynamicTable = driver.findElement(By.id("taskTable"));
        js.executeScript("arguments[0].scrollIntoView();", dynamicTable);

        //Print all rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr"));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
        System.out.println("========");

        //find row dynamically
        for (WebElement row1: rows){
            String process = row1.findElement(By.xpath("./td[1]")).getText();
            if (process.equals("Chrome")){
                String cpu = row1.findElement(By.xpath("./td[3]")).getText();
                String network = row1.findElement(By.xpath("./td[4]")).getText();

                System.out.println("Process: " + process);
                System.out.println("Cpu values: " + cpu);
                System.out.println("Network values: " + network);
                break;
            }
        }
        System.out.println("========");

        //Highlighting element
        WebElement highlightingElement = driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"));
        js.executeScript("arguments[0].style.border='4px solid pink';" +
                "arguments[0].style.background='Yellow';", highlightingElement);

        //Print names
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//td[1]"));
        for (WebElement name : names) {
            System.out.print("Names: ");
            System.out.println(name.getText());
        }
        System.out.println("========");

        //Get chrome cpu value
        WebElement value = driver.findElement(By.xpath("//table[@id='taskTable']//td[text()='Chrome']/following-sibling::td[1]"));
        System.out.println("Cpu value: " + value.getText());
        System.out.println("========");

        //Get memory value
        WebElement memoryValue = driver.findElement(By.xpath("//table[@id='taskTable']//td[text()='Chrome']/following-sibling::td[2]"));
        System.out.println("Memory value: " + memoryValue.getText());
        System.out.println("========");

        //Verify Chrome Cpu matches the displayed value
        //Highlighting element
        WebElement highlightCpuValue = driver.findElement(By.xpath("(//div[@id='displayValues']//p)[1]"));
        js.executeScript("arguments[0].style.border='4px solid pink';" +
                "arguments[0].style.background='Yellow';", highlightCpuValue);
        String tableCpu = value.getText();
        String displayedCpuValue = driver.findElement(By.cssSelector("[class='chrome-cpu']")).getText();
        System.out.println(tableCpu);
        System.out.println(displayedCpuValue);
        System.out.println(displayedCpuValue.equals(tableCpu));
        driver.quit();
    }

    }