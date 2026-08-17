package Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesClass {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "//src//test/resources/config.properties";

        //Reading properties file
        FileInputStream propertiesFile = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(propertiesFile);

        //Read values
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");

        System.out.println("Browser=" + browser);
        System.out.println("URL=" + url);
        propertiesFile.close();

        //Dynamic browser selection
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();

        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else{
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.quit();
    }
}
