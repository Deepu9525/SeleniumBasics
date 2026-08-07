package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //using sendKeys()
        String path = "C://Users//Admin//Desktop//Deepu//File.txt";
        WebElement file = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
        file.sendKeys(path);
        js.executeScript("arguments[0].scrollIntoView();", file);

        //Upload file
        driver.findElement(By.xpath("//button[@type='submit' and text()='Upload Single File']")).click();

        //Get upload status element
        WebElement statusElement = driver.findElement(By.cssSelector("[id='singleFileStatus']"));
        String fileStatus = statusElement.getText();
        System.out.println(fileStatus);

        //Highlight status
        js.executeScript("arguments[0].style.border='4px solid yellow';" +
                "arguments[0].style.background='pink';", statusElement);

        //Verify file uploaded
        if (fileStatus.contains("Single file selected:")){
            System.out.println("Single file uploaded: " + fileStatus);
        }else {
            System.out.println("File not selected");
        }

        //upload multiple files
        String multipleFiles = "C://Users//Admin//Desktop//Deepu//File1.txt\n" +
                               "C://Users//Admin//Desktop//Deepu//File2.txt\n" +
                               "C://Users//Admin//Desktop//Deepu//File3.txt";
        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
        fileUpload.sendKeys(multipleFiles);

        //Click on upload files
        driver.findElement(By.xpath("//button[@type='submit' and text()='Upload Multiple Files']")).click();
        String multipleFilesStatus = driver.findElement(By.xpath("//p[@id='multipleFilesStatus']")).getText();
        System.out.println("Multiple files uploaded status: " + multipleFilesStatus);
        if (multipleFilesStatus.contains("Multiple files selected:")){
            System.out.println("Multiple files uploaded: " + multipleFilesStatus);
        }else {
            System.out.println("Multiples files not selected");
        }

        driver.quit();
    }
}
