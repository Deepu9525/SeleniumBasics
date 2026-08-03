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

public class PaginationWebTableComplete {
    public static void main(String[] args) {
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

        boolean found = false;

        //Loop through all pages
        for (int i = 1; i<=tablePagesCount;i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='pagination']//li[" + i + "]"))).click();
            //driver.findElement(By.xpath("//ul[@id='pagination']//li[" + i + "]")).click();
            System.out.println("Pagination table Page number: " + i);

            //Get all rows of current page
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));

            // Loop through each row
            for (WebElement tableRow : tableRows) {
                String productName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr//td[2]")).getText();
                if (productName.equals("Smartphone")) {
                    String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr//td[3]")).getText();

                    //Click checkbox
                    driver.findElement(By.xpath("(//td//input[@type='checkbox'])[1]")).click();
                    System.out.println("=========");
                    System.out.println("Product Found");
                    System.out.println("Product Name : " + productName);
                    System.out.println("Price        : " + price);
                    System.out.println("=========");

                    found = true;
                    break;

                }

            }
            if (found) {
                break;
            }
        }

            if (!found) {
                    System.out.println("Product not found.");
            }

            driver.quit();
    }
}
