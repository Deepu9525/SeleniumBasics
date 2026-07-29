package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FramesHandling {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());

        //Using WebElement
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement frameText1 = driver.findElement(By.id("sampleHeading"));
        System.out.println("frame1: " + frameText1.getText());
        System.out.println("Height: " + frameText1.getSize().getHeight());
        System.out.println("Width: " + frameText1.getSize().getWidth());

        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2);
        WebElement frameText2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame2: " + frameText2.getText());
        String color = frameText2.getCssValue("color");
        System.out.println(color);

        //Using index to switch frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        //Using name or id
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        driver.quit();
    }
}
