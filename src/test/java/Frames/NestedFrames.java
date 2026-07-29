package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NestedFrames {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total frames: " + frames.size());

        //Parent frame
        WebElement parentFrame = driver.findElement(By.id("frame1"));
        System.out.println("Height: " + parentFrame.getSize().getHeight());
        System.out.println("Width: " + parentFrame.getSize().getWidth());

        driver.switchTo().frame(parentFrame);
        String parentFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println(parentFrameText);

        //Child frame
        WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrame);
        String childFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println(childFrameText);

        driver.switchTo().parentFrame();
        System.out.println("Back to Parent frame");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        driver.quit();

    }
}
