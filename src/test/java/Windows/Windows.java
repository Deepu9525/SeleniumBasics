package Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Windows {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        //Tab
        String parentID = driver.getWindowHandle();
        System.out.println("Parent WindowID: " + parentID);
        driver.findElement(By.id("tabButton")).click();

        Set<String> allWindowIds = driver.getWindowHandles();
        System.out.println("All windows Id: " + allWindowIds);
        for (String childTab: allWindowIds){
            if (!childTab.equals(parentID)){
                driver.switchTo().window(childTab);
                break;
            }
        }
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Child window text: " + text);
        driver.close();
        driver.switchTo().window(parentID);

        //Window
        driver.findElement(By.xpath("//button[@id='tabButton']/parent::div/following-sibling::div[1]/button")).click();
        Set<String> windowIds = driver.getWindowHandles();
        System.out.println(windowIds);
        for (String childWindow: windowIds){
            if (!childWindow.equals(parentID)){
                driver.switchTo().window(childWindow);
                break;
            }
        }

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        driver.switchTo().window(parentID);

        //New window message
        driver.findElement(By.id("messageWindowButton")).click();
        Set<String> allWindowMessageIds = driver.getWindowHandles();
        System.out.println("All message window Id's: " + allWindowMessageIds);
        for (String childWindowMessaged: allWindowMessageIds){
            if (!childWindowMessaged.equals(parentID)){
                driver.switchTo().window(childWindowMessaged);
                break;
            }
        }
        System.out.println("Switched windows successfully");
        driver.close();
        driver.switchTo().window(parentID);
        driver.quit();

    }
}
