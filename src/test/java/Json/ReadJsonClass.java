package Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJsonClass {
    //JSON
    //Simple object
    //Read values
    //JSON array
    //Multiple records
    //Loop through records
    //JSON + Selenium test data

    public static void main(String[] args ) throws IOException {
        String filePath = System.getProperty("user.dir") + "//src/test//resources//TestDataData.json";

        //create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Read json file
        JsonNode jsonNode = objectMapper.readTree(new File(filePath));

        //Read single data from json
        String name = jsonNode.get("Name").asText();
        String email = jsonNode.get("Email").asText();

        //Print values
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        System.out.println("=========");

        //Read multiple data from Json
        JsonNode users = jsonNode.get("Users");
        for (JsonNode user: users){
            String userName = user.get("Name").asText();
            String userEmail = user.get("Email").asText();

            System.out.println("User Name: " + userName);
            System.out.println("User Email: " + userEmail);

        }
    }
}

