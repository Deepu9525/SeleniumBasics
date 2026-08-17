package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JsonWithSeleniumClass {
    public static void main(String[] args) throws IOException {
        //config.properties file path
        String propertiesPath = System.getProperty("user.dir")+ "//src//test//resources//config.properties";

        //Reading properties file
        FileInputStream fileInputStream = new FileInputStream(propertiesPath);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        //Read the values from file
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");

        System.out.println("Browser= " + browser);
        System.out.println("Url= " + url);
        fileInputStream.close();

        //Json filepath
        String jsonPath = System.getProperty("user.dir")+ "//src//test//resources//TestDataData.json";

        //Read Json
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(new File(jsonPath));

        //Read single data from Json
        String name = jsonNode.get("Name").asText();
        String email = jsonNode.get("Email").asText();

        System.out.println("Name= " + name);
        System.out.println("Email= " + email);

        //Launch the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //Enter Json data into a webpage
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[id='email']")).sendKeys(email);
        System.out.println("Single data entered successfully");

        //Read multiple json data
        JsonNode users = jsonNode.get("Users");
        for (JsonNode user: users){
            String userName = user.get("Name").asText();
            String userEmail = user.get("Email").asText();

            System.out.println("Name: " + userName);
            System.out.println("Email: " + userEmail);
            //Clear fields before using multiple data
            driver.findElement(By.cssSelector("[id='name']")).clear();
            driver.findElement(By.cssSelector("[id='email']")).clear();

            //Enter each user into the webpage
            driver.findElement(By.cssSelector("[id='name']")).sendKeys(userName);
            driver.findElement(By.cssSelector("[id='email']")).sendKeys(userEmail);
            System.out.println("Json data entered successfully");
        }
        driver.quit();
    }
}
