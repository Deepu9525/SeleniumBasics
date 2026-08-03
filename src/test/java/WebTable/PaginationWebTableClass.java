package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaginationWebTableClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement paginationTable = driver.findElement(By.cssSelector("[class='table-container']"));
        js.executeScript("arguments[0].scrollIntoView();", paginationTable);

        //Print number of pages
        int tablePagesCount = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
        System.out.println("Count number of pages in table: " + tablePagesCount);

        //Print product names from every page
        for (int i=1; i<=tablePagesCount; i++){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='pagination']//li[" + i + "]"))).click();
            //driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]")).click();
            System.out.println("Pagination table Page number: " + i);

            //Print product names
            System.out.print("Product names: ");
            System.out.println();
            List<WebElement> productNames = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr//td[2]"));
            for (WebElement productName: productNames){
                System.out.println(productName.getText());
            }
        }
        System.out.println("=========");

        //Print all rows from every page
        for (int i = 1; i<=tablePagesCount; i++) {
            driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]")).click();
            System.out.println("Rows from Page: " + i);

            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
            System.out.print("Each page row data: ");
            System.out.println();
            for (WebElement row : tableRows) {
                System.out.println(row.getText());
            }
            System.out.println("=========");
        }

        //Find smartphone and Click the checkbox
        for (int i=1; i<=tablePagesCount; i++){
            driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]")).click();
            List<WebElement> productRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
            for (WebElement product: productRows) {
                String productName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr//td[2]")).getText();
                if (productName.equals("Smartphone")){
                    String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr//td[3]")).getText();
                    System.out.println("Page number: " + i);
                    System.out.println("Price: " + price);
                    System.out.println("Product name: " + productName);

                    //Click checkbox
                    driver.findElement(By.xpath("(//td//input[@type='checkbox'])[1]")).click();
                    break;
                }
            }

        }
        driver.quit();
    }
}
