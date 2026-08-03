package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class StaticWebTableClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement table = driver.findElement(By.cssSelector("[name='BookTable']"));
        js.executeScript("arguments[0].scrollIntoView(true);", table);

        //Rows and columns count
        List<WebElement> rows = driver.findElements(By.cssSelector("[name='BookTable'] tr"));
        List<WebElement> columns = driver.findElements(By.cssSelector("[name='BookTable'] tr th"));
        System.out.println("Number of rows heading: " + rows.size());
        System.out.println("Number of rows: " + (rows.size()-1));
        System.out.println("Number of columns: " + columns.size());
        System.out.println("==========");

        //Print the table data
        for (WebElement row: rows){
            System.out.println(row.getText());
        }
        System.out.println("==========");

        //Print only table headers
        System.out.println("Table headings: ");
        for (WebElement column: columns){
            System.out.print(column.getText() + " ");
        }

        System.out.println();
        System.out.println("==========");

        //Print only first row data
        WebElement firstRow = driver.findElement(By.cssSelector("[name='BookTable'] tr:nth-child(2)"));
        System.out.println("FirstRow data: " + firstRow.getText());
        System.out.println("==========");

        //Print specific cell value (row & column)
        //[name='BookTable'] tr:nth-child(2) td:nth-child(3)
        WebElement specificValue = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[3]"));
        System.out.println("Printing Specific cell value(row & column): " + specificValue.getText());
        System.out.println("==========");

        //Print all book names
        List<WebElement> bookNames = driver.findElements(By.xpath("//table[@name='BookTable']//td[1]"));
        for (WebElement bookName: bookNames) {
            System.out.println("BookName: " + bookName.getText());
        }
        System.out.println("==========");

        //Print all Author names
        List<WebElement> authorNames = driver.findElements(By.xpath("//table[@name='BookTable']//td[2]"));
        for (WebElement author: authorNames){
            System.out.println("Author: " + author.getText());
        }
        System.out.println("==========");

        //Calculate total price of all books
        List<WebElement> prices = driver.findElements(By.xpath("//table[@name='BookTable']//td[4]"));
        int total = 0;
        for (WebElement price: prices){
            total = total+Integer.parseInt(price.getText());
        }
        System.out.println("Total price: " + total);
        System.out.println("==========");

        //Find book based on author name
        List<WebElement> rowValues = table.findElements(By.tagName("tr"));
        //List<WebElement> rowValues = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        for (WebElement rowValue: rowValues){
            if (rowValue.getText().contains("Amit")){
                System.out.print("Book name for specific author: ");
                System.out.println(rowValue.getText());
            }
        }
        System.out.println("==========");

        //Verifying particular value in table
        List<WebElement> books = table.findElements(By.tagName("td"));
        //List<WebElement> books = driver.findElements(By.xpath("//table[@name='BookTable']//td"));
        boolean status = false;
        for (WebElement bookValue: books){
            if (bookValue.getText().contains("Learn Java")){
                status=true;
                break;
            }
        }
        System.out.println(status);

        driver.quit();
    }
}
