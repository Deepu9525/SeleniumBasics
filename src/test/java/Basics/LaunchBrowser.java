package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
   public static void main(String[] args) {
      WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();

      driver.get("https://automationexercise.com");

      System.out.println("Title: " + driver.getTitle());

      System.out.println("Current Url: " + driver.getCurrentUrl());

      driver.quit();

   }
}
