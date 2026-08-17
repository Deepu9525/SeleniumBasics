package Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSeleniumClass {
    //Excel + Selenium Data-Driven Testing
    //Read one row from Excel and enter it into a web form
    public static void main(String[] args) throws IOException, InterruptedException {
        String testDataFilePath = System.getProperty("user.dir")+ "//src//test//resources//TestData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(testDataFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Users");
        DataFormatter formatter = new DataFormatter();

        //Read first data row
        String name = formatter.formatCellValue(sheet.getRow(1).getCell(0));
        String email = formatter.formatCellValue(sheet.getRow(1).getCell(1));
        String phone = formatter.formatCellValue(sheet.getRow(1).getCell(2));
        String address = formatter.formatCellValue(sheet.getRow(1).getCell(3));
        String gender = formatter.formatCellValue(sheet.getRow(1).getCell(4));

        //Print excel data
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);

        fileInputStream.close();
        workbook.close();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[id='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[id='mobile']")).sendKeys(phone);
        driver.findElement(By.cssSelector("[placeholder='Currend Address']")).sendKeys(address);
        if(gender.equalsIgnoreCase("Male")){
            driver.findElement(By.xpath("//label[normalize-space()='Male']/preceding-sibling::input")).click();
        }else if(gender.equalsIgnoreCase("Female")){
            driver.findElement(By.xpath("//label[normalize-space()='Female']/preceding-sibling::input")).click();
        }else{
            throw new IllegalArgumentException("Invalid gender value in Excel: " + gender);
        }
        Thread.sleep(500);
        driver.quit();
    }
}
