package Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExcelSeleniumAllRows {
    //Excel + Selenium Data-Driven Testing
    //Read all row from Excel and enter it into a web form
    public static void main(String[] args) throws IOException {
        //Excel file
        String filePath = System.getProperty("user.dir") + "//src//test//resources//TestData.xlsx";

        //Properties file
        String propertiesFile = System.getProperty("user.dir")+"//src//test//resources//config.properties";
        FileInputStream propertiesFileInputStream = new FileInputStream(propertiesFile);
        Properties properties = new Properties();
        properties.load(propertiesFileInputStream);

        //Read values
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("registrationUrl");

        System.out.println("Browser: " + browser);
        System.out.println("Url: " + url);

        //open excel
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Users");
        DataFormatter formatter = new DataFormatter();

        int lasRow = sheet.getLastRowNum();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Read all data rows
        for (int i = 1; i <= lasRow; i++) {
            //Read data from current row
            String name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
            String email = formatter.formatCellValue(sheet.getRow(i).getCell(1));
            String phone = formatter.formatCellValue(sheet.getRow(i).getCell(2));
            String address = formatter.formatCellValue(sheet.getRow(i).getCell(3));
            String gender = formatter.formatCellValue(sheet.getRow(i).getCell(4));

            System.out.println("Row " + i);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Address: " + address);
            System.out.println("Gender: " + gender);

            driver.get(url);

            driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);
            driver.findElement(By.cssSelector("[id='email']")).sendKeys(email);
            driver.findElement(By.cssSelector("[id='mobile']")).sendKeys(phone);
            driver.findElement(By.cssSelector("[placeholder='Currend Address']")).sendKeys(address);
            if (gender.trim().equalsIgnoreCase("Male")) {
                driver.findElement(By.xpath("//label[normalize-space()='Male']/preceding-sibling::input")).click();
            } else if (gender.trim().equalsIgnoreCase("Female")) {
                driver.findElement(By.xpath("//label[normalize-space()='Female']/preceding-sibling::input")).click();
            } else {
                throw new IllegalArgumentException("Invalid gender value in Excel: " + gender);
            }
        }

        driver.quit();
        fileInputStream.close();
        workbook.close();
        propertiesFileInputStream.close();
        System.out.println("All Excel rows entered successfully");
    }
}
